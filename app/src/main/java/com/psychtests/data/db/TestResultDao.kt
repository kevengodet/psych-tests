package com.psychtests.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import com.psychtests.data.model.TestResult
import com.psychtests.data.model.UserPreferences

@Dao
interface TestResultDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResult(result: TestResult): Long

    @Update
    suspend fun updateResult(result: TestResult): Int

    @Query("SELECT * FROM test_results ORDER BY completedAt DESC")
    fun getAllResults(): Flow<List<TestResult>>

    @Query("SELECT * FROM test_results WHERE testId = :testId ORDER BY completedAt DESC")
    fun getResultsForTest(testId: String): Flow<List<TestResult>>

    @Query("SELECT * FROM test_results WHERE testId = :testId ORDER BY completedAt DESC LIMIT 1")
    fun getLatestResultForTest(testId: String): Flow<TestResult?>

    @Query("SELECT * FROM test_results WHERE id = :id")
    suspend fun getResultById(id: Long): TestResult?

    @Query("DELETE FROM test_results WHERE id = :id")
    suspend fun deleteResult(id: Long): Int

    @Query("DELETE FROM test_results")
    suspend fun deleteAllResults(): Int

    @Query("SELECT COUNT(*) FROM test_results")
    suspend fun getResultCount(): Int

    // User Preferences
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertPreferences(prefs: UserPreferences): Long

    @Query("SELECT * FROM user_preferences WHERE key = 'app_prefs'")
    fun getPreferences(): Flow<UserPreferences?>

    @Query("SELECT * FROM user_preferences WHERE key = 'app_prefs'")
    suspend fun getPreferencesSync(): UserPreferences?
}