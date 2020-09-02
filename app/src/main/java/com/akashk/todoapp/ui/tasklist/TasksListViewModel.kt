package com.akashk.todoapp.ui.tasklist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akashk.todoapp.database.Task
import com.akashk.todoapp.repositories.TasksRepository
import kotlinx.coroutines.launch

class TasksListViewModel @ViewModelInject constructor(val repository: TasksRepository) : ViewModel() {

    var _tasks=MutableLiveData<List<Task>>()

    val tasks:LiveData<List<Task>>
    get()=_tasks

    fun getAllTasks(){

        viewModelScope.launch {
            val tasksList= repository.getAllTasks()
            _tasks.postValue(tasksList)
        }
    }
}