package com.psychtests.util

import com.psychtests.data.content.*
import com.psychtests.data.model.SeverityLevel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ScoringEngineTest {

    @Test
    fun `PHQ-9 no depression scores None Minimal`() {
        val test = Phq9Test.build()
        val responses = mapOf(
            "phq1" to 0, "phq2" to 0, "phq3" to 0, "phq4" to 0,
            "phq5" to 0, "phq6" to 0, "phq7" to 0, "phq8" to 0, "phq9" to 0
        )
        val result = ScoringEngine.score(test, responses, "en")
        assertEquals(0.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.NONE, result.severity)
        assertEquals(27.0, result.maxScore, 0.0)
    }

    @Test
    fun `PHQ-9 moderate depression scoring`() {
        val test = Phq9Test.build()
        val responses = mapOf(
            "phq1" to 2, "phq2" to 2, "phq3" to 1, "phq4" to 2,
            "phq5" to 1, "phq6" to 1, "phq7" to 2, "phq8" to 0, "phq9" to 0
        )
        val result = ScoringEngine.score(test, responses, "en")
        // 2+2+1+2+1+1+2+0+0 = 11
        assertEquals(11.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.MODERATE, result.severity)
        assertEquals("Moderate", result.severityLabel)
    }

    @Test
    fun `PSS-10 reverse scoring correctly calculated`() {
        val test = Pss10Test.build()
        // Items 4, 5, 7, 8 are reverse-scored
        val responses = mapOf(
            "pss1" to 4, "pss2" to 4, "pss3" to 4, "pss4" to 0,
            "pss5" to 0, "pss6" to 4, "pss7" to 0, "pss8" to 0, "pss9" to 4, "pss10" to 4
        )
        val result = ScoringEngine.score(test, responses, "en")
        // Forward: pss1=4,pss2=4,pss3=4 = 12; pss6=4,pss9=4,pss10=4 = 12
        // Reverse: pss4: 4-0=4, pss5:4-0=4, pss7:4-0=4, pss8:4-0=4 = 16
        // Total = 12 + 12 + 16 = 40 (max stress)
        assertEquals(40.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.SEVERE, result.severity)
    }

    @Test
    fun `GAD-7 severe anxiety`() {
        val test = Gad7Test.build()
        val responses = mapOf(
            "gad1" to 3, "gad2" to 3, "gad3" to 2, "gad4" to 2,
            "gad5" to 2, "gad6" to 2, "gad7" to 3
        )
        val result = ScoringEngine.score(test, responses, "en")
        // 3+3+2+2+2+2+3 = 17
        assertEquals(17.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.SEVERE, result.severity)
        assertEquals(21.0, result.maxScore, 0.0)
    }

    @Test
    fun `DASS-21 subscale scoring`() {
        val test = Dass21Test.build()
        // Answered all depression items = 3, others 0
        val responses = buildMap {
            (1..21).forEach { i -> put("dass$i", 0) }
            put("dass3", 3); put("dass5", 3); put("dass10", 3)
            put("dass13", 3); put("dass16", 3); put("dass17", 3); put("dass21", 3)
        }
        val result = ScoringEngine.score(test, responses, "en")
        // Depression subscale: 7 items x 3 = 21
        val depression = requireNotNull(result.subscaleResults["depression"])
        assertEquals(21.0, depression.score, 0.0)
        assertEquals(SeverityLevel.EXTREME, depression.severity)
        // total = 21
        assertEquals(21.0, result.totalScore, 0.0)
    }

    @Test
    fun `All tests are available in all three languages`() {
        listOf("en", "fr", "es").forEach { lang ->
            val tests = TestCatalog.getTestsForLanguage(lang)
            assertTrue("Expected tests for $lang", tests.isNotEmpty())
        }
    }

    @Test
    fun `WHO-5 low well-being below threshold`() {
        val test = Who5Test.build()
        val responses = mapOf(
            "who5_1" to 1, "who5_2" to 1, "who5_3" to 1,
            "who5_4" to 1, "who5_5" to 1
        )
        val result = ScoringEngine.score(test, responses, "en")
        assertEquals(5.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.MODERATE, result.severity)
    }

    @Test
    fun `French translation of severity labels present`() {
        val test = Phq9Test.build()
        val responses = mapOf(
            "phq1" to 3, "phq2" to 3, "phq3" to 3, "phq4" to 3,
            "phq5" to 2, "phq6" to 2, "phq7" to 2, "phq8" to 2, "phq9" to 1
        )
        val result = ScoringEngine.score(test, responses, "fr")
        assertEquals(21.0, result.totalScore, 0.0)
        assertTrue(result.severityLabel.isNotBlank())
    }

    @Test
    fun `HADS anxiety subscale severe case`() {
        val test = HadsTest.build()
        val responses = mapOf(
            "hads1" to 3, "hads3" to 3, "hads5" to 3, "hads7" to 3,
            "hads9" to 3, "hads11" to 3, "hads13" to 3,
            "hads2" to 0, "hads4" to 0, "hads6" to 0, "hads8" to 0,
            "hads10" to 0, "hads12" to 0, "hads14" to 0
        )
        val result = ScoringEngine.score(test, responses, "en")
        // Anxiety: 7 items x 3 = 21, Depression: 7 items x 0 = 0, Total: 21
        assertEquals(21.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.MODERATE, result.severity)
        assertTrue(result.severityLabel.isNotBlank())
        val anxiety = requireNotNull(result.subscaleResults["anxiety"])
        assertEquals(21.0, anxiety.score, 0.0)
        assertEquals(SeverityLevel.MODERATE, anxiety.severity)
        assertEquals("Abnormal", anxiety.severityLabel)
        val depression = requireNotNull(result.subscaleResults["depression"])
        assertEquals(0.0, depression.score, 0.0)
        assertEquals(SeverityLevel.NONE, depression.severity)
        assertEquals("Normal", depression.severityLabel)
    }

    @Test
    fun `HADS depression subscale severe case`() {
        val test = HadsTest.build()
        val responses = mapOf(
            "hads1" to 0, "hads3" to 0, "hads5" to 0, "hads7" to 0,
            "hads9" to 0, "hads11" to 0, "hads13" to 0,
            "hads2" to 3, "hads4" to 3, "hads6" to 3, "hads8" to 3,
            "hads10" to 3, "hads12" to 3, "hads14" to 3
        )
        val result = ScoringEngine.score(test, responses, "en")
        // Depression options have 3 = worst, so 7 items x 3 = 21, Total: 21
        assertEquals(21.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.MODERATE, result.severity)
        val anxiety = requireNotNull(result.subscaleResults["anxiety"])
        assertEquals(0.0, anxiety.score, 0.0)
        assertEquals(SeverityLevel.NONE, anxiety.severity)
        assertEquals("Normal", anxiety.severityLabel)
        val depression = requireNotNull(result.subscaleResults["depression"])
        assertEquals(21.0, depression.score, 0.0)
        assertEquals(SeverityLevel.MODERATE, depression.severity)
        assertEquals("Abnormal", depression.severityLabel)
    }

    @Test
    fun `EPDS depression likely case all items high`() {
        val test = EpdsTest.build()
        val responses = mapOf(
            "epds1" to 3, "epds2" to 3,
            "epds3" to 3, "epds4" to 3, "epds5" to 3, "epds6" to 3,
            "epds7" to 3, "epds8" to 3, "epds9" to 3, "epds10" to 3
        )
        val result = ScoringEngine.score(test, responses, "en")
        // All items scored at 3 = 10 x 3 = 30
        assertEquals(30.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.SEVERE, result.severity)
        assertTrue(result.severityLabel.isNotBlank())
    }

    @Test
    fun `AUDIT harmful drinking scoring`() {
        val test = AuditTest.build()
        val responses = mapOf(
            "audit1" to 2, "audit2" to 2, "audit3" to 2,
            "audit4" to 1, "audit5" to 1, "audit6" to 1,
            "audit7" to 1, "audit8" to 1, "audit9" to 2, "audit10" to 2
        )
        val result = ScoringEngine.score(test, responses, "en")
        // 2+2+2+1+1+1+1+1+2+2 = 15
        assertEquals(15.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.MODERATE, result.severity)
        assertTrue(result.severityLabel.isNotBlank())
    }

    @Test
    fun `PCL-5 severe PTSD scoring`() {
        val test = Pcl5Test.build()
        val responses = (1..20).associate { "pcl$it" to 3 }
        val result = ScoringEngine.score(test, responses, "en")
        // 20 items x 3 = 60
        assertEquals(60.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.MODERATE, result.severity)
        assertTrue(result.severityLabel.isNotBlank())
    }

    @Test
    fun `SWLS high satisfaction scoring`() {
        val test = SwlsTest.build()
        val responses = mapOf(
            "swls1" to 7, "swls2" to 7, "swls3" to 7, "swls4" to 7, "swls5" to 7
        )
        val result = ScoringEngine.score(test, responses, "en")
        assertEquals(35.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.NONE, result.severity)
        assertEquals("Extremely satisfied", result.severityLabel)
    }

    @Test
    fun `WHO-5 maximum well-being scoring`() {
        val test = Who5Test.build()
        val responses = mapOf(
            "who5_1" to 5, "who5_2" to 5, "who5_3" to 5, "who5_4" to 5, "who5_5" to 5
        )
        val result = ScoringEngine.score(test, responses, "en")
        assertEquals(25.0, result.totalScore, 0.0)
        assertEquals(SeverityLevel.NONE, result.severity)
        assertEquals("Average or high well-being", result.severityLabel)
    }
}