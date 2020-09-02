package com.akashk.todoapp.ui.addtask

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akashk.todoapp.database.Task
import com.akashk.todoapp.repositories.TasksRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class AddTaskViewModel @ViewModelInject constructor(val repository: TasksRepository) : ViewModel() {

    var task = ObservableField<String>()
    var details = ObservableField<String>()

    var _errorMsg = MutableLiveData<String>()
    var _isAdded = MutableLiveData<Boolean>()

    val errorMsg: LiveData<String>
        get() = _errorMsg

    val isAdded: LiveData<Boolean>
        get() = _isAdded

    fun addTasks() {

        Timber.d("Add task executed")

        if (task.get()?.trim()?.isNullOrEmpty()!!) {
            _errorMsg.postValue("Please enter task")
        } else if (details.get()?.trim()?.isNullOrEmpty()!!) {
            _errorMsg.postValue("Please enter task details")
        } else {
            val taskEntity = Task(task.get()?.trim()!!, details.get()?.trim()!!)
            viewModelScope.launch {
                repository.insertTask(taskEntity)
            }
            _isAdded.postValue(true)
            task.set("")
            details.set("")
        }
    }
}