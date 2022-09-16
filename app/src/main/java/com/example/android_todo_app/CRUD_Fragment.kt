package com.example.android_todo_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android_todo_app.databinding.FragmentCrudBinding
import androidx.fragment.app.Fragment
import com.example.android_todo_app.models.ToDo
import com.example.android_todo_app.viewmodels.ToDoViewModel
import java.util.*

class CRUD_Fragment(todo:ToDo?,  tdvm: ToDoViewModel): Fragment() {

    private var _binding: FragmentCrudBinding? = null
    private val binding get() = _binding!!
    var todo = todo
    var tdvm = tdvm

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentCrudBinding.inflate(inflater, container, false)

        if(todo == null) {
            binding.header.text = "Add a ToDo"
            binding.submitButton.setOnClickListener {
                var newToDo = ToDo(
                    description = binding.description.text.toString(),
                    dueDate = parseDate(),
                    createdAt = Calendar.getInstance().time.toString(),
                    completed = false
                )
                tdvm.addToDo(newToDo)
                activity?.onBackPressed()
            }
        } else {
            binding.header.text = "Edit a ToDo"
            binding.submitButton.setOnClickListener {
                binding.description.hint = todo!!.description
                binding.dueDate.updateDate(
                    todo!!.dueDate.slice(0..3).toInt(),
                    todo!!.dueDate.slice(5..6).toInt(),
                    todo!!.dueDate.slice(8..9).toInt()
                )

                var updated = ToDo(
                    description = binding.description.editableText.toString(),
                    dueDate = parseDate(),
                    createdAt = Calendar.getInstance().time.toString(),
                    completed = false
                )
                tdvm.addToDo(updated)
                activity?.onBackPressed()
            }
        }

        binding.cancelButton.setOnClickListener{
            activity?.onBackPressed()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val description = binding.description
        val due = binding.dueDate
    }

    fun parseDate(): String {
        var date = binding.dueDate.year.toString()
        date += ("-" + binding.dueDate.month.toString() + "-")
        date += binding.dueDate.dayOfMonth

        return date
    }

}