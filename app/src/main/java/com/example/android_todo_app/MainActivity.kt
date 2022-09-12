package com.example.android_todo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        // Sample Data Store - will be extracted to a separate file at some point
        val u = ToDo("Stuff", "2022-12-01", "2024-02-02", true)
        val v = ToDo("Touch Grass", "2022-12-01", "2024-02-02", true)
        val w = ToDo("Get viewbinding working in cards", "2022-12-01", "2024-02-02", true)
        val x = ToDo("Move mock data store","2022-12-01", "2022-12-02", false)
        val y = ToDo("RecyclerView", "2022-12-01", "2024-02-02", true)
        val z = ToDo("Do the dishes", "2022-12-01", "2022-12-02", false)

        val list = arrayListOf<ToDo>(u, v, w, x, y ,z)

        val recyclerView = binding.list

        // create layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initializing
        val data = ArrayList<ToDo>()

        for (i in list)
        {
            data.add(i)
        }

        val adapter = ToDoRecyclerAdapter(data)

        recyclerView.adapter = adapter
    }
}