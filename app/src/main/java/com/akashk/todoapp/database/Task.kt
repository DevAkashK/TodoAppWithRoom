package com.akashk.todoapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task (var task_name:String,var task_details:String){

    @PrimaryKey(autoGenerate = true)
    var task_id=0
}