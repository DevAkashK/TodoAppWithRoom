package com.akashk.todoapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert
    suspend fun addTask(task: Task)

    @Query("select * from  Task")
    suspend fun getAllTasks(): List<Task>
}