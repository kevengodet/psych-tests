package com.psychtests.data.content

import com.psychtests.data.model.*

object Who5Test {

    fun build(): Test = Test(
        id = "who5",
        key = "who5",
        category = TestCategory.WELLBEING,
        title = mapOf(
            "en" to "WHO-5 Well-Being Index",
            "fr" to "Indice de bien-être de l'OMS (WHO-5)",
            "es" to "Índice de Bienestar de la OMS (WHO-5)"
        ),
        description = mapOf(
            "en" to "Measure of subjective well-being over the past two weeks.",
            "fr" to "Mesure du bien-être subjectif au cours des deux dernières semaines.",
            "es" to "Medida del bienestar subjetivo durante las últimas dos semanas."
        ),
        instructions = mapOf(
            "en" to "Please indicate for each of the five statements which is closest to how you have been feeling over the last two weeks.",
            "fr" to "Veuillez indiquer, pour chacune des cinq affirmations, celle qui se rapproche le plus de ce que vous avez ressenti au cours des deux dernières semaines.",
            "es" to "Por favor, indique para cada una de las cinco afirmaciones cuál se acerca más a cómo se ha sentido durante las últimas dos semanas."
        ),
        questions = listOf(
            Question(
                id = "who5_1",
                text = mapOf(
                    "en" to "I have felt cheerful and in good spirits",
                    "fr" to "Je me suis senti(e) de bonne humeur et bien disposé(e)",
                    "es" to "Me he sentido alegre y de buen ánimo"
                ),
                options = who5Options()
            ),
            Question(
                id = "who5_2",
                text = mapOf(
                    "en" to "I have felt calm and relaxed",
                    "fr" to "Je me suis senti(e) calme et détendu(e)",
                    "es" to "Me he sentido tranquilo(a) y relajado(a)"
                ),
                options = who5Options()
            ),
            Question(
                id = "who5_3",
                text = mapOf(
                    "en" to "I have felt active and vigorous",
                    "fr" to "Je me suis senti(e) plein(e) d'énergie et dynamique",
                    "es" to "Me he sentido activo(a) y con energía"
                ),
                options = who5Options()
            ),
            Question(
                id = "who5_4",
                text = mapOf(
                    "en" to "I woke up feeling fresh and rested",
                    "fr" to "Je me suis réveillé(e) en me sentant reposé(e) et frais(che)",
                    "es" to "Me he despertado sintiéndome despejado(a) y descansado(a)"
                ),
                options = who5Options()
            ),
            Question(
                id = "who5_5",
                text = mapOf(
                    "en" to "My daily life has been filled with things that interest me",
                    "fr" to "Ma vie quotidienne a été remplie de choses qui m'intéressent",
                    "es" to "Mi vida diaria ha estado llena de cosas que me interesan"
                ),
                options = who5Options()
            )
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 25,
            thresholds = listOf(
                ScoreThreshold(0, 12, mapOf(
                    "en" to "Low well-being",
                    "fr" to "Bien-être faible",
                    "es" to "Bienestar bajo"
                ), mapOf(
                    "en" to "Your score suggests a low level of well-being. It may be useful to consult a healthcare professional for further evaluation.",
                    "fr" to "Votre score suggère un faible niveau de bien-être. Il peut être utile de consulter un professionnel de santé pour une évaluation plus approfondie.",
                    "es" to "Su puntuación sugiere un bajo nivel de bienestar. Puede ser útil consultar a un profesional de la salud para una evaluación más detallada."
                ), SeverityLevel.MODERATE),
                ScoreThreshold(13, 25, mapOf(
                    "en" to "Average or high well-being",
                    "fr" to "Bien-être moyen ou élevé",
                    "es" to "Bienestar medio o alto"
                ), mapOf(
                    "en" to "Your score suggests an average or high level of well-being. Keep up good self-care habits and monitor your mental health regularly.",
                    "fr" to "Votre score suggère un niveau de bien-être moyen ou élevé. Maintenez de bonnes habitudes d'auto-soin et surveillez régulièrement votre santé mentale.",
                    "es" to "Su puntuación sugiere un nivel de bienestar medio o alto. Mantenga buenos hábitos de autocuidado y monitorice su salud mental regularmente."
                ), SeverityLevel.NONE)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Topp, C.W., Østergaard, S.D., Søndergaard, S., Bech, P. (2015). The WHO-5 Well-Being Index: A systematic review of the literature. Psychotherapy and Psychosomatics, 84(3), 167-176.",
        estimatedDurationMinutes = 1
    )

    private fun who5Options(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "At no time",
            "fr" to "Jamais",
            "es" to "En ningún momento"
        )),
        AnswerOption(1, mapOf(
            "en" to "Some of the time",
            "fr" to "Parfois",
            "es" to "Algunas veces"
        )),
        AnswerOption(2, mapOf(
            "en" to "Less than half of the time",
            "fr" to "Moins de la moitié du temps",
            "es" to "Menos de la mitad del tiempo"
        )),
        AnswerOption(3, mapOf(
            "en" to "More than half of the time",
            "fr" to "Plus de la moitié du temps",
            "es" to "Más de la mitad del tiempo"
        )),
        AnswerOption(4, mapOf(
            "en" to "Most of the time",
            "fr" to "La plupart du temps",
            "es" to "La mayor parte del tiempo"
        )),
        AnswerOption(5, mapOf(
            "en" to "All of the time",
            "fr" to "Tout le temps",
            "es" to "Todo el tiempo"
        ))
    )
}