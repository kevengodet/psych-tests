package com.psychtests.viewmodel

import androidx.lifecycle.SavedStateHandle
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
class ResultDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: TestRepository
) : ViewModel() {

    private val _result = MutableStateFlow<TestResult?>(null)
    val result: StateFlow<TestResult?> = _result.asStateFlow()

    private var resultId: Long = 0L

    fun loadResult(id: Long) {
        resultId = id
        viewModelScope.launch {
            _result.value = repository.getResultById(id)
        }
    }
}