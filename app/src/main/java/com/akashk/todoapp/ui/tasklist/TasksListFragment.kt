package com.akashk.todoapp.ui.tasklist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.akashk.todoapp.R
import com.akashk.todoapp.database.Task
import com.akashk.todoapp.ui.adapter.TasksAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.tasks_list_fragment.*
import timber.log.Timber

@AndroidEntryPoint
class TasksListFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {


    private lateinit var tasksRecyclerView: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    private val viewModel by viewModels<TasksListViewModel>()

    private val dataObserver = Observer<List<Task>> { tasks ->
        tasksAdapter.submitList(tasks)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.tasks_list_fragment, container, false)

        tasksRecyclerView = view.findViewById(R.id.tasksRecyclerview)

        val btnGotoAddTask = view.findViewById<FloatingActionButton>(R.id.btnGotoAddTask)
        btnGotoAddTask.setOnClickListener {
            it.findNavController().navigate(R.id.action_tasksListFragment_to_addTaskFragment)
        }

        Timber.d("OnCraeteview method is called")
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tasksAdapter = TasksAdapter()
        tasksRecyclerView.adapter = tasksAdapter
        swipeRefresh.setOnRefreshListener(this)
        getDataAndRefresh()
        Timber.d("OnActivitycreated called")
    }


    private fun getDataAndRefresh() {
        viewModel.getAllTasks()
        val tasks = viewModel.tasks
        tasks.observe(viewLifecycleOwner, dataObserver)
        Timber.d("getDataAndRefresh called")
    }

    override fun onRefresh() {
        swipeRefresh.isRefreshing = false
        getDataAndRefresh()
    }
}