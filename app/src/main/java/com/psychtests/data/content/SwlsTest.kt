package com.psychtests.data.content

import com.psychtests.data.model.*

object SwlsTest {

    fun build(): Test = Test(
        id = "swls",
        key = "swls",
        category = TestCategory.WELLBEING,
        title = mapOf(
            "en" to "Satisfaction With Life Scale (SWLS)",
            "fr" to "Échelle de satisfaction de vie (SWLS)",
            "es" to "Escala de Satisfacción con la Vida (SWLS)"
        ),
        description = mapOf(
            "en" to "Measures global cognitive judgments of satisfaction with one's life.",
            "fr" to "Mesure les jugements cognitifs globaux de satisfaction avec sa vie.",
            "es" to "Mide los juicios cognitivos globales de satisfacción con la vida."
        ),
        instructions = mapOf(
            "en" to "Below are five statements that you may agree or disagree with. Using the 1-7 scale below, indicate your agreement with each item. Please be open and honest in your responding.",
            "fr" to "Voici cinq affirmations avec lesquelles vous pouvez être d'accord ou en désaccord. En utilisant l'échelle de 1 à 7 ci-dessous, indiquez votre degré d'accord avec chaque affirmation. Veuillez répondre ouvertement et honnêtement.",
            "es" to "A continuación hay cinco afirmaciones con las que puede estar de acuerdo o en desacuerdo. Utilizando la escala de 1 a 7, indique su grado de acuerdo con cada enunciado. Por favor, responda de forma abierta y honesta."
        ),
        questions = listOf(
            Question("swls1", mapOf(
                "en" to "In most ways my life is close to my ideal",
                "fr" to "En général, ma vie correspond bien à mes idéaux",
                "es" to "En la mayoría de los aspectos, mi vida se acerca a mi ideal"
            ), swlsOptions()),
            Question("swls2", mapOf(
                "en" to "The conditions of my life are excellent",
                "fr" to "Mes conditions de vie sont excellentes",
                "es" to "Las condiciones de mi vida son excelentes"
            ), swlsOptions()),
            Question("swls3", mapOf(
                "en" to "I am satisfied with my life",
                "fr" to "Je suis satisfait(e) de ma vie",
                "es" to "Estoy satisfecho(a) con mi vida"
            ), swlsOptions()),
            Question("swls4", mapOf(
                "en" to "So far I have gotten the important things I want in life",
                "fr" to "Jusqu'à maintenant, j'ai obtenu les choses importantes que je voulais dans la vie",
                "es" to "Hasta ahora he conseguido las cosas importantes que quiero en la vida"
            ), swlsOptions()),
            Question("swls5", mapOf(
                "en" to "If I could live my life over, I would change almost nothing",
                "fr" to "Si je pouvais recommencer ma vie, je ne changerais presque rien",
                "es" to "Si pudiera vivir mi vida de nuevo, no cambiaría casi nada"
            ), swlsOptions())
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 5,
            maxScore = 35,
            thresholds = listOf(
                ScoreThreshold(5, 9, mapOf(
                    "en" to "Extremely dissatisfied",
                    "fr" to "Extrêmement insatisfait(e)",
                    "es" to "Extremadamente insatisfecho(a)"
                ), mapOf(
                    "en" to "Your score indicates you are extremely dissatisfied with life. Speaking with a professional could be beneficial.",
                    "fr" to "Votre score indique un niveau d'insatisfaction extrême avec la vie. Parler avec un professionnel pourrait être bénéfique.",
                    "es" to "Su puntuación indica que está extremadamente insatisfecho(a) con la vida. Hablar con un profesional podría ser beneficioso."
                ), SeverityLevel.SEVERE),
                ScoreThreshold(10, 14, mapOf(
                    "en" to "Dissatisfied",
                    "fr" to "Insatisfait(e)",
                    "es" to "Insatisfecho(a)"
                ), mapOf(
                    "en" to "Your score indicates you are dissatisfied with life. Consider exploring ways to improve your satisfaction.",
                    "fr" to "Votre score indique un niveau d'insatisfaction avec la vie. Envisagez d'explorer des moyens d'améliorer votre satisfaction.",
                    "es" to "Su puntuación indica que está insatisfecho(a) con la vida. Considere explorar formas de mejorar su satisfacción."
                ), SeverityLevel.MODERATE),
                ScoreThreshold(15, 19, mapOf(
                    "en" to "Slightly dissatisfied",
                    "fr" to "Légèrement insatisfait(e)",
                    "es" to "Ligeramente insatisfecho(a)"
                ), mapOf(
                    "en" to "Your score indicates you are slightly dissatisfied with life. Small changes may improve your satisfaction.",
                    "fr" to "Votre score indique un niveau de satisfaction légèrement insuffisant. De petits changements pourraient améliorer votre satisfaction.",
                    "es" to "Su puntuación indica que está ligeramente insatisfecho(a) con la vida. Pequeños cambios pueden mejorar su satisfacción."
                ), SeverityLevel.MILD),
                ScoreThreshold(20, 24, mapOf(
                    "en" to "Neutral",
                    "fr" to "Neutre",
                    "es" to "Neutral"
                ), mapOf(
                    "en" to "Your score indicates a neutral level of satisfaction with life.",
                    "fr" to "Votre score indique un niveau neutre de satisfaction avec la vie.",
                    "es" to "Su puntuación indica un nivel neutral de satisfacción con la vida."
                ), SeverityLevel.NONE),
                ScoreThreshold(25, 29, mapOf(
                    "en" to "Satisfied",
                    "fr" to "Satisfait(e)",
                    "es" to "Satisfecho(a)"
                ), mapOf(
                    "en" to "Your score indicates you are satisfied with your life. Keep up what's working well for you.",
                    "fr" to "Votre score indique un niveau de satisfaction avec la vie. Continuez ce qui fonctionne bien pour vous.",
                    "es" to "Su puntuación indica que está satisfecho(a) con su vida. Continúe con lo que le funciona bien."
                ), SeverityLevel.NONE),
                ScoreThreshold(30, 35, mapOf(
                    "en" to "Extremely satisfied",
                    "fr" to "Extrêmement satisfait(e)",
                    "es" to "Extremadamente satisfecho(a)"
                ), mapOf(
                    "en" to "Your score indicates you are extremely satisfied with life. Your life is going very well.",
                    "fr" to "Votre score indique un niveau de satisfaction extrême avec la vie. Votre vie se passe très bien.",
                    "es" to "Su puntuación indica que está extremadamente satisfecho(a) con la vida. Su vida va muy bien."
                ), SeverityLevel.NONE)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Diener, E., Emmons, R.A., Larsen, R.J., Griffin, S. (1985). The Satisfaction With Life Scale. Journal of Personality Assessment, 49(1), 71-75.",
        estimatedDurationMinutes = 1
    )

    private fun swlsOptions(): List<AnswerOption> = listOf(
        AnswerOption(1, mapOf(
            "en" to "Strongly disagree",
            "fr" to "Fortement en désaccord",
            "es" to "Totalmente en desacuerdo"
        )),
        AnswerOption(2, mapOf(
            "en" to "Disagree",
            "fr" to "En désaccord",
            "es" to "En desacuerdo"
        )),
        AnswerOption(3, mapOf(
            "en" to "Slightly disagree",
            "fr" to "Plutôt en désaccord",
            "es" to "Ligeramente en desacuerdo"
        )),
        AnswerOption(4, mapOf(
            "en" to "Neither agree nor disagree",
            "fr" to "Ni d'accord ni en désaccord",
            "es" to "Ni de acuerdo ni en desacuerdo"
        )),
        AnswerOption(5, mapOf(
            "en" to "Slightly agree",
            "fr" to "Plutôt d'accord",
            "es" to "Ligeramente de acuerdo"
        )),
        AnswerOption(6, mapOf(
            "en" to "Agree",
            "fr" to "D'accord",
            "es" to "De acuerdo"
        )),
        AnswerOption(7, mapOf(
            "en" to "Strongly agree",
            "fr" to "Fortement d'accord",
            "es" to "Totalmente de acuerdo"
        ))
    )
}