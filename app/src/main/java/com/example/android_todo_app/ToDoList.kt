package com.example.android_todo_app

import com.example.android_todo_app.models.ToDo

object ToDoList {
    val todoList = listOf<ToDo>(
        // Sample Data Store - will be extracted to a separate file at some point
        ToDo("Stuff", "2022-12-01", "2024-02-02", true),
        ToDo("Touch Grass", "2022-12-01", "2024-02-02", true),
        ToDo("Get viewbinding working in cards", "2022-12-01", "2024-02-02", true),
        ToDo("Move mock data store","2022-12-01", "2022-12-02", false),
        ToDo("RecyclerView", "2022-12-01", "2024-02-02", true),
        ToDo("Do the dishes", "2022-12-01", "2022-12-02", false)
    )
}