package com.psychtests.data.content

import com.psychtests.data.model.Test

object TestCatalog {
    private val allTests: List<Test> = listOf(
        Phq9Test.build(),
        Gad7Test.build(),
        Who5Test.build(),
        HadsTest.build(),
        Pcl5Test.build(),
        Pss10Test.build(),
        Dass21Test.build(),
        EpdsTest.build(),
        AuditTest.build(),
        ScoffTest.build(),
        AceTest.build(),
        SwlsTest.build()
    )

    fun getAllTests(): List<Test> = allTests

    fun getTestsForLanguage(language: String): List<Test> =
        allTests.filter { language in it.availableLanguages }

    fun getTestById(id: String): Test? = allTests.firstOrNull { it.id == id }
}