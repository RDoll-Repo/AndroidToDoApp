//package com.example.android_todoapp
//
//import android.os.Bundle
//import android.view.View
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.android_todoapp.models.ToDo
//import java.time.LocalDate
//import java.time.LocalDateTime
//import java.time.Month
//import java.util.*
//import kotlin.collections.ArrayList
//
//class HomeFragment : Fragment(R.layout.home_fragment) {
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.todoList)
//
//        recyclerView?.layoutManager = LinearLayoutManager(context)
//
//        val x = ToDo("Test", Date("2022-12-01"), Date("2022-12-02"), false)
//        val y = ToDo("RecyclerView", Date("2022-12-01"), Date("2024-02-02"), true)
//        val z = ToDo("Do the dishes", Date("2022-12-01"), Date("2022-12-02"), true)
//
//        val list = arrayListOf<ToDo>(x, y, z)
//
//        val adapter = ToDoRecyclerAdapter(list)
//
//        recyclerView?.adapter = adapter
//    }
//
//
//}