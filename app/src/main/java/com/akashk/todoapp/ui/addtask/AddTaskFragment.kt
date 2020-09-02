package com.akashk.todoapp.ui.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.akashk.todoapp.R
import com.akashk.todoapp.databinding.AddTaskFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.add_task_fragment.view.*


@AndroidEntryPoint
class AddTaskFragment : Fragment() {

    private lateinit var viewModel: AddTaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: AddTaskFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.add_task_fragment, container, false)

        viewModel = ViewModelProvider(this).get(AddTaskViewModel::class.java)
        binding.addtask = viewModel
        binding.setLifecycleOwner(this)

        viewModel.errorMsg.observe(viewLifecycleOwner, Observer { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        })

        viewModel.isAdded.observe(viewLifecycleOwner, Observer { isAdded ->
            if (isAdded) {
               // view?.findNavController()?.popBackStack()
            }
        })

        return binding.root
    }

}