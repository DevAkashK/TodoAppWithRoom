package com.akashk.todoapp.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.akashk.todoapp.database.Task

class TasksDiffUtilCallback : DiffUtil.ItemCallback<Task>() {

    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return newItem.task_id == oldItem.task_id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return newItem == oldItem
    }

}
