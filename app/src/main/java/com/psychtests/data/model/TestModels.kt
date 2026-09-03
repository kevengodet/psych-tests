package com.psychtests.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.psychtests.data.db.Converters
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Test(
    val id: String,
    val key: String,
    val category: TestCategory,
    val title: Map<String, String>,
    val description: Map<String, String>,
    val instructions: Map<String, String>,
    val questions: List<Question>,
    val scoring: ScoringMethod,
    val availableLanguages: List<String>,
    val version: String = "1.0",
    val reference: String = "",
    val estimatedDurationMinutes: Int = 5
)

@Serializable
data class Question(
    val id: String,
    val text: Map<String, String>,
    val options: List<AnswerOption>,
    val subscale: String? = null,
    val reverseScored: Boolean = false
)

@Serializable
data class AnswerOption(
    val value: Int,
    val label: Map<String, String>
)

enum class TestCategory(val displayOrder: Int) {
    DEPRESSION(1),
    ANXIETY(2),
    STRESS(3),
    TRAUMA(4),
    WELLBEING(5),
    SLEEP(6),
    SUBSTANCE(7),
    EATING(8),
    ADHD(9),
    PERSONALITY(10),
    OTHER(99)
}

@Serializable
sealed interface ScoringMethod {
    @Serializable
    data class SumScoring(
        val minScore: Int,
        val maxScore: Int,
        val thresholds: List<ScoreThreshold>,
        val subscales: Map<String, SubscaleConfig> = emptyMap()
    ) : ScoringMethod

    @Serializable
    data class MeanScoring(
        val minScore: Double,
        val maxScore: Double,
        val thresholds: List<ScoreThreshold>
    ) : ScoringMethod

    @Serializable
    data class CustomScoring(
        val calculator: String,
        val thresholds: List<ScoreThreshold>
    ) : ScoringMethod
}

@Serializable
data class ScoreThreshold(
    val minScore: Int,
    val maxScore: Int,
    val label: Map<String, String>,
    val interpretation: Map<String, String>,
    val severity: SeverityLevel
)

enum class SeverityLevel(val color: String) {
    NONE("#4CAF50"),
    MINIMAL("#8BC34A"),
    MILD("#FFEB3B"),
    MODERATE("#FF9800"),
    MODERATELY_SEVERE("#FF5722"),
    SEVERE("#F44336"),
    EXTREME("#B71C1C")
}

@Serializable
data class SubscaleConfig(
    val questionIds: List<String>,
    val minScore: Int,
    val maxScore: Int,
    val thresholds: List<ScoreThreshold>
)

@Entity(tableName = "test_results")
@TypeConverters(Converters::class)
data class TestResult(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val testId: String,
    val testKey: String,
    val testTitle: String,
    val language: String,
    val score: Double,
    val maxScore: Double,
    val subscaleScores: Map<String, Double>,
    val severity: SeverityLevel,
    val severityLabel: String,
    val interpretation: String,
    val responses: Map<String, Int>,
    val completedAt: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
    val durationSeconds: Long = 0
)

@Entity(tableName = "user_preferences")
data class UserPreferences(
    @PrimaryKey val key: String = "app_prefs",
    val preferredLanguage: String = "en",
    val theme: String = "system",
    val showDisclaimer: Boolean = true,
    val lastSyncAt: LocalDateTime? = null
)

@Serializable
data class TestSession(
    val testId: String,
    val language: String,
    val responses: MutableMap<String, Int> = mutableMapOf(),
    val currentQuestionIndex: Int = 0,
    val startTime: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
    val isCompleted: Boolean = false
)