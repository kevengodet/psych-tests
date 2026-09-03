package com.psychtests.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psychtests.data.model.Test
import com.psychtests.data.repository.TestRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TestRepository
) : ViewModel() {

    private val _selectedLanguage = MutableStateFlow("en")
    val selectedLanguage: StateFlow<String> = _selectedLanguage.asStateFlow()

    private val _tests = MutableStateFlow<List<Test>>(emptyList())
    val tests: StateFlow<List<Test>> = _tests.asStateFlow()

    fun setLanguage(language: String) {
        _selectedLanguage.value = language
        _tests.value = repository.getTestsForLanguage(language)
    }

    fun search(query: String) {
        val lang = _selectedLanguage.value
        val all = repository.getTestsForLanguage(lang)
        _tests.value = if (query.isBlank()) {
            all
        } else {
            all.filter {
                it.title[lang]?.contains(query, ignoreCase = true) == true ||
                    it.description[lang]?.contains(query, ignoreCase = true) == true
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}