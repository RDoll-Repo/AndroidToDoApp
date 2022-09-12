package com.example.android_todo_app.models

data class ToDo(
    var description: String,
    var dueDate: String,
    val createdAt: String,
    var completed: Boolean
    )