package com.assessment.programmingheroquiztask.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assesment.programmingheroquizetask.data.DataOrException
import com.assesment.programmingheroquizetask.model.Question
import com.assesment.programmingheroquizetask.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository) :
    ViewModel() {
    val data: MutableState<DataOrException<Question, Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, null)) // Initialize with null data and no exceptions

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            val result = repository.getAllQuestions()
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
            data.value = result
        }
    }
}
