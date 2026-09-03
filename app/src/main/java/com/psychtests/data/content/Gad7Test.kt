package com.psychtests.data.content

import com.psychtests.data.model.*

object Gad7Test {

    fun build(): Test = Test(
        id = "gad7",
        key = "gad7",
        category = TestCategory.ANXIETY,
        title = mapOf(
            "en" to "Generalized Anxiety Disorder Scale (GAD-7)",
            "fr" to "Échelle du trouble anxieux généralisé (GAD-7)",
            "es" to "Escala de Trastorno de Ansiedad Generalizada (GAD-7)"
        ),
        description = mapOf(
            "en" to "Screening measure for the severity of generalized anxiety symptoms over the past two weeks.",
            "fr" to "Outil de dépistage de la sévérité des symptômes d'anxiété généralisée au cours des deux dernières semaines.",
            "es" to "Instrumento de cribado de la gravedad de los síntomas de ansiedad generalizada durante las últimas dos semanas."
        ),
        instructions = mapOf(
            "en" to "Over the last 2 weeks, how often have you been bothered by the following problems?",
            "fr" to "Au cours des 2 dernières semaines, à quelle fréquence avez-vous été gêné(e) par les problèmes suivants ?",
            "es" to "Durante las últimas 2 semanas, ¿con qué frecuencia le han molestado los siguientes problemas?"
        ),
        questions = listOf(
            Question(
                id = "gad1",
                text = mapOf(
                    "en" to "Feeling nervous, anxious, or on edge",
                    "fr" to "Se sentir nerveux(se), anxieux(se), ou sur les nerfs",
                    "es" to "Sentirse nervioso(a), ansioso(a) o muy tenso(a)"
                ),
                options = gadOptions()
            ),
            Question(
                id = "gad2",
                text = mapOf(
                    "en" to "Not being able to stop or control worrying",
                    "fr" to "Ne pas arriver à arrêter ou à contrôler ses inquiétudes",
                    "es" to "No poder dejar de preocuparse o no poder controlar la preocupación"
                ),
                options = gadOptions()
            ),
            Question(
                id = "gad3",
                text = mapOf(
                    "en" to "Worrying too much about different things",
                    "fr" to "Se faire du souci à propos de différentes choses",
                    "es" to "Preocuparse demasiado por diferentes cosas"
                ),
                options = gadOptions()
            ),
            Question(
                id = "gad4",
                text = mapOf(
                    "en" to "Trouble relaxing",
                    "fr" to "Avoir du mal à se détendre",
                    "es" to "Dificultad para relajarse"
                ),
                options = gadOptions()
            ),
            Question(
                id = "gad5",
                text = mapOf(
                    "en" to "Being so restless that it's hard to sit still",
                    "fr" to "Être si agité(e) qu'il est difficile de rester assis(e) sans bouger",
                    "es" to "Estar tan inquieto(a) que le resulta difícil permanecer sentado(a)"
                ),
                options = gadOptions()
            ),
            Question(
                id = "gad6",
                text = mapOf(
                    "en" to "Becoming easily annoyed or irritable",
                    "fr" to "Devenir facilement contrarié(e) ou irritable",
                    "es" to "Sentirse fácilmente molesto(a) o irritable"
                ),
                options = gadOptions()
            ),
            Question(
                id = "gad7",
                text = mapOf(
                    "en" to "Feeling afraid as if something awful might happen",
                    "fr" to "Ressentir de la peur, comme si quelque chose de terrible allait se produire",
                    "es" to "Sentir miedo, como si algo terrible pudiera suceder"
                ),
                options = gadOptions()
            )
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 21,
            thresholds = listOf(
                ScoreThreshold(0, 4, mapOf(
                    "en" to "Minimal anxiety",
                    "fr" to "Anxiété minimale",
                    "es" to "Ansiedad mínima"
                ), mapOf(
                    "en" to "Your score suggests minimal anxiety symptoms. Continue to monitor your wellbeing and seek support if needed.",
                    "fr" to "Votre score suggère des symptômes d'anxiété minimaux. Continuez à surveiller votre bien-être et demandez du soutien si nécessaire.",
                    "es" to "Su puntuación sugiere síntomas de ansiedad mínimos. Continúe monitorizando su bienestar y busque apoyo si es necesario."
                ), SeverityLevel.MINIMAL),
                ScoreThreshold(5, 9, mapOf(
                    "en" to "Mild anxiety",
                    "fr" to "Anxiété légère",
                    "es" to "Ansiedad leve"
                ), mapOf(
                    "en" to "Your score suggests mild anxiety symptoms. Consider speaking with a healthcare professional if symptoms persist.",
                    "fr" to "Votre score suggère des symptômes d'anxiété légers. Envisagez de parler avec un professionnel de santé si les symptômes persistent.",
                    "es" to "Su puntuación sugiere síntomas de ansiedad leves. Considere hablar con un profesional de la salud si los síntomas persisten."
                ), SeverityLevel.MILD),
                ScoreThreshold(10, 14, mapOf(
                    "en" to "Moderate anxiety",
                    "fr" to "Anxiété modérée",
                    "es" to "Ansiedad moderada"
                ), mapOf(
                    "en" to "Your score suggests moderate anxiety symptoms. Professional evaluation is recommended.",
                    "fr" to "Votre score suggère des symptômes d'anxiété modérés. Une évaluation professionnelle est recommandée.",
                    "es" to "Su puntuación sugiere síntomas de ansiedad moderados. Se recomienda una evaluación profesional."
                ), SeverityLevel.MODERATE),
                ScoreThreshold(15, 21, mapOf(
                    "en" to "Severe anxiety",
                    "fr" to "Anxiété grave",
                    "es" to "Ansiedad grave"
                ), mapOf(
                    "en" to "Your score suggests severe anxiety symptoms. We strongly recommend consulting a mental health professional as soon as possible.",
                    "fr" to "Votre score suggère des symptômes d'anxiété graves. Nous vous recommandons fortement de consulter un professionnel de la santé mentale dès que possible.",
                    "es" to "Su puntuación sugiere síntomas de ansiedad graves. Le recomendamos encarecidamente consultar a un profesional de la salud mental lo antes posible."
                ), SeverityLevel.SEVERE)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Spitzer, R.L., Kroenke, K., Williams, J.B.W., Löwe, B. (2006). A brief measure for assessing generalized anxiety disorder. Archives of Internal Medicine, 166(10), 1092-1097.",
        estimatedDurationMinutes = 2
    )

    private fun gadOptions(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "Not at all",
            "fr" to "Jamais",
            "es" to "Nunca"
        )),
        AnswerOption(1, mapOf(
            "en" to "Several days",
            "fr" to "Plusieurs jours",
            "es" to "Varios días"
        )),
        AnswerOption(2, mapOf(
            "en" to "More than half the days",
            "fr" to "Plus de la moitié des jours",
            "es" to "Más de la mitad de los días"
        )),
        AnswerOption(3, mapOf(
            "en" to "Nearly every day",
            "fr" to "Presque tous les jours",
            "es" to "Casi todos los días"
        ))
    )
}