package com.psychtests.data.content

import com.psychtests.data.model.*

object AuditTest {

    fun build(): Test = Test(
        id = "audit",
        key = "audit",
        category = TestCategory.SUBSTANCE,
        title = mapOf(
            "en" to "Alcohol Use Disorders Identification Test (AUDIT)",
            "fr" to "Test d'identification des troubles liés à l'alcool (AUDIT)",
            "es" to "Prueba de Identificación de los Trastornos por Consumo de Alcohol (AUDIT)"
        ),
        description = mapOf(
            "en" to "Screening tool developed by the World Health Organization to identify hazardous and harmful drinking patterns.",
            "fr" to "Outil de dépistage développé par l'Organisation mondiale de la santé pour identifier les modes de consommation à risque et nocifs.",
            "es" to "Instrumento de cribado desarrollado por la Organización Mundial de la Salud para identificar patrones de consumo de riesgo y perjudiciales."
        ),
        instructions = mapOf(
            "en" to "Please answer the following questions about your alcohol consumption. Answer as accurately as possible.",
            "fr" to "Veuillez répondre aux questions suivantes concernant votre consommation d'alcool. Répondez aussi précisément que possible.",
            "es" to "Por favor, responda a las siguientes preguntas sobre su consumo de alcohol. Responda con la mayor precisión posible."
        ),
        questions = listOf(
            Question("audit1", mapOf(
                "en" to "How often do you have a drink containing alcohol?",
                "fr" to "À quelle fréquence buvez-vous de l'alcool ?",
                "es" to "¿Con qué frecuencia consume alguna bebida alcohólica?"
            ), audit1Options()),
            Question("audit2", mapOf(
                "en" to "How many drinks containing alcohol do you have on a typical day when you are drinking?",
                "fr" to "Combien de verres d'alcool buvez-vous un jour typique où vous buvez ?",
                "es" to "¿Cuántas consumiciones de alcohol realiza en un día típico en el que bebe?"
            ), audit2Options()),
            Question("audit3", mapOf(
                "en" to "How often do you have six or more drinks on one occasion?",
                "fr" to "À quelle fréquence buvez-vous six verres ou plus en une seule occasion ?",
                "es" to "¿Con qué frecuencia toma seis o más bebidas alcohólicas en un solo día?"
            ), audit3Options()),
            Question("audit4", mapOf(
                "en" to "How often during the last year have you found that you were not able to stop drinking once you had started?",
                "fr" to "Au cours de l'année écoulée, à quelle fréquence avez-vous constaté que vous n'étiez pas capable d'arrêter de boire une fois que vous aviez commencé ?",
                "es" to "¿Con qué frecuencia, durante el último año, ha sido incapaz de dejar de beber una vez había empezado?"
            ), audit3Options()),
            Question("audit5", mapOf(
                "en" to "How often during the last year have you failed to do what was normally expected of you because of drinking?",
                "fr" to "Au cours de l'année écoulée, à quelle fréquence votre consommation d'alcool vous a-t-elle empêché(e) de faire ce qu'on attendait normalement de vous ?",
                "es" to "¿Con qué frecuencia, durante el último año, ha dejado de hacer lo que se esperaba de usted por haber bebido?"
            ), audit3Options()),
            Question("audit6", mapOf(
                "en" to "How often during the last year have you needed a first drink in the morning to get yourself going after a heavy drinking session?",
                "fr" to "Au cours de l'année écoulée, à quelle fréquence avez-vous eu besoin d'un premier verre le matin pour vous remettre en route après une soirée bien arrosée ?",
                "es" to "¿Con qué frecuencia, durante el último año, ha necesitado beber por la mañana para ponerse en marcha después de haber bebido mucho el día anterior?"
            ), audit3Options()),
            Question("audit7", mapOf(
                "en" to "How often during the last year have you had a feeling of guilt or remorse after drinking?",
                "fr" to "Au cours de l'année écoulée, à quelle fréquence avez-vous ressenti de la culpabilité ou des remords après avoir bu ?",
                "es" to "¿Con qué frecuencia, durante el último año, ha tenido sentimientos de culpa o remordimientos después de beber?"
            ), audit3Options()),
            Question("audit8", mapOf(
                "en" to "How often during the last year have you been unable to remember what happened the night before because you had been drinking?",
                "fr" to "Au cours de l'année écoulée, à quelle fréquence avez-vous été incapable de vous souvenir de ce qui s'était passé la veille parce que vous aviez bu ?",
                "es" to "¿Con qué frecuencia, durante el último año, no ha podido recordar lo que sucedió la noche anterior porque había estado bebiendo?"
            ), audit3Options()),
            Question("audit9", mapOf(
                "en" to "Have you or someone else been injured as a result of your drinking?",
                "fr" to "Vous-même ou une autre personne avez-vous été blessé(e) à cause de votre consommation d'alcool ?",
                "es" to "¿Usted u otra persona ha resultado herida como consecuencia de que usted hubiera bebido?"
            ), audit9Options()),
            Question("audit10", mapOf(
                "en" to "Has a relative or friend, or a doctor or other health worker, been concerned about your drinking or suggested you cut down?",
                "fr" to "Un parent, un ami, un médecin ou un autre professionnel de santé s'est-il déjà inquiété de votre consommation d'alcool ou a-t-il suggéré que vous la réduisiez ?",
                "es" to "¿Algún familiar, amigo, médico u otro profesional de la salud se ha preocupado por su consumo de alcohol o le ha sugerido que deje de beber?"
            ), audit9Options())
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 40,
            thresholds = listOf(
                ScoreThreshold(0, 7, mapOf(
                    "en" to "Low-risk drinking",
                    "fr" to "Consommation à faible risque",
                    "es" to "Consumo de bajo riesgo"
                ), mapOf(
                    "en" to "Your alcohol consumption is in the low-risk zone. Continue to drink within recommended limits and monitor your habits.",
                    "fr" to "Votre consommation d'alcool se situe dans la zone à faible risque. Continuez à boire dans les limites recommandées et surveillez vos habitudes.",
                    "es" to "Su consumo de alcohol se encuentra en la zona de bajo riesgo. Continúe bebiendo dentro de los límites recomendados y monitorice sus hábitos."
                ), SeverityLevel.NONE),
                ScoreThreshold(8, 15, mapOf(
                    "en" to "Hazardous drinking",
                    "fr" to "Consommation à risque",
                    "es" to "Consumo de riesgo"
                ), mapOf(
                    "en" to "Your drinking pattern suggests hazardous consumption. Consider reducing your alcohol intake and seeking advice from a healthcare professional.",
                    "fr" to "Votre mode de consommation suggère une consommation à risque. Envisagez de réduire votre consommation d'alcool et de demander conseil à un professionnel de santé.",
                    "es" to "Su patrón de consumo sugiere un consumo de riesgo. Considere reducir su consumo de alcohol y solicitar consejo a un profesional de la salud."
                ), SeverityLevel.MODERATE),
                ScoreThreshold(16, 19, mapOf(
                    "en" to "Harmful drinking",
                    "fr" to "Consommation nocive",
                    "es" to "Consumo perjudicial"
                ), mapOf(
                    "en" to "Your drinking pattern suggests harmful consumption. We strongly recommend consulting a healthcare professional for a comprehensive assessment.",
                    "fr" to "Votre mode de consommation suggère une consommation nocive. Nous vous recommandons fortement de consulter un professionnel de santé pour une évaluation complète.",
                    "es" to "Su patrón de consumo sugiere un consumo perjudicial. Le recomendamos encarecidamente consultar a un profesional de la salud para una evaluación integral."
                ), SeverityLevel.SEVERE),
                ScoreThreshold(20, 40, mapOf(
                    "en" to "Possible alcohol dependence",
                    "fr" to "Dépendance possible à l'alcool",
                    "es" to "Posible dependencia al alcohol"
                ), mapOf(
                    "en" to "Your score suggests possible alcohol dependence. Please seek professional help as soon as possible for assessment and support.",
                    "fr" to "Votre score suggère une dépendance possible à l'alcool. Veuillez demander de l'aide professionnelle dès que possible pour une évaluation et un soutien.",
                    "es" to "Su puntuación sugiere una posible dependencia al alcohol. Por favor, busque ayuda profesional lo antes posible para evaluación y apoyo."
                ), SeverityLevel.EXTREME)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Babor, T.F., Higgins-Biddle, J.C., Saunders, J.B., Monteiro, M.G. (2001). AUDIT: The Alcohol Use Disorders Identification Test: Guidelines for Use in Primary Health Care. World Health Organization, 2nd ed.",
        estimatedDurationMinutes = 3
    )

    private fun audit1Options(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "Never",
            "fr" to "Jamais",
            "es" to "Nunca"
        )),
        AnswerOption(1, mapOf(
            "en" to "Monthly or less",
            "fr" to "Mensuellement ou moins",
            "es" to "Mensualmente o menos"
        )),
        AnswerOption(2, mapOf(
            "en" to "2-4 times a month",
            "fr" to "2 à 4 fois par mois",
            "es" to "De 2 a 4 veces al mes"
        )),
        AnswerOption(3, mapOf(
            "en" to "2-3 times a week",
            "fr" to "2 à 3 fois par semaine",
            "es" to "De 2 a 3 veces por semana"
        )),
        AnswerOption(4, mapOf(
            "en" to "4 or more times a week",
            "fr" to "4 fois ou plus par semaine",
            "es" to "4 o más veces a la semana"
        ))
    )

