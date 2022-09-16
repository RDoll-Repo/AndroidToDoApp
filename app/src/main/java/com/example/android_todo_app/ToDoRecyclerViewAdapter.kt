package com.example.android_todo_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import android_todo_app.R
import android_todo_app.databinding.ActivityMainBinding
import android_todo_app.databinding.CardBinding
import androidx.fragment.app.Fragment
import com.example.android_todo_app.models.ToDo
import com.example.android_todo_app.viewmodels.ToDoViewModel

class ToDoRecyclerAdapter(private val dataSet: ArrayList<ToDo>, tdvm: ToDoViewModel)
    : RecyclerView.Adapter<ToDoRecyclerAdapter.ToDoViewHolder>() {
    var tdvm = tdvm

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = CardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ToDoViewHolder, position: Int) {
        val toDoVM = dataSet[position]

        viewHolder.itemId

        viewHolder.bindToDo(toDoVM)

    }

    override fun getItemCount() = dataSet.size

    inner class ToDoViewHolder(private val binding: CardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindToDo(toDoVM: ToDo) {
            binding.description.text = toDoVM.description
            binding.dueDate.text = toDoVM.dueDate
            binding.checkbox.isChecked = toDoVM.completed
            //var tdvm = ToDoViewModel()

            binding.editButton.setOnClickListener{
                var updated = ToDo("Updated", "2022-12-01", "2024-02-02", true)
                tdvm.updateToDo(toDoVM, updated)
            }

            binding.deleteButton.setOnClickListener{
                tdvm.removeToDo(toDoVM)
            }

            binding.checkbox.setOnClickListener{
                toDoVM.completed = binding.checkbox.isChecked
                tdvm.updateToDo(toDoVM, toDoVM)
            }
        }
    }
}