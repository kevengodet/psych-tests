package com.psychtests.data.content

import com.psychtests.data.model.*

object AceTest {

    fun build(): Test = Test(
        id = "ace",
        key = "ace",
        category = TestCategory.TRAUMA,
        title = mapOf(
            "en" to "Adverse Childhood Experiences Questionnaire (ACE)",
            "fr" to "Questionnaire sur les expériences adverses de l'enfance (ACE)",
            "es" to "Cuestionario de Experiencias Adversas en la Infancia (ACE)"
        ),
        description = mapOf(
            "en" to "Screening questionnaire measuring 10 types of childhood trauma and adversity (before age 18).",
            "fr" to "Questionnaire de dépistage mesurant 10 types de traumatismes et d'adversité dans l'enfance (avant 18 ans).",
            "es" to "Cuestionario de cribado que mide 10 tipos de traumatismos y adversidad en la infancia (antes de los 18 años)."
        ),
        instructions = mapOf(
            "en" to "You will be asked questions about your experiences before your 18th birthday. For each question, please answer how often you experienced this.",
            "fr" to "Vous allez être interrogé(e) sur vos expériences avant votre 18e anniversaire. Pour chaque question, veuillez indiquer à quelle fréquence vous avez vécu cela.",
            "es" to "Se le harán preguntas sobre sus experiencias antes de cumplir 18 años. Para cada pregunta, responda con qué frecuencia experimentó esto."
        ),
        questions = listOf(
            Question("ace1", mapOf(
                "en" to "Before your 18th birthday, did a parent or other adult in the household often or very often swear at you, insult you, put you down, or humiliate you OR act in a way that made you afraid that you might be physically hurt?",
                "fr" to "Avant votre 18e anniversaire, un parent ou un autre adulte du foyer vous a-t-il souvent ou très souvent injurié(e), insulté(e), rabaissé(e) ou humilié(e), OU a-t-il agi d'une manière qui vous faisait craindre d'être blessé(e) physiquement ?",
                "es" to "Antes de cumplir 18 años, ¿con frecuencia un padre u otro adulto del hogar le insultó, menospreció, humilló o actuó de una manera que le hizo temer que pudiera ser lastimado físicamente?"
            ), aceOptions()),
            Question("ace2", mapOf(
                "en" to "Before your 18th birthday, did a parent or other adult in the household often or very often push, grab, slap, or throw something at you OR ever hit you so hard that you had marks or were injured?",
                "fr" to "Avant votre 18e anniversaire, un parent ou un autre adulte du foyer vous a-t-il souvent ou très souvent poussé(e), attrapé(e), giflé(e), ou a-t-il jeté un objet sur vous, OU vous a-t-il un jour frappé(e) si fort que vous en gardiez des marques ou des blessures ?",
                "es" to "Antes de cumplir 18 años, ¿con frecuencia un padre u otro adulto del hogar le empujó, agarró, abofeteó o le lanzó algún objeto, o alguna vez le golpeó tan fuerte que le dejó marcas o le lesionó?"
            ), aceOptions()),
            Question("ace3", mapOf(
                "en" to "Before your 18th birthday, did an adult or person at least 5 years older than you ever touch or fondle you or have you touch their body in a sexual way OR attempt or actually have oral, anal, or vaginal intercourse with you?",
                "fr" to "Avant votre 18e anniversaire, un adulte ou une personne d'au moins 5 ans plus âgée que vous vous a-t-elle un jour touché(e) ou caressé(e), ou vous a-t-elle fait toucher son corps de façon sexuelle, OU a-t-elle tenté ou réellement eu des rapports oraux, anaux ou vaginaux avec vous ?",
                "es" to "Antes de cumplir 18 años, ¿alguna vez un adulto o una persona al menos 5 años mayor que usted le tocó o acarició, o le hizo tocar su cuerpo de manera sexual, o intentó o mantuvo relaciones orales, anales o vaginales con usted?"
            ), aceOptions()),
            Question("ace4", mapOf(
                "en" to "Before your 18th birthday, did you often or very often feel that no one in your family loved you or thought you were important or special OR your family didn't look out for each other, feel close to each other, or support each other?",
                "fr" to "Avant votre 18e anniversaire, avez-vous souvent ou très souvent eu le sentiment que personne dans votre famille ne vous aimait, ne pensait que vous étiez important(e) ou spécial(e), OU que votre famille ne s'occupait pas les uns des autres, n'était pas proche, ou ne se soutenait pas ?",
                "es" to "Antes de cumplir 18 años, ¿con frecuencia sintió que nadie en su familia le quería o pensaba que usted era importante o especial, o que su familia no se cuidaba entre sí, no era cercana o no se apoyaba mutuamente?"
            ), aceOptions()),
            Question("ace5", mapOf(
                "en" to "Before your 18th birthday, did you often or very often feel that you didn't have enough to eat, had to wear dirty clothes, and had no one to protect you OR your parents were too drunk or high to take care of you or take you to the doctor if you needed it?",
                "fr" to "Avant votre 18e anniversaire, avez-vous souvent ou très souvent eu le sentiment que vous n'aviez pas assez à manger, que vous deviez porter des vêtements sales, que personne ne vous protégeait, OU que vos parents étaient trop ivres ou défoncés pour s'occuper de vous ou vous emmener chez le médecin si nécessaire ?",
                "es" to "Antes de cumplir 18 años, ¿con frecuencia sintió que no tenía suficiente comida, que tenía que usar ropa sucia y que no tenía a nadie que le protegiera, o que sus padres estaban demasiado ebrios o drogados para cuidar de usted o llevarle al médico si lo necesitaba?"
            ), aceOptions()),
            Question("ace6", mapOf(
                "en" to "Before your 18th birthday, was a biological parent ever lost to you through divorce, abandonment, or other reason?",
                "fr" to "Avant votre 18e anniversaire, avez-vous perdu un parent biologique à cause d'un divorce, d'un abandon ou d'une autre raison ?",
                "es" to "Antes de cumplir 18 años, ¿perdió a uno de sus padres biológicos por divorcio, abandono u otra razón?"
            ), aceOptions()),
            Question("ace7", mapOf(
                "en" to "Before your 18th birthday, was your mother or stepmother often or very often pushed, grabbed, slapped, or had something thrown at her OR sometimes, often, or very often kicked, bitten, hit with a fist, or hit with something hard OR ever repeatedly hit over at least a few minutes or threatened with a gun or knife?",
                "fr" to "Avant votre 18e anniversaire, votre mère ou votre belle-mère a-t-elle souvent ou très souvent été poussée, attrapée, giflée, ou a-t-elle eu un objet jeté sur elle, OU parfois, souvent ou très souvent frappée avec le pied, mordue, frappée avec le poing ou avec un objet dur, OU a-t-elle été un jour frappée à répétition pendant au moins quelques minutes ou menacée avec une arme à feu ou un couteau ?",
                "es" to "Antes de cumplir 18 años, ¿con frecuencia su madre o madrastra fue empujada, agarrada, abofeteada, o le lanzaron algún objeto, o a veces, a menudo o muy a menudo fue pateada, mordida, golpeada con el puño o con un objeto duro, o alguna vez fue golpeada repetidamente durante al menos unos minutos o amenazada con un arma o un cuchillo?"
            ), aceOptions()),
            Question("ace8", mapOf(
                "en" to "Before your 18th birthday, did you live with anyone who was a problem drinker or alcoholic, or who used street drugs?",
                "fr" to "Avant votre 18e anniversaire, avez-vous vécu avec une personne qui avait un problème d'alcool ou était alcoolique, ou qui consommait des drogues ?",
                "es" to "Antes de cumplir 18 años, ¿vivió con alguien que tenía un problema de bebida o era alcohólico, o que consumía drogas?"
            ), aceOptions()),
            Question("ace9", mapOf(
                "en" to "Before your 18th birthday, did you live with anyone who was depressed, mentally ill, or attempted suicide?",
                "fr" to "Avant votre 18e anniversaire, avez-vous vécu avec une personne déprimée, souffrant d'une maladie mentale ou ayant tenté de se suicider ?",
                "es" to "Antes de cumplir 18 años, ¿vivió con alguien que estaba deprimido, tenía una enfermedad mental o intentó suicidarse?"
            ), aceOptions()),
            Question("ace10", mapOf(
                "en" to "Before your 18th birthday, did a household member go to prison?",
                "fr" to "Avant votre 18e anniversaire, un membre du foyer a-t-il été envoyé en prison ?",
                "es" to "Antes de cumplir 18 años, ¿algún miembro del hogar fue a prisión?"
            ), aceOptions())
        ),
        scoring = ScoringMethod.SumScoring(
            minScore = 0,
            maxScore = 10,
            thresholds = listOf(
                ScoreThreshold(0, 0, mapOf(
                    "en" to "No ACEs",
                    "fr" to "Aucun ACE",
                    "es" to "Sin EAI"
                ), mapOf(
                    "en" to "You reported no adverse childhood experiences in the categories assessed. Take care of your health and wellbeing.",
                    "fr" to "Vous n'avez signalé aucune expérience adverse de l'enfance dans les catégories évaluées. Prenez soin de votre santé et de votre bien-être.",
                    "es" to "No informó de experiencias adversas en la infancia en las categorías evaluadas. Cuide su salud y bienestar."
                ), SeverityLevel.NONE),
                ScoreThreshold(1, 3, mapOf(
                    "en" to "1-3 ACEs",
                    "fr" to "1 à 3 ACE",
                    "es" to "1-3 EAI"
                ), mapOf(
                    "en" to "You reported 1-3 adverse childhood experiences. Consider speaking with a professional about how these experiences may affect you.",
                    "fr" to "Vous avez signalé 1 à 3 expériences adverses de l'enfance. Envisagez de parler avec un professionnel de l'impact possible de ces expériences sur vous.",
                    "es" to "Informó de 1-3 experiencias adversas en la infancia. Considere hablar con un profesional sobre cómo estas experiencias pueden afectarle."
                ), SeverityLevel.MILD),
                ScoreThreshold(4, 10, mapOf(
                    "en" to "4 or more ACEs",
                    "fr" to "4 ACE ou plus",
                    "es" to "4 o más EAI"
                ), mapOf(
                    "en" to "You reported 4 or more adverse childhood experiences. Research indicates this may be associated with increased health risks. We recommend speaking with a healthcare professional.",
                    "fr" to "Vous avez signalé 4 expériences adverses de l'enfance ou plus. La recherche indique que cela peut être associé à des risques accrus pour la santé. Nous vous recommandons de parler avec un professionnel de santé.",
                    "es" to "Informó de 4 o más experiencias adversas en la infancia. La investigación indica que esto puede estar asociado con mayores riesgos para la salud. Le recomendamos hablar con un profesional de la salud."
                ), SeverityLevel.SEVERE)
            )
        ),
        availableLanguages = listOf("en", "fr", "es"),
        version = "1.0",
        reference = "Felitti, V.J., Anda, R.F., Nordenberg, D., et al. (1998). Relationship of childhood abuse and household dysfunction to many of the leading causes of death in adults. American Journal of Preventive Medicine, 14(4), 245-258.",
        estimatedDurationMinutes = 3
    )

    private fun aceOptions(): List<AnswerOption> = listOf(
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