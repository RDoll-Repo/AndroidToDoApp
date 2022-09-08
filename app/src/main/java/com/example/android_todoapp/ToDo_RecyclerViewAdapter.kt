package com.example.android_todoapp

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.example.android_todoapp.models.ToDo

class ToDoRecyclerAdapter(private val dataSet: List<ToDo>) :
    RecyclerView.Adapter<ToDoRecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val toDoVM = dataSet[position]

        viewHolder.description.text = toDoVM.description
        viewHolder.dueDate.text = toDoVM.dueDate.toString()
        viewHolder.completed.isChecked = toDoVM.completed
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val description: TextView
        val dueDate: TextView
        val completed: CheckBox

        init {
            description = view.findViewById(R.id.description)
            dueDate = view.findViewById(R.id.dueDate)
            completed = view.findViewById(R.id.checkbox)
        }
    }

}