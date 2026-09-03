package com.psychtests.data.content

import com.psychtests.data.model.*

object HadsTest {

    fun build(): Test = Test(
        id = "hads",
        key = "hads",
        category = TestCategory.ANXIETY,
        title = mapOf(
            "en" to "Hospital Anxiety and Depression Scale (HADS)",
            "fr" to "Échelle d'anxiété et de dépression hospitalière (HADS)",
            "es" to "Escala de Ansiedad y Depresión Hospitalaria (HADS)"
        ),
        description = mapOf(
            "en" to "Screening tool for anxiety (HADS-A) and depression (HADS-D) symptoms in the past week.",
            "fr" to "Outil de dépistage des symptômes d'anxiété (HADS-A) et de dépression (HADS-D) au cours de la semaine écoulée.",
            "es" to "Instrumento de cribado de síntomas de ansiedad (HADS-A) y depresión (HADS-D) en la última semana."
        ),
        instructions = mapOf(
            "en" to "Read each item and place a tick in the box opposite the reply which comes closest to how you have been feeling in the past week.",
            "fr" to "Lisez chaque énoncé et cochez la réponse qui se rapproche le plus de ce que vous avez ressenti au cours de la semaine écoulée.",
            "es" to "Lea cada enunciado y marque la respuesta que más se acerque a cómo se ha sentido durante la última semana."
        ),
        questions = listOf(
            Question(
                id = "hads1",
                text = mapOf(
                    "en" to "I feel tense or 'wound up'",
                    "fr" to "Je me sens tendu(e) ou énervé(e)",
                    "es" to "Me siento tenso(a) o nervioso(a)"
                ),
                options = hadsAnxietyOptions(),
                subscale = "anxiety"
            ),
            Question(
                id = "hads2",
                text = mapOf(
                    "en" to "I still enjoy the things I used to enjoy",
                    "fr" to "J'ai encore plaisir aux choses que j'aimais",
                    "es" to "Todavía disfruto de las cosas que solía disfrutar"
                ),
                options = hadsDepressionOptions(),
                subscale = "depression"
            ),
            Question(
                id = "hads3",
                text = mapOf(
                    "en" to "I get a sort of frightened feeling as if something awful is about to happen",
                    "fr" to "J'éprouve des sensations de peur comme si quelque chose de terrible allait se produire",
                    "es" to "Siento una especie de miedo como si algo terrible fuera a suceder"
                ),
                options = hadsAnxietyOptions(),
                subscale = "anxiety"
            ),
            Question(
                id = "hads4",
                text = mapOf(
                    "en" to "I can laugh and see the funny side of things",
                    "fr" to "Je peux rire et voir le côté amusant des choses",
                    "es" to "Puedo reírme y ver el lado divertido de las cosas"
                ),
                options = hadsDepressionOptions(),
                subscale = "depression"
            ),
            Question(
                id = "hads5",
                text = mapOf(
                    "en" to "Worrying thoughts go through my mind",
                    "fr" to "Des pensées inquiétantes me viennent à l'esprit",
                    "es" to "Tengo pensamientos preocupantes en mi mente"
                ),
                options = hadsAnxietyOptions(),
                subscale = "anxiety"
            ),
            Question(
                id = "hads6",
                text = mapOf(
                    "en" to "I feel cheerful",
                    "fr" to "Je me sens de bonne humeur",
                    "es" to "Me siento alegre"
                ),
                options = hadsDepressionOptions(),
                subscale = "depression"
            ),
            Question(
                id = "hads7",
                text = mapOf(
                    "en" to "I can sit at ease and feel relaxed",
                    "fr" to "Je peux m'asseoir tranquillement et me sentir détendu(e)",
                    "es" to "Puedo sentarme tranquilamente y sentirme relajado(a)"
                ),
                options = hadsAnxietyOptions(),
                subscale = "anxiety"
            ),
            Question(
                id = "hads8",
                text = mapOf(
                    "en" to "I feel as if I am slowed down",
                    "fr" to "Je me sens ralenti(e)",
                    "es" to "Me siento como si estuviera más lento(a)"
                ),
                options = hadsDepressionOptions(),
                subscale = "depression"
            ),
            Question(
                id = "hads9",
                text = mapOf(
                    "en" to "I get a sort of frightened feeling like 'butterflies' in the stomach",
                    "fr" to "J'éprouve des sensations de peur, comme des 'papillons' dans le ventre",
                    "es" to "Siento una especie de miedo, como 'mariposas' en el estómago"
                ),
                options = hadsAnxietyOptions(),
                subscale = "anxiety"
            ),
            Question(
                id = "hads10",
                text = mapOf(
                    "en" to "I have lost interest in my appearance",
                    "fr" to "Je ne m'intéresse plus à mon apparence",
                    "es" to "He perdido interés en mi apariencia"
                ),
                options = hadsDepressionOptions(),
                subscale = "depression"
            ),
            Question(
                id = "hads11",
                text = mapOf(
                    "en" to "I feel restless as if I have to be on the move",
                    "fr" to "Je me sens agité(e) comme si je devais continuellement bouger",
                    "es" to "Me siento inquieto(a) como si tuviera que estar en movimiento"
                ),
                options = hadsAnxietyOptions(),
                subscale = "anxiety"
            ),
            Question(
                id = "hads12",
                text = mapOf(
                    "en" to "I look forward with enjoyment to things",
                    "fr" to "Je me réjouis d'avance à l'idée de certaines choses",
                    "es" to "Espero con ilusión las cosas"
                ),
                options = hadsDepressionOptions(),
                subscale = "depression"
            ),
            Question(
                id = "hads13",
                text = mapOf(
                    "en" to "I get sudden feelings of panic",
                    "fr" to "J'éprouve des sensations soudaines de panique",
                    "es" to "Siento ataques repentinos de pánico"
                ),
                options = hadsAnxietyOptions(),
                subscale = "anxiety"
            ),
            Question(
                id = "hads14",
                text = mapOf(
                    "en" to "I can enjoy a good book or radio or TV program",
                    "fr" to "Je peux prendre plaisir à un bon livre, à la radio ou à une émission de télévision",
                    "es" to "Puedo disfrutar de un buen libro, de la radio o de un programa de televisión"
                ),
                options = hadsDepressionOptions(),
                subscale = "depression"
            )
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 42,
            subscales = mapOf(
                "anxiety" to SubscaleConfig(
                    questionIds = listOf("hads1", "hads3", "hads5", "hads7", "hads9", "hads11", "hads13"),
                    minScore = 0,
                    maxScore = 21,
                    thresholds = listOf(
                        ScoreThreshold(0, 7, mapOf(
                            "en" to "Normal",
                            "fr" to "Normal",
                            "es" to "Normal"
                        ), mapOf(
                            "en" to "Your anxiety score is within the normal range.",
                            "fr" to "Votre score d'anxiété se situe dans la plage normale.",
                            "es" to "Su puntuación de ansiedad se encuentra dentro del rango normal."
                        ), SeverityLevel.NONE),
                        ScoreThreshold(8, 10, mapOf(
                            "en" to "Borderline abnormal",
                            "fr" to "Limite anormal",
                            "es" to "Límite anormal"
                        ), mapOf(
                            "en" to "Your anxiety score is borderline abnormal. Consider monitoring your symptoms.",
                            "fr" to "Votre score d'anxiété est à la limite anormale. Envisagez de surveiller vos symptômes.",
                            "es" to "Su puntuación de ansiedad es límite anormal. Considere monitorizar sus síntomas."
                        ), SeverityLevel.MILD),
                        ScoreThreshold(11, 21, mapOf(
                            "en" to "Abnormal",
                            "fr" to "Anormal",
                            "es" to "Anormal"
                        ), mapOf(
                            "en" to "Your anxiety score is in the abnormal range. We recommend consulting a healthcare professional.",
                            "fr" to "Votre score d'anxiété se situe dans la plage anormale. Nous vous recommandons de consulter un professionnel de santé.",
                            "es" to "Su puntuación de ansiedad se encuentra en el rango anormal. Le recomendamos consultar a un profesional de la salud."
                        ), SeverityLevel.MODERATE)
                    )
                ),
                "depression" to SubscaleConfig(
                    questionIds = listOf("hads2", "hads4", "hads6", "hads8", "hads10", "hads12", "hads14"),
                    minScore = 0,
                    maxScore = 21,
                    thresholds = listOf(
                        ScoreThreshold(0, 7, mapOf(
                            "en" to "Normal",
                            "fr" to "Normal",
                            "es" to "Normal"
                        ), mapOf(
                            "en" to "Your depression score is within the normal range.",
                            "fr" to "Votre score de dépression se situe dans la plage normale.",
                            "es" to "Su puntuación de depresión se encuentra dentro del rango normal."
                        ), SeverityLevel.NONE),
                        ScoreThreshold(8, 10, mapOf(
                            "en" to "Borderline abnormal",
                            "fr" to "Limite anormal",
                            "es" to "Límite anormal"
                        ), mapOf(
                            "en" to "Your depression score is borderline abnormal. Consider monitoring your symptoms.",
                            "fr" to "Votre score de dépression est à la limite anormale. Envisagez de surveiller vos symptômes.",
                            "es" to "Su puntuación de depresión es límite anormal. Considere monitorizar sus síntomas."
                        ), SeverityLevel.MILD),
                        ScoreThreshold(11, 21, mapOf(
                            "en" to "Abnormal",
                            "fr" to "Anormal",
                            "es" to "Anormal"
                        ), mapOf(
                            "en" to "Your depression score is in the abnormal range. We recommend consulting a healthcare professional.",
                            "fr" to "Votre score de dépression se situe dans la plage anormale. Nous vous recommandons de consulter un professionnel de santé.",
                            "es" to "Su puntuación de depresión se encuentra en el rango anormal. Le recomendamos consultar a un profesional de la salud."
                        ), SeverityLevel.MODERATE)
                    )
                )
            ),
            thresholds = listOf(
                ScoreThreshold(0, 7, mapOf(
                    "en" to "Normal",
                    "fr" to "Normal",
                    "es" to "Normal"
                ), mapOf(
                    "en" to "Your scores are within the normal range.",
                    "fr" to "Vos scores se situent dans la plage normale.",
                    "es" to "Sus puntuaciones se encuentran dentro del rango normal."
                ), SeverityLevel.NONE),
                ScoreThreshold(8, 10, mapOf(
                    "en" to "Borderline abnormal",
                    "fr" to "Limite anormal",
                    "es" to "Límite anormal"
                ), mapOf(
                    "en" to "Your scores are borderline abnormal. Consider monitoring your symptoms.",
                    "fr" to "Vos scores sont à la limite anormale. Envisagez de surveiller vos symptômes.",
                    "es" to "Sus puntuaciones son límite anormal. Considere monitorizar sus síntomas."
                ), SeverityLevel.MILD),
                ScoreThreshold(11, 42, mapOf(
                    "en" to "Abnormal",
                    "fr" to "Anormal",
                    "es" to "Anormal"
                ), mapOf(
                    "en" to "Your scores are in the abnormal range. We recommend consulting a healthcare professional.",
                    "fr" to "Vos scores se situent dans la plage anormale. Nous vous recommandons de consulter un professionnel de santé.",
                    "es" to "Sus puntuaciones se encuentran en el rango anormal. Le recomendamos consultar a un profesional de la salud."
                ), SeverityLevel.MODERATE)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Zigmond, A.S., Snaith, R.P. (1983). The Hospital Anxiety and Depression Scale. Acta Psychiatrica Scandinavica, 67(6), 361-370.",
        estimatedDurationMinutes = 3
    )

    private fun hadsAnxietyOptions(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "Not at all",
            "fr" to "Jamais",
            "es" to "Nunca"
        )),
        AnswerOption(1, mapOf(
            "en" to "Occasionally",
            "fr" to "Occasionnellement",
            "es" to "Ocasionalmente"
        )),
        AnswerOption(2, mapOf(
            "en" to "Often",
            "fr" to "Souvent",
            "es" to "A menudo"
        )),
        AnswerOption(3, mapOf(
            "en" to "Very often",
            "fr" to "Très souvent",
            "es" to "Muy a menudo"
        ))
    )

    private fun hadsDepressionOptions(): List<AnswerOption> = listOf(
        AnswerOption(3, mapOf(
            "en" to "Not at all",
            "fr" to "Pas du tout",
            "es" to "Nada en absoluto"
        )),
        AnswerOption(2, mapOf(
            "en" to "Not often",
            "fr" to "Pas souvent",
            "es" to "No a menudo"
        )),
        AnswerOption(1, mapOf(
            "en" to "Some of the time",
            "fr" to "Parfois",
            "es" to "Algunas veces"
        )),
        AnswerOption(0, mapOf(
            "en" to "Most of the time",
            "fr" to "La plupart du temps",
            "es" to "La mayor parte del tiempo"
        ))
    )
}