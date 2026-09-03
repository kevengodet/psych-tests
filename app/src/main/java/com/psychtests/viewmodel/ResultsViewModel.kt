package com.psychtests.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psychtests.data.model.TestResult
import com.psychtests.data.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val repository: TestRepository
) : ViewModel() {

    private val _recentResults = MutableStateFlow<List<TestResult>>(emptyList())
    val recentResults: StateFlow<List<TestResult>> = _recentResults.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllResults().collect { results ->
                _recentResults.value = results
            }
        }
    }

    fun deleteResult(id: Long) {
        viewModelScope.launch {
            repository.deleteResult(id)
        }
    }
}