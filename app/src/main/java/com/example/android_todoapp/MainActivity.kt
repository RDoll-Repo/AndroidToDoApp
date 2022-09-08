package com.example.android_todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_todoapp.models.ToDo
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (savedInstanceState == null) {
        val u = ToDo("Stuff", "2022-12-01", "2024-02-02", true)
        val v = ToDo("Touch Grass", "2022-12-01", "2024-02-02", true)
        val w = ToDo("become a competent developer", "2022-12-01", "2024-02-02", true)
        val x = ToDo("Deal with Spectrum's bullshit","2022-12-01", "2022-12-02", false)
        val y = ToDo("RecyclerView", "2022-12-01", "2024-02-02", true)
        val z = ToDo("Do the dishes", "2022-12-01", "2022-12-02", false)

        val list = arrayListOf<ToDo>(u, v, w, x, y ,z)


//            val bundle = bundleOf("data" to list)
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add<HomeFragment>(R.id.fragment_container_view)
//            }
//        }

        // Get recycler view by ID
        val recyclerView = findViewById<RecyclerView>(R.id.list)

        // create layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ToDo>()

        for (i in list)
        {
            data.add(i)
        }

        val adapter = ToDoRecyclerAdapter(data)

        recyclerView.adapter = adapter
    }


}