    private fun audit2Options(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "1 or 2",
            "fr" to "1 ou 2",
            "es" to "1 o 2"
        )),
        AnswerOption(1, mapOf(
            "en" to "3 or 4",
            "fr" to "3 ou 4",
            "es" to "3 o 4"
        )),
        AnswerOption(2, mapOf(
            "en" to "5 or 6",
            "fr" to "5 ou 6",
            "es" to "5 o 6"
        )),
        AnswerOption(3, mapOf(
            "en" to "7, 8, or 9",
            "fr" to "7, 8 ou 9",
            "es" to "7, 8 o 9"
        )),
        AnswerOption(4, mapOf(
            "en" to "10 or more",
            "fr" to "10 ou plus",
            "es" to "10 o más"
        ))
    )

    private fun audit3Options(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "Never",
            "fr" to "Jamais",
            "es" to "Nunca"
        )),
        AnswerOption(1, mapOf(
            "en" to "Less than monthly",
            "fr" to "Moins d'une fois par mois",
            "es" to "Menos de una vez al mes"
        )),
        AnswerOption(2, mapOf(
            "en" to "Monthly",
            "fr" to "Mensuellement",
            "es" to "Mensualmente"
        )),
        AnswerOption(3, mapOf(
            "en" to "Weekly",
            "fr" to "Hebdomadairement",
            "es" to "Semanalmente"
        )),
        AnswerOption(4, mapOf(
            "en" to "Daily or almost daily",
            "fr" to "Tous les jours ou presque",
            "es" to "A diario o casi a diario"
        ))
    )

    private fun audit9Options(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "No",
            "fr" to "Non",
            "es" to "No"
        )),
        AnswerOption(2, mapOf(
            "en" to "Yes, but not in the last year",
            "fr" to "Oui, mais pas au cours de l'année écoulée",
            "es" to "Sí, pero no en el último año"
        )),
        AnswerOption(4, mapOf(
            "en" to "Yes, during the last year",
            "fr" to "Oui, au cours de l'année écoulée",
            "es" to "Sí, durante el último año"
        ))
    )
}