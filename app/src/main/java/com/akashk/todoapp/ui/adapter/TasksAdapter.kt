package com.akashk.todoapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akashk.todoapp.R
import com.akashk.todoapp.database.Task
import com.akashk.todoapp.databinding.TaskListItemBinding

class TasksAdapter : ListAdapter<Task, TasksAdapter.TasksViewHolder>(
    TasksDiffUtilCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val taskListItemBinding = TaskListItemBinding.inflate(
            layoutInflater, parent, false
        );

        return TasksViewHolder(taskListItemBinding)
    }


    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val task = getItem(position)
        holder.bind(task)
    }

    class TasksViewHolder(private var binding: TaskListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.task = task
            binding.executePendingBindings()
        }
    }
}