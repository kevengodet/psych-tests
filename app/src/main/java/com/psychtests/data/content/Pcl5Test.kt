package com.psychtests.data.content

import com.psychtests.data.model.*

object Pcl5Test {

    fun build(): Test = Test(
        id = "pcl5",
        key = "pcl5",
        category = TestCategory.TRAUMA,
        title = mapOf(
            "en" to "PTSD Checklist for DSM-5 (PCL-5)",
            "fr" to "Liste de vérification du TSPT pour le DSM-5 (PCL-5)",
            "es" to "Lista de Verificación de TEPT para el DSM-5 (PCL-5)"
        ),
        description = mapOf(
            "en" to "Screening measure for posttraumatic stress disorder symptoms according to DSM-5 criteria.",
            "fr" to "Outil de dépistage des symptômes du trouble de stress post-traumatique selon les critères du DSM-5.",
            "es" to "Instrumento de cribado de síntomas del trastorno de estrés postraumático según los criterios del DSM-5."
        ),
        instructions = mapOf(
            "en" to "Below is a list of problems that people sometimes have in response to a very stressful experience. Keeping your worst stressful experience in mind, please read each problem carefully and then indicate how much you have been bothered by that problem in the past month.",
            "fr" to "Voici une liste de problèmes que les personnes peuvent ressentir après une expérience très stressante. En gardant à l'esprit votre pire expérience stressante, veuillez lire chaque problème attentivement et indiquer à quel point ce problème vous a gêné(e) au cours du dernier mois.",
            "es" to "A continuación se presenta una lista de problemas que las personas a veces experimentan después de una experiencia muy estresante. Teniendo en mente su peor experiencia estresante, lea cada problema detenidamente e indique cuánto le ha molestado ese problema durante el último mes."
        ),
        questions = listOf(
            Question("pcl1", mapOf(
                "en" to "Repeated, disturbing, and unwanted memories of the stressful experience?",
                "fr" to "Des souvenirs répétés, dérangeants et non désirés de l'expérience stressante ?",
                "es" to "¿Recuerdos repetidos, perturbadores e involuntarios de la experiencia estresante?"
            ), pclOptions()),
            Question("pcl2", mapOf(
                "en" to "Repeated, disturbing dreams of the stressful experience?",
                "fr" to "Des rêves répétés et dérangeants liés à l'expérience stressante ?",
                "es" to "¿Sueños repetidos y perturbadores sobre la experiencia estresante?"
            ), pclOptions()),
            Question("pcl3", mapOf(
                "en" to "Suddenly feeling or acting as if the stressful experience were actually happening again (as if you were actually back there reliving it)?",
                "fr" to "Ressentir ou agir soudainement comme si l'expérience stressante se reproduisait réellement (comme si vous y étiez à nouveau en train de la revivre) ?",
                "es" to "¿Sentir o actuar repentinamente como si la experiencia estresante estuviera sucediendo de nuevo (como si estuviera de nuevo allí reviviéndola)?"
            ), pclOptions()),
            Question("pcl4", mapOf(
                "en" to "Feeling very upset when something reminded you of the stressful experience?",
                "fr" to "Se sentir très bouleversé(e) lorsqu'un élément vous rappelait l'expérience stressante ?",
                "es" to "¿Sentirse muy alterado(a) cuando algo le recordaba la experiencia estresante?"
            ), pclOptions()),
            Question("pcl5", mapOf(
                "en" to "Having strong physical reactions when something reminded you of the stressful experience (for example, heart pounding, trouble breathing, sweating)?",
                "fr" to "Avoir de fortes réactions physiques lorsqu'un élément vous rappelait l'expérience stressante (par exemple, battements de cœur rapides, difficultés à respirer, transpiration) ?",
                "es" to "¿Tener fuertes reacciones físicas cuando algo le recordaba la experiencia estresante (por ejemplo, palpitaciones, dificultad para respirar, sudoración)?"
            ), pclOptions()),
            Question("pcl6", mapOf(
                "en" to "Avoiding memories, thoughts, or feelings related to the stressful experience?",
                "fr" to "Éviter les souvenirs, pensées ou sentiments liés à l'expérience stressante ?",
                "es" to "¿Evitar recuerdos, pensamientos o sentimientos relacionados con la experiencia estresante?"
            ), pclOptions()),
            Question("pcl7", mapOf(
                "en" to "Avoiding external reminders of the stressful experience (for example, people, places, conversations, activities, objects, or situations)?",
                "fr" to "Éviter les rappels externes de l'expérience stressante (par exemple, des personnes, des lieux, des conversations, des activités, des objets ou des situations) ?",
                "es" to "¿Evitar recordatorios externos de la experiencia estresante (por ejemplo, personas, lugares, conversaciones, actividades, objetos o situaciones)?"
            ), pclOptions()),
            Question("pcl8", mapOf(
                "en" to "Trouble remembering important parts of the stressful experience?",
                "fr" to "Difficultés à se souvenir de parties importantes de l'expérience stressante ?",
                "es" to "¿Dificultad para recordar partes importantes de la experiencia estresante?"
            ), pclOptions()),
            Question("pcl9", mapOf(
                "en" to "Having strong negative beliefs about yourself, other people, or the world (for example, thoughts such as: I am bad, there is something seriously wrong with me, no one can be trusted, the world is completely dangerous)?",
                "fr" to "Avoir des croyances négatives fortes sur vous-même, les autres ou le monde (par exemple, des pensées telles que : je suis mauvais(e), il y a quelque chose de gravement anormal chez moi, on ne peut faire confiance à personne, le monde est totalement dangereux) ?",
                "es" to "¿Tener fuertes creencias negativas sobre usted mismo(a), los demás o el mundo (por ejemplo, pensamientos como: soy malo(a), hay algo seriamente malo en mí, no se puede confiar en nadie, el mundo es completamente peligroso)?"
            ), pclOptions()),
            Question("pcl10", mapOf(
                "en" to "Blaming yourself or someone else for the stressful experience or what happened after it?",
                "fr" to "Vous blâmer ou blâmer quelqu'un d'autre pour l'expérience stressante ou pour ce qui s'est produit après ?",
                "es" to "¿Culparse a sí mismo(a) o culpar a otra persona por la experiencia estresante o por lo que sucedió después?"
            ), pclOptions()),
            Question("pcl11", mapOf(
                "en" to "Having strong negative feelings such as fear, horror, anger, guilt, or shame?",
                "fr" to "Avoir des sentiments négatifs forts tels que la peur, l'horreur, la colère, la culpabilité ou la honte ?",
                "es" to "¿Tener fuertes sentimientos negativos como miedo, horror, ira, culpa o vergüenza?"
            ), pclOptions()),
            Question("pcl12", mapOf(
                "en" to "Loss of interest in activities that you used to enjoy?",
                "fr" to "Perte d'intérêt pour les activités que vous aimiez auparavant ?",
                "es" to "¿Pérdida de interés en actividades que solía disfrutar?"
            ), pclOptions()),
            Question("pcl13", mapOf(
                "en" to "Feeling distant or cut off from other people?",
                "fr" to "Se sentir distant(e) ou coupé(e) des autres ?",
                "es" to "¿Sentirse distante o desconectado(a) de otras personas?"
            ), pclOptions()),
            Question("pcl14", mapOf(
                "en" to "Trouble experiencing positive feelings (for example, being unable to feel happiness or have loving feelings for people close to you)?",
                "fr" to "Difficultés à ressentir des émotions positives (par exemple, être incapable de ressentir du bonheur ou des sentiments d'amour pour les personnes proches de vous) ?",
                "es" to "¿Dificultad para experimentar sentimientos positivos (por ejemplo, ser incapaz de sentir felicidad o tener sentimientos amorosos hacia las personas cercanas)?"
            ), pclOptions()),
            Question("pcl15", mapOf(
                "en" to "Irritable behavior, angry outbursts, or acting aggressively?",
                "fr" to "Comportements irritables, accès de colère ou actes agressifs ?",
                "es" to "¿Comportamiento irritable, arrebatos de ira o actuar agresivamente?"
            ), pclOptions()),
            Question("pcl16", mapOf(
                "en" to "Taking too many risks or doing things that could cause you harm?",
                "fr" to "Prendre trop de risques ou faire des choses qui pourraient vous causer du tort ?",
                "es" to "¿Tomar demasiados riesgos o hacer cosas que podrían causarle daño?"
            ), pclOptions()),
            Question("pcl17", mapOf(
                "en" to "Being 'superalert', watchful, or on guard?",
                "fr" to "Être 'hypervigilant(e)', sur le qui-vive ou en alerte ?",
                "es" to "¿Sentirse 'súper alerta', vigilante o en guardia?"
            ), pclOptions()),
            Question("pcl18", mapOf(
                "en" to "Feeling jumpy or easily startled?",
                "fr" to "Avoir des sursauts ou être facilement effrayé(e) ?",
                "es" to "¿Sentirse sobresaltado(a) o asustarse fácilmente?"
            ), pclOptions()),
            Question("pcl19", mapOf(
                "en" to "Having difficulty concentrating?",
                "fr" to "Avoir des difficultés de concentration ?",
                "es" to "¿Tener dificultad para concentrarse?"
            ), pclOptions()),
            Question("pcl20", mapOf(
                "en" to "Trouble falling or staying asleep?",
                "fr" to "Difficultés à s'endormir ou à rester endormi(e) ?",
                "es" to "¿Dificultad para conciliar el sueño o permanecer dormido(a)?"
            ), pclOptions())
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 80,
            thresholds = listOf(
                ScoreThreshold(0, 31, mapOf(
                    "en" to "Below clinical threshold",
                    "fr" to "Sous le seuil clinique",
                    "es" to "Por debajo del umbral clínico"
                ), mapOf(
                    "en" to "Your score is below the provisional clinical threshold for PTSD. However, if you are experiencing distress, consider speaking with a professional.",
                    "fr" to "Votre score est inférieur au seuil clinique provisoire du TSPT. Cependant, si vous ressentez de la détresse, envisagez de parler avec un professionnel.",
                    "es" to "Su puntuación está por debajo del umbral clínico provisional del TEPT. Sin embargo, si está experimentando malestar, considere hablar con un profesional."
                ), SeverityLevel.NONE),
                ScoreThreshold(32, 80, mapOf(
                    "en" to "Above clinical threshold",
                    "fr" to "Au-dessus du seuil clinique",
                    "es" to "Por encima del umbral clínico"
                ), mapOf(
                    "en" to "Your score exceeds the provisional clinical threshold for PTSD. A comprehensive assessment by a mental health professional is strongly recommended.",
                    "fr" to "Votre score dépasse le seuil clinique provisoire du TSPT. Une évaluation complète par un professionnel de la santé mentale est fortement recommandée.",
                    "es" to "Su puntuación supera el umbral clínico provisional del TEPT. Se recomienda encarecidamente una evaluación integral por parte de un profesional de la salud mental."
                ), SeverityLevel.MODERATE)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Weathers, F.W., Litz, B.T., Keane, T.M., Palmieri, P.A., Marx, B.P., Schnurr, P.P. (2013). The PTSD Checklist for DSM-5 (PCL-5). Scale available from the National Center for PTSD.",
        estimatedDurationMinutes = 5
    )

    private fun pclOptions(): List<AnswerOption> = listOf(
        AnswerOption(0, mapOf(
            "en" to "Not at all",
            "fr" to "Pas du tout",
            "es" to "Nada en absoluto"
        )),
        AnswerOption(1, mapOf(
            "en" to "A little bit",
            "fr" to "Un peu",
            "es" to "Un poco"
        )),
        AnswerOption(2, mapOf(
            "en" to "Moderately",
            "fr" to "Modérément",
            "es" to "Moderadamente"
        )),
        AnswerOption(3, mapOf(
            "en" to "Quite a bit",
            "fr" to "Beaucoup",
            "es" to "Bastante"
        )),
        AnswerOption(4, mapOf(
            "en" to "Extremely",
            "fr" to "Extrêmement",
            "es" to "Extremadamente"
        ))
    )
}