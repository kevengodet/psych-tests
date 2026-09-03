package com.psychtests.data.repository

import com.psychtests.data.content.TestCatalog
import com.psychtests.data.db.TestResultDao
import com.psychtests.data.model.*
import com.psychtests.util.ScoringEngine
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepository @Inject constructor(
    private val dao: TestResultDao
) {
    fun getAllTests(): List<Test> = TestCatalog.getAllTests()

    fun getTestsForLanguage(language: String): List<Test> =
        TestCatalog.getTestsForLanguage(language)

    fun getTestById(id: String): Test? = TestCatalog.getTestById(id)

    fun getTestByKey(key: String): Test? =
        TestCatalog.getAllTests().firstOrNull { it.key == key }

    suspend fun saveResult(
        test: Test,
        language: String,
        responses: Map<String, Int>,
        durationSeconds: Long = 0
    ): Long {
        val scoreResult = ScoringEngine.score(test, responses, language)
        val result = TestResult(
            testId = test.id,
            testKey = test.key,
            testTitle = test.title[language] ?: test.title["en"] ?: test.key,
            language = language,
            score = scoreResult.totalScore,
            maxScore = scoreResult.maxScore,
            subscaleScores = scoreResult.subscaleResults.mapValues { it.value.score },
            severity = scoreResult.severity,
            severityLabel = scoreResult.severityLabel,
            interpretation = scoreResult.interpretation,
            responses = responses,
            completedAt = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
            durationSeconds = durationSeconds
        )
        return dao.insertResult(result)
    }

    fun getAllResults(): Flow<List<TestResult>> = dao.getAllResults()

    fun getResultsForTest(testId: String): Flow<List<TestResult>> =
        dao.getResultsForTest(testId)

    fun getLatestResultForTest(testId: String): Flow<TestResult?> =
        dao.getLatestResultForTest(testId)

    suspend fun deleteResult(id: Long): Int = dao.deleteResult(id)

    suspend fun getResultById(id: Long): TestResult? = dao.getResultById(id)

    suspend fun deleteAllResults(): Int = dao.deleteAllResults()

    suspend fun getResultCount(): Int = dao.getResultCount()

    // Preferences
    suspend fun getPreferences(): UserPreferences? = dao.getPreferencesSync()

    suspend fun savePreferences(prefs: UserPreferences) {
        dao.upsertPreferences(prefs)
    }

    fun getPreferencesFlow(): Flow<UserPreferences?> = dao.getPreferences()
}