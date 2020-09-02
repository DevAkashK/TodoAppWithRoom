package com.akashk.todoapp.repositories

import com.akashk.todoapp.database.Task
import com.akashk.todoapp.database.TaskDao
import javax.inject.Inject

class TasksRepository @Inject constructor(val taskDao: TaskDao) {

    suspend fun insertTask(task: Task) {
        taskDao.addTask(task)
    }

    suspend fun getAllTasks(): List<Task> {
        return taskDao.getAllTasks()
    }
}