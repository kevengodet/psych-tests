package com.psychtests.data.content

import com.psychtests.data.model.*

object ScoffTest {

    fun build(): Test = Test(
        id = "scoff",
        key = "scoff",
        category = TestCategory.EATING,
        title = mapOf(
            "en" to "SCOFF Eating Disorder Questionnaire",
            "fr" to "Questionnaire SCOFF sur les troubles alimentaires",
            "es" to "Cuestionario SCOFF de Trastornos de la Conducta Alimentaria"
        ),
        description = mapOf(
            "en" to "Five-question screening tool for eating disorders.",
            "fr" to "Outil de dépistage en cinq questions des troubles alimentaires.",
            "es" to "Instrumento de cribado de cinco preguntas para los trastornos de la conducta alimentaria."
        ),
        instructions = mapOf(
            "en" to "Please answer the following five questions as honestly as possible.",
            "fr" to "Veuillez répondre aux cinq questions suivantes aussi honnêtement que possible.",
            "es" to "Por favor, responda a las siguientes cinco preguntas con la mayor sinceridad posible."
        ),
        questions = listOf(
            Question("scoff1", mapOf(
                "en" to "Do you make yourself sick because you feel uncomfortably full?",
                "fr" to "Vous faites-vous vomir parce que vous vous sentez inconfortablement rassasié(e) ?",
                "es" to "¿Se provoca el vómito porque se siente incómodamente lleno(a)?"
            ), scoffOptions()),
            Question("scoff2", mapOf(
                "en" to "Do you worry you have lost control over how much you eat?",
                "fr" to "Craignez-vous d'avoir perdu le contrôle sur la quantité de nourriture que vous mangez ?",
                "es" to "¿Le preocupa haber perdido el control sobre la cantidad de comida que ingiere?"
            ), scoffOptions()),
            Question("scoff3", mapOf(
                "en" to "Have you recently lost more than six kilograms (about one stone) in a three-month period?",
                "fr" to "Avez-vous récemment perdu plus de six kilos en une période de trois mois ?",
                "es" to "¿Ha perdido recientemente más de seis kilos en un período de tres meses?"
            ), scoffOptions()),
            Question("scoff4", mapOf(
                "en" to "Do you believe yourself to be fat when others say you are too thin?",
                "fr" to "Vous considérez-vous comme gros(se) alors que les autres vous disent trop mince ?",
                "es" to "¿Se considera usted gordo(a) cuando los demás dicen que está demasiado delgado(a)?"
            ), scoffOptions()),
            Question("scoff5", mapOf(
                "en" to "Would you say that food dominates your life?",
                "fr" to "Diriez-vous que la nourriture domine votre vie ?",
                "es" to "¿Diría que la comida domina su vida?"
            ), scoffOptions())
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 5,
            thresholds = listOf(
                ScoreThreshold(0, 1, mapOf(
                    "en" to "Low likelihood of eating disorder",
                    "fr" to "Faible probabilité de trouble alimentaire",
                    "es" to "Baja probabilidad de trastorno alimentario"
                ), mapOf(
                    "en" to "Your score suggests a low likelihood of an eating disorder. Continue to maintain healthy eating habits.",
                    "fr" to "Votre score suggère une faible probabilité de trouble alimentaire. Continuez à maintenir des habitudes alimentaires saines.",
                    "es" to "Su puntuación sugiere una baja probabilidad de un trastorno alimentario. Continúe manteniendo hábitos alimentarios saludables."
                ), SeverityLevel.NONE),
                ScoreThreshold(2, 2, mapOf(
                    "en" to "Further evaluation recommended",
                    "fr" to "Évaluation complémentaire recommandée",
                    "es" to "Evaluación adicional recomendada"
                ), mapOf(
                    "en" to "Your score of 2 suggests that further evaluation may be useful. Consider speaking with a healthcare professional.",
                    "fr" to "Votre score de 2 suggère qu'une évaluation complémentaire pourrait être utile. Envisagez de parler avec un professionnel de santé.",
                    "es" to "Su puntuación de 2 sugiere que una evaluación adicional podría ser útil. Considere hablar con un profesional de la salud."
                ), SeverityLevel.MILD),
                ScoreThreshold(3, 5, mapOf(
                    "en" to "High likelihood of eating disorder",
                    "fr" to "Probabilité élevée de trouble alimentaire",
                    "es" to "Alta probabilidad de trastorno alimentario"
                ), mapOf(
                    "en" to "Your score suggests a high likelihood of an eating disorder. We strongly recommend consulting a healthcare professional.",
                    "fr" to "Votre score suggère une probabilité élevée de trouble alimentaire. Nous vous recommandons fortement de consulter un professionnel de santé.",
                    "es" to "Su puntuación sugiere una alta probabilidad de un trastorno alimentario. Le recomendamos encarecidamente consultar a un profesional de la salud."
                ), SeverityLevel.MODERATE)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Morgan, J.F., Reid, F., Lacey, J.H. (1999). The SCOFF questionnaire: Assessment of a new screening tool for eating disorders. BMJ, 319(7223), 1467-1468.",
        estimatedDurationMinutes = 1
    )

    private fun scoffOptions(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "No",
            "fr" to "Non",
            "es" to "No"
        )),
        AnswerOption(1, mapOf(
            "en" to "Yes",
            "fr" to "Oui",
            "es" to "Sí"
        ))
    )
}