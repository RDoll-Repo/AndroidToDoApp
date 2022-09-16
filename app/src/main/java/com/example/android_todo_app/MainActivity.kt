package com.example.android_todo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android_todo_app.R
import android_todo_app.databinding.ActivityMainBinding
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_todo_app.models.ToDo
import com.example.android_todo_app.viewmodels.ToDoViewModel
import java.io.Console
import java.lang.Exception

// TODO: Use fragments
// TODO: Cleanup
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
            var frag = CRUD_Fragment(null, tdvm)
            var manager = supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container_view, frag)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }


}