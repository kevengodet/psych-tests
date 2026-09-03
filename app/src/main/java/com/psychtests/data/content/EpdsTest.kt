package com.psychtests.data.content

import com.psychtests.data.model.*

object EpdsTest {

    fun build(): Test = Test(
        id = "epds",
        key = "epds",
        category = TestCategory.DEPRESSION,
        title = mapOf(
            "en" to "Edinburgh Postnatal Depression Scale (EPDS)",
            "fr" to "Échelle de dépression postnatale d'Édimbourg (EPDS)",
            "es" to "Escala de Depresión Postnatal de Edimburgo (EPDS)"
        ),
        description = mapOf(
            "en" to "Screening tool for postpartum and perinatal depression symptoms.",
            "fr" to "Outil de dépistage des symptômes de dépression post-partum et périnatale.",
            "es" to "Instrumento de cribado de síntomas de depresión posparto y perinatal."
        ),
        instructions = mapOf(
            "en" to "As you have recently had a baby, we would like to know how you are feeling. Please check the answer that comes closest to how you have felt IN THE PAST 7 DAYS.",
            "fr" to "Comme vous avez récemment eu un bébé, nous aimerions savoir comment vous vous sentez. Veuillez cocher la réponse qui se rapproche le plus de ce que vous avez ressenti AU COURS DES 7 DERNIERS JOURS.",
            "es" to "Como ha tenido recientemente un bebé, nos gustaría saber cómo se siente. Por favor, marque la respuesta que mejor se acerca a cómo se ha sentido EN LOS ÚLTIMOS 7 DÍAS."
        ),
        questions = listOf(
            Question("epds1", mapOf(
                "en" to "I have been able to laugh and see the funny side of things",
                "fr" to "J'ai pu rire et prendre les choses du bon côté",
                "es" to "He podido reírme y ver el lado divertido de las cosas"
            ), epds1Options()),
            Question("epds2", mapOf(
                "en" to "I have looked forward with enjoyment to things",
                "fr" to "Je me suis réjoui(e) à l'avance de certaines choses",
                "es" to "He esperado con ilusión las cosas"
            ), epds2Options()),
            Question("epds3", mapOf(
                "en" to "I have blamed myself unnecessarily when things went wrong",
                "fr" to "Je me suis injustement blâmée quand les choses n'allaient pas",
                "es" to "Me he culpado innecesariamente cuando las cosas salían mal"
            ), epds3Options()),
            Question("epds4", mapOf(
                "en" to "I have been anxious or worried for no good reason",
                "fr" to "Je me suis sentie anxieuse ou inquiète sans raison valable",
                "es" to "He estado ansiosa o preocupada sin una buena razón"
            ), epds3Options()),
            Question("epds5", mapOf(
                "en" to "I have felt scared or panicky for no very good reason",
                "fr" to "J'ai ressenti de la peur ou de la panique sans raison valable",
                "es" to "He sentido miedo o pánico sin una buena razón"
            ), epds3Options()),
            Question("epds6", mapOf(
                "en" to "Things have been getting on top of me",
                "fr" to "Les choses s'accumulaient sur moi",
                "es" to "Las cosas me han venido encima"
            ), epds3Options()),
            Question("epds7", mapOf(
                "en" to "I have been so unhappy that I have had difficulty sleeping",
                "fr" to "J'ai été si malheureuse que j'ai eu des difficultés à dormir",
                "es" to "He estado tan infeliz que he tenido dificultad para dormir"
            ), epds3Options()),
            Question("epds8", mapOf(
                "en" to "I have felt sad or miserable",
                "fr" to "Je me suis sentie triste ou malheureuse",
                "es" to "Me he sentido triste o desgraciada"
            ), epds3Options()),
            Question("epds9", mapOf(
                "en" to "I have been so unhappy that I have been crying",
                "fr" to "J'ai été si malheureuse que j'ai pleuré",
                "es" to "He estado tan infeliz que he estado llorando"
            ), epds3Options()),
            Question("epds10", mapOf(
                "en" to "The thought of harming myself has occurred to me",
                "fr" to "L'idée de me faire du mal m'a traversé l'esprit",
                "es" to "Se me ha ocurrido la idea de hacerme daño"
            ), epds4Options())
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 30,
            thresholds = listOf(
                ScoreThreshold(0, 9, mapOf(
                    "en" to "Low likelihood of depression",
                    "fr" to "Faible probabilité de dépression",
                    "es" to "Baja probabilidad de depresión"
                ), mapOf(
                    "en" to "Your score suggests a low likelihood of depression. Continue to monitor your mood and seek support if you have concerns.",
                    "fr" to "Votre score suggère une faible probabilité de dépression. Continuez à surveiller votre humeur et cherchez du soutien si vous avez des préoccupations.",
                    "es" to "Su puntuación sugiere una baja probabilidad de depresión. Continúe monitorizando su estado de ánimo y busque apoyo si tiene preocupaciones."
                ), SeverityLevel.NONE),
                ScoreThreshold(10, 12, mapOf(
                    "en" to "Elevated symptoms",
                    "fr" to "Symptômes élevés",
                    "es" to "Síntomas elevados"
                ), mapOf(
                    "en" to "Your score suggests elevated depressive symptoms. It is recommended to speak with a healthcare professional for further evaluation.",
                    "fr" to "Votre score suggère des symptômes dépressifs élevés. Il est recommandé de parler avec un professionnel de santé pour une évaluation plus approfondie.",
                    "es" to "Su puntuación sugiere síntomas depresivos elevados. Se recomienda hablar con un profesional de la salud para una evaluación adicional."
                ), SeverityLevel.MILD),
                ScoreThreshold(13, 30, mapOf(
                    "en" to "Likely depression",
                    "fr" to "Dépression probable",
                    "es" to "Depresión probable"
                ), mapOf(
                    "en" to "Your score suggests likely depression. Please consult a healthcare professional as soon as possible. If you have thoughts of harming yourself, contact emergency services immediately.",
                    "fr" to "Votre score suggère une dépression probable. Veuillez consulter un professionnel de santé dès que possible. Si vous avez des pensées de vous faire du mal, contactez les services d'urgence immédiatement.",
                    "es" to "Su puntuación sugiere una depresión probable. Por favor, consulte a un profesional de la salud lo antes posible. Si tiene pensamientos de hacerse daño, contacte a los servicios de emergencia de inmediato."
                ), SeverityLevel.SEVERE)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Cox, J.L., Holden, J.M., Sagovsky, R. (1987). Detection of postnatal depression: Development of the 10-item Edinburgh Postnatal Depression Scale. British Journal of Psychiatry, 150, 782-786.",
        estimatedDurationMinutes = 3
    )

    private fun epds1Options(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "As much as I always could",
            "fr" to "Autant que toujours",
            "es" to "Tanto como siempre"
        )),
        AnswerOption(1, mapOf(
            "en" to "Not quite so much now",
            "fr" to "Plutôt moins qu'avant",
            "es" to "No tanto como antes"
        )),
        AnswerOption(2, mapOf(
            "en" to "Definitely not so much now",
            "fr" to "Beaucoup moins qu'avant",
            "es" to "Definitivamente no tanto como antes"
        )),
        AnswerOption(3, mapOf(
            "en" to "Not at all",
            "fr" to "Pas du tout",
            "es" to "En absoluto"
        ))
    )

