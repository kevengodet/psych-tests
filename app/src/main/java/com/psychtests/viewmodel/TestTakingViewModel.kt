package com.psychtests.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psychtests.data.model.Test
import com.psychtests.data.model.TestResult
import com.psychtests.data.repository.TestRepository
import com.psychtests.util.ScoringEngine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.round

@HiltViewModel
class TestTakingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: TestRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _test = MutableStateFlow<Test?>(null)
    val test: StateFlow<Test?> = _test.asStateFlow()

    private val _language = MutableStateFlow("en")
    val language: StateFlow<String> = _language.asStateFlow()

    private val _answers = MutableStateFlow<Map<String, Int>>(emptyMap())
    val answers: StateFlow<Map<String, Int>> = _answers.asStateFlow()

    private val _currentQuestion = MutableStateFlow(0)
    val currentQuestion: StateFlow<Int> = _currentQuestion.asStateFlow()

    private val _isCompleted = MutableStateFlow(false)
    val isCompleted: StateFlow<Boolean> = _isCompleted.asStateFlow()

    private val _scoreResult = MutableStateFlow<ScoringEngine.ScoreResult?>(null)
    val scoreResult: StateFlow<ScoringEngine.ScoreResult?> = _scoreResult.asStateFlow()

    private val _savedResult = MutableStateFlow<TestResult?>(null)
    val savedResult: StateFlow<TestResult?> = _savedResult.asStateFlow()

    private val startTime = System.currentTimeMillis()
    private var durationSeconds = 0L

    init {
        val testId = savedStateHandle.get<String>("testId") ?: ""
        val lang = savedStateHandle.get<String>("language") ?: "en"
        _language.value = lang
        _test.value = repository.getTestById(testId)
        _isLoading.value = false
    }

    fun answer(questionId: String, value: Int) {
        _answers.value = _answers.value + (questionId to value)
        // Auto-advance to next question after answering
        val current = _currentQuestion.value
        val questionCount = _test.value?.questions?.size ?: 0
        if (current < questionCount - 1) {
            _currentQuestion.value = current + 1
        }
    }

    fun selectQuestion(index: Int) {
        val count = _test.value?.questions?.size ?: 0
        if (index in 0 until count) {
            _currentQuestion.value = index
        }
    }

    fun goToNext() {
        val current = _currentQuestion.value
        val count = _test.value?.questions?.size ?: 0
        if (current < count - 1) {
            _currentQuestion.value = current + 1
        }
    }

    fun goToPrevious() {
        val current = _currentQuestion.value
        if (current > 0) {
            _currentQuestion.value = current - 1
        }
    }

    fun isQuestionAnswered(questionId: String): Boolean = _answers.value.containsKey(questionId)

    fun canSubmit(): Boolean {
        val questionCount = _test.value?.questions?.size ?: 0
        return _answers.value.size == questionCount
    }

    fun submit() {
        viewModelScope.launch {
            val test = _test.value ?: return@launch
            val lang = _language.value
            val result = ScoringEngine.score(test, _answers.value, lang)
            _scoreResult.value = result
            durationSeconds = (System.currentTimeMillis() - startTime) / 1000
            val saved = repository.saveResult(
                test = test,
                language = lang,
                responses = _answers.value,
                durationSeconds = durationSeconds
            )
            _savedResult.value = repository.getResultById(saved)
            _isCompleted.value = true
        }
    }

    fun reset() {
        _answers.value = emptyMap()
        _currentQuestion.value = 0
        _isCompleted.value = false
        _scoreResult.value = null
    }

    fun getResult(): TestResult? = _savedResult.value
}