package com.psychtests.data.content

import com.psychtests.data.model.*

object Dass21Test {

    fun build(): Test = Test(
        id = "dass21",
        key = "dass21",
        category = TestCategory.STRESS,
        title = mapOf(
            "en" to "Depression Anxiety Stress Scales - 21 (DASS-21)",
            "fr" to "Échelles de dépression, anxiété et stress - 21 (DASS-21)",
            "es" to "Escalas de Depresión, Ansiedad y Estrés - 21 (DASS-21)"
        ),
        description = mapOf(
            "en" to "Simultaneous assessment of depression, anxiety, and stress symptoms.",
            "fr" to "Évaluation simultanée des symptômes de dépression, d'anxiété et de stress.",
            "es" to "Evaluación simultánea de síntomas de depresión, ansiedad y estrés."
        ),
        instructions = mapOf(
            "en" to "Please read each statement and indicate how much the statement applied to you over the past week. There are no right or wrong answers.",
            "fr" to "Veuillez lire chaque affirmation et indiquez à quel point elle s'applique à vous au cours de la semaine écoulée. Il n'y a ni bonnes ni mauvaises réponses.",
            "es" to "Por favor, lea cada afirmación e indique cuánto se aplicó a usted durante la semana pasada. No hay respuestas correctas o incorrectas."
        ),
        questions = listOf(
            Question("dass1", mapOf(
                "en" to "I found it hard to wind down",
                "fr" to "J'ai eu du mal à me détendre",
                "es" to "Me costó mucho relajarme"
            ), dassOptions(), subscale = "stress"),
            Question("dass2", mapOf(
                "en" to "I was aware of dryness of my mouth",
                "fr" to "J'étais conscient(e) d'avoir la bouche sèche",
                "es" to "Me di cuenta de que tenía la boca seca"
            ), dassOptions(), subscale = "anxiety"),
            Question("dass3", mapOf(
                "en" to "I couldn't seem to experience any positive feeling at all",
                "fr" to "Je n'arrivais pas à ressentir d'émotion positive",
                "es" to "No podía experimentar ningún sentimiento positivo"
            ), dassOptions(), subscale = "depression"),
            Question("dass4", mapOf(
                "en" to "I experienced breathing difficulty (e.g., excessively rapid breathing, breathlessness in the absence of physical exertion)",
                "fr" to "J'ai eu des difficultés à respirer (par exemple, respiration trop rapide, essoufflement en l'absence d'effort physique)",
                "es" to "Tuve dificultades para respirar (por ejemplo, respiración excesivamente rápida, falta de aliento sin esfuerzo físico)"
            ), dassOptions(), subscale = "anxiety"),
            Question("dass5", mapOf(
                "en" to "I found it difficult to work up the initiative to do things",
                "fr" to "J'ai eu du mal à prendre l'initiative de faire des choses",
                "es" to "Me resultó difícil tomar la iniciativa para hacer cosas"
            ), dassOptions(), subscale = "depression"),
            Question("dass6", mapOf(
                "en" to "I tended to over-react to situations",
                "fr" to "J'ai eu tendance à réagir de façon excessive aux situations",
                "es" to "Tendí a reaccionar exageradamente ante las situaciones"
            ), dassOptions(), subscale = "stress"),
            Question("dass7", mapOf(
                "en" to "I experienced trembling (e.g., in the hands)",
                "fr" to "J'ai eu des tremblements (par exemple, dans les mains)",
                "es" to "Tuve temblores (por ejemplo, en las manos)"
            ), dassOptions(), subscale = "anxiety"),
            Question("dass8", mapOf(
                "en" to "I felt that I was using a lot of nervous energy",
                "fr" to "J'ai senti que je dépensais beaucoup d'énergie nerveuse",
                "es" to "Sentí que estaba gastando mucha energía nerviosa"
            ), dassOptions(), subscale = "stress"),
            Question("dass9", mapOf(
                "en" to "I was worried about situations in which I might panic and make a fool of myself",
                "fr" to "J'étais inquiet(e) à l'idée de paniquer et de me ridiculiser dans certaines situations",
                "es" to "Me preocupaba las situaciones en las que podría entrar en pánico y hacer el ridículo"
            ), dassOptions(), subscale = "anxiety"),
            Question("dass10", mapOf(
                "en" to "I felt that I had nothing to look forward to",
                "fr" to "J'ai eu le sentiment qu'il n'y avait plus rien qui pourrait me faire plaisir",
                "es" to "Sentí que ya no tenía nada que esperar con ilusión"
            ), dassOptions(), subscale = "depression"),
            Question("dass11", mapOf(
                "en" to "I found myself getting agitated",
                "fr" to "Je me suis surpris(e) à m'agiter",
                "es" to "Me encontré agitándome"
            ), dassOptions(), subscale = "stress"),
            Question("dass12", mapOf(
                "en" to "I found it difficult to relax",
                "fr" to "J'ai eu du mal à me détendre",
                "es" to "Me resultó difícil relajarme"
            ), dassOptions(), subscale = "stress"),
            Question("dass13", mapOf(
                "en" to "I felt down-hearted and blue",
                "fr" to "Je me suis senti(e) cafardeux(se) et triste",
                "es" to "Me sentí desanimado(a) y triste"
            ), dassOptions(), subscale = "depression"),
            Question("dass14", mapOf(
                "en" to "I was intolerant of anything that kept me from getting on with what I was doing",
                "fr" to "Je n'étais pas tolérant(e) à tout ce qui m'empêchait de poursuivre ce que je faisais",
                "es" to "Fui intolerante ante cualquier cosa que me impedía continuar con lo que estaba haciendo"
            ), dassOptions(), subscale = "stress"),
            Question("dass15", mapOf(
                "en" to "I felt I was close to panic",
                "fr" to "J'ai eu l'impression d'être proche de la panique",
                "es" to "Sentí que estaba a punto de entrar en pánico"
            ), dassOptions(), subscale = "anxiety"),
            Question("dass16", mapOf(
                "en" to "I was unable to become enthusiastic about anything",
                "fr" to "Je n'étais capable d'enthousiasme pour rien",
                "es" to "No podía entusiasmarme con nada"
            ), dassOptions(), subscale = "depression"),
            Question("dass17", mapOf(
                "en" to "I felt I wasn't worth much as a person",
                "fr" to "Je n'ai pas eu une grande estime de moi-même",
                "es" to "Sentí que valía muy poco como persona"
            ), dassOptions(), subscale = "depression"),
            Question("dass18", mapOf(
                "en" to "I felt that I was rather touchy",
                "fr" to "J'ai eu tendance à être susceptible",
                "es" to "Sentí que era bastante susceptible"
            ), dassOptions(), subscale = "stress"),
            Question("dass19", mapOf(
                "en" to "I was aware of the action of my heart in the absence of physical exertion (e.g., sense of heart rate increase, heart missing a beat)",
                "fr" to "J'ai été conscient(e) des battements de mon cœur en l'absence d'effort physique (par exemple, sensation d'accélération du rythme cardiaque, palpitations)",
                "es" to "Fui consciente de la actuación de mi corazón en ausencia de esfuerzo físico (por ejemplo, sensación de aumento de la frecuencia cardíaca, que se pierde un latido)"
            ), dassOptions(), subscale = "anxiety"),
            Question("dass20", mapOf(
                "en" to "I felt scared without any good reason",
                "fr" to "J'ai ressenti de la peur sans raison valable",
                "es" to "Me asusté sin ninguna buena razón"
            ), dassOptions(), subscale = "anxiety"),
            Question("dass21", mapOf(
                "en" to "I felt that life was meaningless",
                "fr" to "J'ai eu le sentiment que la vie ne valait plus la peine",
                "es" to "Sentí que la vida no tenía sentido"
            ), dassOptions(), subscale = "depression")
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 63,
            subscales = mapOf(
                "depression" to SubscaleConfig(
                    questionIds = listOf("dass3", "dass5", "dass10", "dass13", "dass16", "dass17", "dass21"),
                    minScore = 0,
                    maxScore = 21,
                    thresholds = listOf(
                        ScoreThreshold(0, 4, mapOf(
                            "en" to "Normal depression",
                            "fr" to "Dépression normale",
                            "es" to "Depresión normal"
                        ), mapOf(
                            "en" to "Your depression score is within the normal range.",
                            "fr" to "Votre score de dépression se situe dans la plage normale.",
                            "es" to "Su puntuación de depresión se encuentra dentro del rango normal."
                        ), SeverityLevel.NONE),
                        ScoreThreshold(5, 6, mapOf(
                            "en" to "Mild depression",
                            "fr" to "Dépression légère",
                            "es" to "Depresión leve"
                        ), mapOf(
                            "en" to "Your depression score suggests mild symptoms.",
                            "fr" to "Votre score de dépression suggère des symptômes légers.",
                            "es" to "Su puntuación de depresión sugiere síntomas leves."
                        ), SeverityLevel.MILD),
                        ScoreThreshold(7, 10, mapOf(
                            "en" to "Moderate depression",
                            "fr" to "Dépression modérée",
                            "es" to "Depresión moderada"
                        ), mapOf(
                            "en" to "Your depression score suggests moderate symptoms.",
                            "fr" to "Votre score de dépression suggère des symptômes modérés.",
                            "es" to "Su puntuación de depresión sugiere síntomas moderados."
                        ), SeverityLevel.MODERATE),
                        ScoreThreshold(11, 13, mapOf(
                            "en" to "Severe depression",
                            "fr" to "Dépression sévère",
                            "es" to "Depresión severa"
                        ), mapOf(
                            "en" to "Your depression score suggests severe symptoms.",
                            "fr" to "Votre score de dépression suggère des symptômes sévères.",
                            "es" to "Su puntuación de depresión sugiere síntomas severos."
                        ), SeverityLevel.SEVERE),
                        ScoreThreshold(14, 21, mapOf(
                            "en" to "Extremely severe depression",
                            "fr" to "Dépression extrêmement sévère",
                            "es" to "Depresión extremadamente severa"
                        ), mapOf(
                            "en" to "Your depression score suggests extremely severe symptoms. Please seek professional help.",
                            "fr" to "Votre score de dépression suggère des symptômes extrêmement sévères. Veuillez consulter un professionnel.",
                            "es" to "Su puntuación de depresión sugiere síntomas extremadamente severos. Busque ayuda profesional."
                        ), SeverityLevel.EXTREME)
                    )
                ),
                "anxiety" to SubscaleConfig(
                    questionIds = listOf("dass2", "dass4", "dass7", "dass9", "dass15", "dass19", "dass20"),
                    minScore = 0,
                    maxScore = 21,
                    thresholds = listOf(
                        ScoreThreshold(0, 3, mapOf(
                            "en" to "Normal anxiety",
                            "fr" to "Anxiété normale",
                            "es" to "Ansiedad normal"
                        ), mapOf(
                            "en" to "Your anxiety score is within the normal range.",
                            "fr" to "Votre score d'anxiété se situe dans la plage normale.",
                            "es" to "Su puntuación de ansiedad se encuentra dentro del rango normal."
                        ), SeverityLevel.NONE),
                        ScoreThreshold(4, 5, mapOf(
                            "en" to "Mild anxiety",
                            "fr" to "Anxiété légère",
                            "es" to "Ansiedad leve"
                        ), mapOf(
                            "en" to "Your anxiety score suggests mild symptoms.",
                            "fr" to "Votre score d'anxiété suggère des symptômes légers.",
                            "es" to "Su puntuación de ansiedad sugiere síntomas leves."
                        ), SeverityLevel.MILD),
                        ScoreThreshold(6, 7, mapOf(
                            "en" to "Moderate anxiety",
                            "fr" to "Anxiété modérée",
                            "es" to "Ansiedad moderada"
                        ), mapOf(
                            "en" to "Your anxiety score suggests moderate symptoms.",
                            "fr" to "Votre score d'anxiété suggère des symptômes modérés.",
                            "es" to "Su puntuación de ansiedad sugiere síntomas moderados."
                        ), SeverityLevel.MODERATE),
                        ScoreThreshold(8, 9, mapOf(
                            "en" to "Severe anxiety",
                            "fr" to "Anxiété sévère",
                            "es" to "Ansiedad severa"
                        ), mapOf(
                            "en" to "Your anxiety score suggests severe symptoms.",
                            "fr" to "Votre score d'anxiété suggère des symptômes sévères.",
                            "es" to "Su puntuación de ansiedad sugiere síntomas severos."
                        ), SeverityLevel.SEVERE),
                        ScoreThreshold(10, 21, mapOf(
                            "en" to "Extremely severe anxiety",
                            "fr" to "Anxiété extrêmement sévère",
                            "es" to "Ansiedad extremadamente severa"
                        ), mapOf(
                            "en" to "Your anxiety score suggests extremely severe symptoms. Please seek professional help.",
                            "fr" to "Votre score d'anxiété suggère des symptômes extrêmement sévères. Veuillez consulter un professionnel.",
                            "es" to "Su puntuación de ansiedad sugiere síntomas extremadamente severos. Busque ayuda profesional."
                        ), SeverityLevel.EXTREME)
                    )
                ),
                "stress" to SubscaleConfig(
                    questionIds = listOf("dass1", "dass6", "dass8", "dass11", "dass12", "dass14", "dass18"),
                    minScore = 0,
                    maxScore = 21,
                    thresholds = listOf(
                        ScoreThreshold(0, 7, mapOf(
                            "en" to "Normal stress",
                            "fr" to "Stress normal",
                            "es" to "Estrés normal"
                        ), mapOf(
                            "en" to "Your stress score is within the normal range.",
                            "fr" to "Votre score de stress se situe dans la plage normale.",
                            "es" to "Su puntuación de estrés se encuentra dentro del rango normal."
                        ), SeverityLevel.NONE),
                        ScoreThreshold(8, 9, mapOf(
                            "en" to "Mild stress",
                            "fr" to "Stress léger",
                            "es" to "Estrés leve"
                        ), mapOf(
                            "en" to "Your stress score suggests mild symptoms.",
                            "fr" to "Votre score de stress suggère des symptômes légers.",
                            "es" to "Su puntuación de estrés sugiere síntomas leves."
                        ), SeverityLevel.MILD),
                        ScoreThreshold(10, 12, mapOf(
                            "en" to "Moderate stress",
                            "fr" to "Stress modéré",
                            "es" to "Estrés moderado"
                        ), mapOf(
                            "en" to "Your stress score suggests moderate symptoms.",
                            "fr" to "Votre score de stress suggère des symptômes modérés.",
                            "es" to "Su puntuación de estrés sugiere síntomas moderados."
                        ), SeverityLevel.MODERATE),
                        ScoreThreshold(13, 16, mapOf(
                            "en" to "Severe stress",
                            "fr" to "Stress sévère",
                            "es" to "Estrés severo"
                        ), mapOf(
                            "en" to "Your stress score suggests severe symptoms.",
                            "fr" to "Votre score de stress suggère des symptômes sévères.",
                            "es" to "Su puntuación de estrés sugiere síntomas severos."
                        ), SeverityLevel.SEVERE),
                        ScoreThreshold(17, 21, mapOf(
                            "en" to "Extremely severe stress",
                            "fr" to "Stress extrêmement sévère",
                            "es" to "Estrés extremadamente severo"
                        ), mapOf(
                            "en" to "Your stress score suggests extremely severe symptoms. Please seek professional help.",
                            "fr" to "Votre score de stress suggère des symptômes extrêmement sévères. Veuillez consulter un professionnel.",
                            "es" to "Su puntuación de estrés sugiere síntomas extremadamente severos. Busque ayuda profesional."
                        ), SeverityLevel.EXTREME)
                    )
                )
            ),
            thresholds = listOf()
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Lovibond, S.H., Lovibond, P.F. (1995). Manual for the Depression Anxiety Stress Scales (2nd ed.). Sydney: Psychology Foundation.",
        estimatedDurationMinutes = 4
    )

    private fun dassOptions(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "Did not apply to me at all",
            "fr" to "Ne s'est pas appliqué à moi du tout",
            "es" to "No se aplicó a mí en absoluto"
        )),
        AnswerOption(1, mapOf(
            "en" to "Applied to me to some degree, or some of the time",
            "fr" to "S'est appliqué à moi dans une certaine mesure, ou de temps en temps",
            "es" to "Se aplicó a mí en cierta medida, o algunas veces"
        )),
        AnswerOption(2, mapOf(
            "en" to "Applied to me to a considerable degree, or a good part of the time",
            "fr" to "S'est appliqué à moi dans une large mesure, ou une bonne partie du temps",
            "es" to "Se aplicó a mí en un grado considerable, o durante buena parte del tiempo"
        )),
        AnswerOption(3, mapOf(
            "en" to "Applied to me very much, or most of the time",
            "fr" to "S'est appliqué à moi beaucoup, ou la plupart du temps",
            "es" to "Se aplicó a mí mucho, o la mayor parte del tiempo"
        ))
    )
}