package com.example.android_todo_app

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
import com.example.android_todo_app.models.ToDo
import com.example.android_todo_app.viewmodels.ToDoViewModel

class ToDoRecyclerAdapter(private val dataSet: List<ToDo>)
    : RecyclerView.Adapter<ToDoRecyclerAdapter.ToDoViewHolder>() {

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

    class ToDoViewHolder(private val binding: CardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindToDo(toDoVM: ToDo) {
            binding.description.text = toDoVM.description
            binding.dueDate.text = toDoVM.dueDate
            binding.checkbox.isChecked = toDoVM.completed
        }

        @Override
        fun onClick(v: View) {
            if (v.id == binding.editButton.id)
            {
                Toast.makeText(v.context, adapterPosition.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

}