package com.psychtests.data.content

import com.psychtests.data.model.*

object Phq9Test {

    fun build(): Test = Test(
        id = "phq9",
        key = "phq9",
        category = TestCategory.DEPRESSION,
        title = mapOf(
            "en" to "Patient Health Questionnaire (PHQ-9)",
            "fr" to "Questionnaire sur la santé du patient (PHQ-9)",
            "es" to "Cuestionario de Salud del Paciente (PHQ-9)"
        ),
        description = mapOf(
            "en" to "Screening measure for the severity of depressive symptoms over the past two weeks.",
            "fr" to "Outil de dépistage de la sévérité des symptômes dépressifs au cours des deux dernières semaines.",
            "es" to "Instrumento de cribado de la gravedad de los síntomas depresivos durante las últimas dos semanas."
        ),
        instructions = mapOf(
            "en" to "Over the last 2 weeks, how often have you been bothered by any of the following problems?",
            "fr" to "Au cours des 2 dernières semaines, selon quelle fréquence avez-vous été gêné(e) par les problèmes suivants ?",
            "es" to "Durante las últimas 2 semanas, ¿qué tan a menudo le han molestado los siguientes problemas?"
        ),
        questions = listOf(
            Question(
                id = "phq1",
                text = mapOf(
                    "en" to "Little interest or pleasure in doing things",
                    "fr" to "Peu d'intérêt ou de plaisir à faire les choses",
                    "es" to "Poco interés o placer en hacer cosas"
                ),
                options = phqOptions(),
                subscale = "total"
            ),
            Question(
                id = "phq2",
                text = mapOf(
                    "en" to "Feeling down, depressed, or hopeless",
                    "fr" to "Se sentir déprimé(e), cafardeux(se), ou désespéré(e)",
                    "es" to "Se ha sentido decaído(a), deprimido(a) o sin esperanza"
                ),
                options = phqOptions(),
                subscale = "total"
            ),
            Question(
                id = "phq3",
                text = mapOf(
                    "en" to "Trouble falling or staying asleep, or sleeping too much",
                    "fr" to "Difficultés à s'endormir ou à rester endormi(e), ou dormir trop",
                    "es" to "Dificultad para dormir o permanecer dormido(a), o dormir demasiado"
                ),
                options = phqOptions(),
                subscale = "total"
            ),
            Question(
                id = "phq4",
                text = mapOf(
                    "en" to "Feeling tired or having little energy",
                    "fr" to "Se sentir fatigué(e) ou avoir peu d'énergie",
                    "es" to "Se ha sentido cansado(a) o con poca energía"
                ),
                options = phqOptions(),
                subscale = "total"
            ),
            Question(
                id = "phq5",
                text = mapOf(
                    "en" to "Poor appetite or overeating",
                    "fr" to "Manque d'appétit ou manger trop",
                    "es" to "Tener poco apetito o comer en exceso"
                ),
                options = phqOptions(),
                subscale = "total"
            ),
            Question(
                id = "phq6",
                text = mapOf(
                    "en" to "Feeling bad about yourself — or that you are a failure or have let yourself or your family down",
                    "fr" to "Avoir une mauvaise opinion de vous-même — ou penser que vous êtes un(e) raté(e) ou que vous avez déçu votre famille ou vous-même",
                    "es" to "Se ha sentido mal con usted mismo(a), o que es un(a) fracasado(a), o que ha defraudado a su familia o a usted mismo(a)"
                ),
                options = phqOptions(),
                subscale = "total"
            ),
            Question(
                id = "phq7",
                text = mapOf(
                    "en" to "Trouble concentrating on things, such as reading the newspaper or watching television",
                    "fr" to "Difficultés à vous concentrer sur certaines choses, comme lire le journal ou regarder la télévision",
                    "es" to "Dificultad para concentrarse en las cosas, como leer el periódico o ver la televisión"
                ),
                options = phqOptions(),
                subscale = "total"
            ),
            Question(
                id = "phq8",
                text = mapOf(
                    "en" to "Moving or speaking so slowly that other people could have noticed. Or the opposite — being so fidgety or restless that you have been moving around a lot more than usual",
                    "fr" to "Agir ou parler lentement au point que les autres ont pu le remarquer. Ou l'inverse — être si agité(e) que vous avez bougé beaucoup plus que d'habitude",
                    "es" to "Moverse o hablar tan despacio que otra gente se ha podido dar cuenta. O lo contrario — tan inquieto(a) o impaciente que ha estado dando vueltas mucho más de lo normal"
                ),
                options = phqOptions(),
                subscale = "total"
            ),
            Question(
                id = "phq9",
                text = mapOf(
                    "en" to "Thoughts that you would be better off dead, or of hurting yourself",
                    "fr" to "Penser qu'il vaudrait mieux mourir ou penser à vous faire du mal",
                    "es" to "Pensamientos de que estaría mejor muerto(a) o de hacerse daño de alguna manera"
                ),
                options = phqOptions(),
                subscale = "total"
            )
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 27,
            subscales = mapOf(
                "total" to SubscaleConfig(
                    questionIds = (1..9).map { "phq$it" },
                    minScore = 0,
                    maxScore = 27,
                    thresholds = listOf(
                        ScoreThreshold(0, 4, mapOf(
                            "en" to "None / Minimal",
                            "fr" to "Aucune / Minimale",
                            "es" to "Ninguna / Mínima"
                        ), mapOf(
                            "en" to "Your score suggests no or minimal depressive symptoms. Continue to monitor your mental health and reach out to a professional if symptoms worsen.",
                            "fr" to "Votre score suggère une absence ou un minimum de symptômes dépressifs. Continuez à surveiller votre santé mentale et consultez un professionnel si les symptômes s'aggravent.",
                            "es" to "Su puntuación sugiere una ausencia o mínima presencia de síntomas depresivos. Continúe monitorizando su salud mental y consulte a un profesional si los síntomas empeoran."
                        ), SeverityLevel.NONE),
                        ScoreThreshold(5, 9, mapOf(
                            "en" to "Mild",
                            "fr" to "Légère",
                            "es" to "Leve"
                        ), mapOf(
                            "en" to "Your score suggests mild depressive symptoms. Consider speaking with a healthcare professional for guidance and support.",
                            "fr" to "Votre score suggère des symptômes dépressifs légers. Envisagez de parler avec un professionnel de santé pour obtenir des conseils et du soutien.",
                            "es" to "Su puntuación sugiere síntomas depresivos leves. Considere hablar con un profesional de la salud para obtener orientación y apoyo."
                        ), SeverityLevel.MILD),
                        ScoreThreshold(10, 14, mapOf(
                            "en" to "Moderate",
                            "fr" to "Modérée",
                            "es" to "Moderada"
                        ), mapOf(
                            "en" to "Your score suggests moderate depressive symptoms. It is recommended that you seek professional evaluation and support.",
                            "fr" to "Votre score suggère des symptômes dépressifs modérés. Il est recommandé de consulter un professionnel pour une évaluation et un soutien.",
                            "es" to "Su puntuación sugiere síntomas depresivos moderados. Se recomienda buscar evaluación y apoyo profesional."
                        ), SeverityLevel.MODERATE),
                        ScoreThreshold(15, 19, mapOf(
                            "en" to "Moderately Severe",
                            "fr" to "Modérément grave",
                            "es" to "Moderadamente grave"
                        ), mapOf(
                            "en" to "Your score suggests moderately severe depressive symptoms. We strongly recommend consulting a mental health professional as soon as possible.",
                            "fr" to "Votre score suggère des symptômes dépressifs modérément graves. Nous vous recommandons fortement de consulter un professionnel de la santé mentale dès que possible.",
                            "es" to "Su puntuación sugiere síntomas depresivos moderadamente graves. Le recomendamos encarecidamente consultar a un profesional de la salud mental lo antes posible."
                        ), SeverityLevel.MODERATELY_SEVERE),
                        ScoreThreshold(20, 27, mapOf(
                            "en" to "Severe",
                            "fr" to "Grave",
                            "es" to "Grave"
                        ), mapOf(
                            "en" to "Your score suggests severe depressive symptoms. Please seek professional help immediately. If you are having thoughts of harming yourself, contact emergency services right away.",
                            "fr" to "Votre score suggère des symptômes dépressifs graves. Veuillez consulter un professionnel immédiatement. Si vous avez des pensées de vous faire du mal, contactez les services d'urgence sans délai.",
                            "es" to "Su puntuación sugiere síntomas depresivos graves. Busque ayuda profesional de inmediato. Si tiene pensamientos de hacerse daño, contacte a los servicios de emergencia de inmediato."
                        ), SeverityLevel.SEVERE)
                    )
                )
            ),
            thresholds = listOf(
                ScoreThreshold(0, 4, mapOf(
                    "en" to "None / Minimal",
                    "fr" to "Aucune / Minimale",
                    "es" to "Ninguna / Mínima"
                ), mapOf(
                    "en" to "Your score suggests no or minimal depressive symptoms.",
                    "fr" to "Votre score suggère une absence ou un minimum de symptômes dépressifs.",
                    "es" to "Su puntuación sugiere una ausencia o mínima presencia de síntomas depresivos."
                ), SeverityLevel.NONE),
                ScoreThreshold(5, 9, mapOf(
                    "en" to "Mild",
                    "fr" to "Légère",
                    "es" to "Leve"
                ), mapOf(
                    "en" to "Your score suggests mild depressive symptoms.",
                    "fr" to "Votre score suggère des symptômes dépressifs légers.",
                    "es" to "Su puntuación sugiere síntomas depresivos leves."
                ), SeverityLevel.MILD),
                ScoreThreshold(10, 14, mapOf(
                    "en" to "Moderate",
                    "fr" to "Modérée",
                    "es" to "Moderada"
                ), mapOf(
                    "en" to "Your score suggests moderate depressive symptoms.",
                    "fr" to "Votre score suggère des symptômes dépressifs modérés.",
                    "es" to "Su puntuación sugiere síntomas depresivos moderados."
                ), SeverityLevel.MODERATE),
                ScoreThreshold(15, 19, mapOf(
                    "en" to "Moderately Severe",
                    "fr" to "Modérément grave",
                    "es" to "Moderadamente grave"
                ), mapOf(
                    "en" to "Your score suggests moderately severe depressive symptoms.",
                    "fr" to "Votre score suggère des symptômes dépressifs modérément graves.",
                    "es" to "Su puntuación sugiere síntomas depresivos moderadamente graves."
                ), SeverityLevel.MODERATELY_SEVERE),
                ScoreThreshold(20, 27, mapOf(
                    "en" to "Severe",
                    "fr" to "Grave",
                    "es" to "Grave"
                ), mapOf(
                    "en" to "Your score suggests severe depressive symptoms.",
                    "fr" to "Votre score suggère des symptômes dépressifs graves.",
                    "es" to "Su puntuación sugiere síntomas depresivos graves."
                ), SeverityLevel.SEVERE)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Kroenke, K., Spitzer, R.L., Williams, J.B. (2001). The PHQ-9: Validity of a brief depression severity measure. Journal of General Internal Medicine, 16(9), 606-613.",
        estimatedDurationMinutes = 2
    )

    private fun phqOptions(): List<AnswerOption> = listOf(
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