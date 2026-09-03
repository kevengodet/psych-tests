package com.psychtests.data.content

import com.psychtests.data.model.*

object Pss10Test {

    fun build(): Test = Test(
        id = "pss10",
        key = "pss10",
        category = TestCategory.STRESS,
        title = mapOf(
            "en" to "Perceived Stress Scale (PSS-10)",
            "fr" to "Échelle de stress perçu (PSS-10)",
            "es" to "Escala de Estrés Percibido (PSS-10)"
        ),
        description = mapOf(
            "en" to "Measures the degree to which situations in one's life are appraised as stressful.",
            "fr" to "Mesure le degré auquel les situations de la vie sont perçues comme stressantes.",
            "es" to "Mide el grado en que las situaciones de la vida se perciben como estresantes."
        ),
        instructions = mapOf(
            "en" to "The questions in this scale ask you about your feelings and thoughts during the last month. In each case, you will be asked to indicate how often you felt or thought a certain way.",
            "fr" to "Les questions de cette échelle portent sur vos sentiments et pensées au cours du dernier mois. Pour chaque question, indiquez à quelle fréquence vous vous êtes senti(e) ou avez pensé d'une certaine manière.",
            "es" to "Las preguntas de esta escala le preguntan sobre sus sentimientos y pensamientos durante el último mes. En cada caso, se le pedirá indicar con qué frecuencia se sintió o pensó de cierta manera."
        ),
        questions = listOf(
            Question("pss1", mapOf(
                "en" to "In the last month, how often have you been upset because of something that happened unexpectedly?",
                "fr" to "Au cours du dernier mois, à quelle fréquence avez-vous été contrarié(e) par un événement inattendu ?",
                "es" to "En el último mes, ¿con qué frecuencia se ha sentido afectado(a) por algo que ocurrió de forma inesperada?"
            ), pssOptions()),
            Question("pss2", mapOf(
                "en" to "In the last month, how often have you felt that you were unable to control the important things in your life?",
                "fr" to "Au cours du dernier mois, à quelle fréquence avez-vous eu le sentiment de ne pas pouvoir contrôler les choses importantes de votre vie ?",
                "es" to "En el último mes, ¿con qué frecuencia ha sentido que no podía controlar las cosas importantes de su vida?"
            ), pssOptions()),
            Question("pss3", mapOf(
                "en" to "In the last month, how often have you felt nervous and 'stressed'?",
                "fr" to "Au cours du dernier mois, à quelle fréquence vous êtes-vous senti(e) nerveux(se) et 'stressé(e)' ?",
                "es" to "En el último mes, ¿con qué frecuencia se ha sentido nervioso(a) y 'estresado(a)'?"
            ), pssOptions()),
            Question("pss4", mapOf(
                "en" to "In the last month, how often have you felt confident about your ability to handle your personal problems?",
                "fr" to "Au cours du dernier mois, à quelle fréquence avez-vous eu confiance en votre capacité à gérer vos problèmes personnels ?",
                "es" to "En el último mes, ¿con qué frecuencia se ha sentido confiado(a) en su capacidad para manejar sus problemas personales?"
            ), pssOptions(), reverseScored = true),
            Question("pss5", mapOf(
                "en" to "In the last month, how often have you felt that things were going your way?",
                "fr" to "Au cours du dernier mois, à quelle fréquence avez-vous eu le sentiment que les choses allaient comme vous le souhaitiez ?",
                "es" to "En el último mes, ¿con qué frecuencia ha sentido que las cosas le salían bien?"
            ), pssOptions(), reverseScored = true),
            Question("pss6", mapOf(
                "en" to "In the last month, how often have you found that you could not cope with all the things that you had to do?",
                "fr" to "Au cours du dernier mois, à quelle fréquence avez-vous constaté que vous ne pouviez pas faire face à toutes les choses que vous aviez à faire ?",
                "es" to "En el último mes, ¿con qué frecuencia ha encontrado que no podía lidiar con todas las cosas que tenía que hacer?"
            ), pssOptions()),
            Question("pss7", mapOf(
                "en" to "In the last month, how often have you been able to control irritations in your life?",
                "fr" to "Au cours du dernier mois, à quelle fréquence avez-vous été capable de contrôler les irritations dans votre vie ?",
                "es" to "En el último mes, ¿con qué frecuencia ha podido controlar las irritaciones en su vida?"
            ), pssOptions(), reverseScored = true),
            Question("pss8", mapOf(
                "en" to "In the last month, how often have you felt that you were on top of things?",
                "fr" to "Au cours du dernier mois, à quelle fréquence avez-vous eu le sentiment de tout contrôler ?",
                "es" to "En el último mes, ¿con qué frecuencia ha sentido que tenía el control de las cosas?"
            ), pssOptions(), reverseScored = true),
            Question("pss9", mapOf(
                "en" to "In the last month, how often have you been angered because of things that were outside of your control?",
                "fr" to "Au cours du dernier mois, à quelle fréquence avez-vous été en colère à cause de choses qui échappaient à votre contrôle ?",
                "es" to "En el último mes, ¿con qué frecuencia se ha sentido enfadado(a) por cosas que estaban fuera de su control?"
            ), pssOptions()),
            Question("pss10", mapOf(
                "en" to "In the last month, how often have you felt difficulties were piling up so high that you could not overcome them?",
                "fr" to "Au cours du dernier mois, à quelle fréquence avez-vous eu le sentiment que les difficultés s'accumulaient au point que vous ne pouviez pas les surmonter ?",
                "es" to "En el último mes, ¿con qué frecuencia ha sentido que las dificultades se acumulaban tanto que no podía superarlas?"
            ), pssOptions())
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 40,
            thresholds = listOf(
                ScoreThreshold(0, 13, mapOf(
                    "en" to "Low perceived stress",
                    "fr" to "Stress perçu faible",
                    "es" to "Estrés percibido bajo"
                ), mapOf(
                    "en" to "Your perceived stress level is low. Continue maintaining healthy stress management habits.",
                    "fr" to "Votre niveau de stress perçu est faible. Continuez à maintenir des habitudes saines de gestion du stress.",
                    "es" to "Su nivel de estrés percibido es bajo. Continúe manteniendo hábitos saludables de manejo del estrés."
                ), SeverityLevel.NONE),
                ScoreThreshold(14, 26, mapOf(
                    "en" to "Moderate perceived stress",
                    "fr" to "Stress perçu modéré",
                    "es" to "Estrés percibido moderado"
                ), mapOf(
                    "en" to "Your perceived stress level is moderate. Consider stress management techniques or speaking with a professional.",
                    "fr" to "Votre niveau de stress perçu est modéré. Envisagez des techniques de gestion du stress ou de parler avec un professionnel.",
                    "es" to "Su nivel de estrés percibido es moderado. Considere técnicas de manejo del estrés o hablar con un profesional."
                ), SeverityLevel.MODERATE),
                ScoreThreshold(27, 40, mapOf(
                    "en" to "High perceived stress",
                    "fr" to "Stress perçu élevé",
                    "es" to "Estrés percibido alto"
                ), mapOf(
                    "en" to "Your perceived stress level is high. We recommend consulting a healthcare professional to discuss support options.",
                    "fr" to "Votre niveau de stress perçu est élevé. Nous vous recommandons de consulter un professionnel de santé pour discuter des options de soutien.",
                    "es" to "Su nivel de estrés percibido es alto. Le recomendamos consultar a un profesional de la salud para hablar sobre las opciones de apoyo."
                ), SeverityLevel.SEVERE)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Cohen, S., Kamarck, T., Mermelstein, R. (1983). A global measure of perceived stress. Journal of Health and Social Behavior, 24(4), 385-396.",
        estimatedDurationMinutes = 3
    )

    private fun pssOptions(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "Never",
            "fr" to "Jamais",
            "es" to "Nunca"
        )),
        AnswerOption(1, mapOf(
            "en" to "Almost never",
            "fr" to "Presque jamais",
            "es" to "Casi nunca"
        )),
        AnswerOption(2, mapOf(
            "en" to "Sometimes",
            "fr" to "Parfois",
            "es" to "A veces"
        )),
        AnswerOption(3, mapOf(
            "en" to "Fairly often",
            "fr" to "Assez souvent",
            "es" to "Con bastante frecuencia"
        )),
        AnswerOption(4, mapOf(
            "en" to "Very often",
            "fr" to "Très souvent",
            "es" to "Muy a menudo"
        ))
    )
}