    private fun epds2Options(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "As much as I ever did",
            "fr" to "Autant que d'habitude",
            "es" to "Tanto como siempre"
        )),
        AnswerOption(1, mapOf(
            "en" to "Rather less than I used to",
            "fr" to "Un peu moins que d'habitude",
            "es" to "Algo menos de lo habitual"
        )),
        AnswerOption(2, mapOf(
            "en" to "Definitely less than I used to",
            "fr" to "Beaucoup moins que d'habitude",
            "es" to "Definitivamente menos de lo habitual"
        )),
        AnswerOption(3, mapOf(
            "en" to "Hardly at all",
            "fr" to "Presque pas du tout",
            "es" to "Casi nunca"
        ))
    )

    private fun epds3Options(): List<AnswerOption> = listOf(
        AnswerOption(3, mapOf(
            "en" to "Yes, most of the time",
            "fr" to "Oui, la plupart du temps",
            "es" to "Sí, la mayor parte del tiempo"
        )),
        AnswerOption(2, mapOf(
            "en" to "Yes, some of the time",
            "fr" to "Oui, parfois",
            "es" to "Sí, algunas veces"
        )),
        AnswerOption(1, mapOf(
            "en" to "Not very often",
            "fr" to "Pas très souvent",
            "es" to "No muy a menudo"
        )),
        AnswerOption(0, mapOf(
            "en" to "No, never",
            "fr" to "Non, jamais",
            "es" to "No, nunca"
        ))
    )

    private fun epds4Options(): List<AnswerOption> = listOf(
        AnswerOption(3, mapOf(
            "en" to "Yes, quite often",
            "fr" to "Oui, assez souvent",
            "es" to "Sí, bastante a menudo"
        )),
        AnswerOption(2, mapOf(
            "en" to "Sometimes",
            "fr" to "Parfois",
            "es" to "A veces"
        )),
        AnswerOption(1, mapOf(
            "en" to "Hardly ever",
            "fr" to "Presque jamais",
            "es" to "Casi nunca"
        )),
        AnswerOption(0, mapOf(
            "en" to "Never",
            "fr" to "Jamais",
            "es" to "Nunca"
        ))
    )
}