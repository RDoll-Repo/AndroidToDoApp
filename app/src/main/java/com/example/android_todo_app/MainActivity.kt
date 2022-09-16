package com.example.android_todo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android_todo_app.databinding.ActivityMainBinding
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_todo_app.models.ToDo
import com.example.android_todo_app.viewmodels.ToDoViewModel
import java.util.*
import kotlin.collections.ArrayList

// TODO: Basic CRUD on cards
// TODO: Move Sample Data Store to separate file
// TODO: Use fragments
// TODO: Connect to API

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!
    var tdvm = ToDoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.list

        // create layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initializing
        val liveData = tdvm.data
        val data = tdvm.list

        val adapter = ToDoRecyclerAdapter(data, tdvm)

        recyclerView.adapter = adapter

        liveData.observe(this, Observer {
            adapter.notifyDataSetChanged()
        })



        binding.buttonAdd.setOnClickListener {
            var added = ToDo("Add Button", "2022-9-20", "2022-9-15", false)
            tdvm.addToDo(added)
            adapter.notifyDataSetChanged()
        }
    }

}