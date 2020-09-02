package com.akashk.todoapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Task::class],version = 1)
abstract class TasksDatabase: RoomDatabase() {
    
    abstract fun getTaskDao():TaskDao
    
}