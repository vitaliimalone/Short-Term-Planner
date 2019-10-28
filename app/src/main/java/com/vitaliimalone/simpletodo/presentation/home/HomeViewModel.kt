package com.vitaliimalone.simpletodo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitaliimalone.simpletodo.domain.models.Task
import com.vitaliimalone.simpletodo.domain.usecases.AddTaskUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
        private val addTaskUseCase: AddTaskUseCase
) : ViewModel() {
    fun addNewTask(task: Task) {
        viewModelScope.launch {
            addTaskUseCase.addTask(task)
        }
    }
}
