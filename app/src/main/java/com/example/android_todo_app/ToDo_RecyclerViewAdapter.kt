package com.example.android_todo_app

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android_todo_app.R
import android_todo_app.databinding.ActivityMainBinding
import com.example.android_todo_app.models.ToDo

class ToDoRecyclerAdapter(private val dataSet: List<ToDo>) :
    RecyclerView.Adapter<ToDoRecyclerAdapter.ViewHolder>(){

//    private var _binding: ActivityMainBinding? = null
//    private val binding get() = _binding!!

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val toDoVM = dataSet[position]

        viewHolder.bindToDo(toDoVM)
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

        fun bindToDo(toDoVM: ToDo) {
            this.description.text = toDoVM.description
            this.dueDate.text = toDoVM.dueDate.toString()
            this.completed.isChecked = toDoVM.completed
        }
    }

}