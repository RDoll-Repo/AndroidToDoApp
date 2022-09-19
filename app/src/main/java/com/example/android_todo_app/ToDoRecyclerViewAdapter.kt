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
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android_todo_app.models.ToDo
import com.example.android_todo_app.viewmodels.ToDoViewModel
import java.lang.ref.WeakReference

class ToDoRecyclerAdapter(private val dataSet: ArrayList<ToDo>, tdvm: ToDoViewModel, clickListener: ClickListener)
    : RecyclerView.Adapter<ToDoRecyclerAdapter.ToDoViewHolder>() {
    var listener = clickListener
    var tdvm = tdvm


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = CardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ToDoViewHolder(binding, listener)
    }

    override fun onBindViewHolder(viewHolder: ToDoViewHolder, position: Int) {
        val toDoVM = dataSet[position]

        viewHolder.itemId

        viewHolder.bindToDo(toDoVM)

    }

    override fun getItemCount() = dataSet.size

    inner class ToDoViewHolder(private val binding: CardBinding, listener: ClickListener): RecyclerView.ViewHolder(binding.root) {
        fun bindToDo(toDoVM: ToDo) {
            binding.description.text = toDoVM.description
            binding.dueDate.text = toDoVM.dueDate
            binding.checkbox.isChecked = toDoVM.completed
            //var tdvm = ToDoViewModel()
            var ref = WeakReference<ClickListener>(listener)

            //binding.editButton.setOnClickListener(listener)

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