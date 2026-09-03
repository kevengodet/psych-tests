package com.psychtests.util

import com.psychtests.data.model.*
import kotlin.math.round

object ScoringEngine {

    data class ScoreResult(
        val totalScore: Double,
        val maxScore: Double,
        val normalizedScore: Double,
        val severity: SeverityLevel,
        val severityLabel: String,
        val interpretation: String,
        val subscaleResults: Map<String, SubscaleResult>
    )

    data class SubscaleResult(
        val score: Double,
        val maxScore: Double,
        val severity: SeverityLevel?,
        val severityLabel: String?,
        val interpretation: String?
    )

    fun score(
        test: Test,
        responses: Map<String, Int>,
        language: String
    ): ScoreResult {
        var total = 0.0
        val subscaleTotals = mutableMapOf<String, Double>()
        val subscaleResponses = mutableMapOf<String, MutableList<Int>>()

        test.questions.forEach { q ->
            val response = responses[q.id] ?: 0
            val options = q.options
            var value = response
            if (q.reverseScored) {
                // Reverse: newValue = maxOption + minOption - value
                val max = options.lastOrNull()?.value ?: 0
                val min = options.firstOrNull()?.value ?: 0
                value = (max + min) - value
            }
            total += value

            val subscale = q.subscale
            if (subscale != null) {
                subscaleTotals[subscale] = (subscaleTotals[subscale] ?: 0.0) + value
                subscaleResponses[subscale]?.add(value) ?: run {
                    subscaleResponses[subscale] = mutableListOf(value)
                }
            }
        }

        val scoring = test.scoring
        val thresholds = when (scoring) {
            is ScoringMethod.SumScoring -> scoring.thresholds
            is ScoringMethod.MeanScoring -> scoring.thresholds
            is ScoringMethod.CustomScoring -> scoring.thresholds
        }

        val (severity, label, interpretation) = evaluateThresholds(thresholds, total, language)

        // Subscale evaluation
        val subscaleResults = if (scoring is ScoringMethod.SumScoring && scoring.subscales.isNotEmpty()) {
            scoring.subscales.map { (name, config) ->
                val score = subscaleTotals[name] ?: 0.0
                val subThreshold = config.thresholds
                val subSeverity = subThreshold.firstOrNull { score >= it.minScore && score <= it.maxScore }
                name to SubscaleResult(
                    score = score,
                    maxScore = config.maxScore.toDouble(),
                    severity = subSeverity?.severity,
                    severityLabel = subSeverity?.label?.get(language),
                    interpretation = subSeverity?.interpretation?.get(language)
                )
            }.toMap()
        } else emptyMap()

        val maxScore: Double = when (scoring) {
            is ScoringMethod.SumScoring -> scoring.maxScore.toDouble()
            is ScoringMethod.MeanScoring -> scoring.maxScore
            is ScoringMethod.CustomScoring -> (scoring.thresholds.lastOrNull()?.maxScore ?: total).toDouble()
        }

        val normalized = if (maxScore > 0) round(total / maxScore * 100) else 0.0

        return ScoreResult(
            totalScore = total,
            maxScore = maxScore,
            normalizedScore = normalized,
            severity = severity,
            severityLabel = label,
            interpretation = interpretation,
            subscaleResults = subscaleResults
        )
    }

    private fun evaluateThresholds(
        thresholds: List<ScoreThreshold>,
        score: Double,
        language: String
    ): Triple<SeverityLevel, String, String> {
        val matched = thresholds.firstOrNull {
            score >= it.minScore && score <= it.maxScore
        } ?: thresholds.lastOrNull()
            ?: return Triple(
                SeverityLevel.NONE,
                "",
                ""
            )
        return Triple(
            matched.severity,
            matched.label[language] ?: matched.label["en"] ?: "",
            matched.interpretation[language] ?: matched.interpretation["en"] ?: ""
        )
    }
}