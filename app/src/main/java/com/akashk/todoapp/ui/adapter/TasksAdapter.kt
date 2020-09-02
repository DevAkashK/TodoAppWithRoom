package com.akashk.todoapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akashk.todoapp.R
import com.akashk.todoapp.database.Task

class TasksAdapter : ListAdapter<Task, TasksAdapter.TasksViewHolder>(
    TasksDiffUtilCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val item_view =
            LayoutInflater.from(parent.context).inflate(R.layout.task_list_item, parent, false)
        return TasksViewHolder(item_view)
    }


    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val task =getItem(position)
        holder.task.text = task.task_name
        holder.details.text = task.task_details
    }

    class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val task = itemView.findViewById<TextView>(R.id.tvTask)
        val details = itemView.findViewById<TextView>(R.id.tvDetails)
    }
}