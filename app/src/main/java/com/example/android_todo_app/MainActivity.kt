package com.example.android_todo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android_todo_app.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_todo_app.models.ToDo
import java.util.*
import kotlin.collections.ArrayList

// TODO: Basic CRUD on cards
// TODO: Move Sample Data Store to separate file
// TODO: Use fragments
// TODO: Connect to API

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.list

        // create layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initializing
        val data = ToDoList.todoList

        val adapter = ToDoRecyclerAdapter(data)

        recyclerView.adapter = adapter

        binding.buttonAdd.setOnClickListener {
            Toast.makeText(this, "Clicked!", Toast.LENGTH_LONG).show()
        }
    }

}