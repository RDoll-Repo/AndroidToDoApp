package com.example.android_todo_app.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_todo_app.ToDoList
import com.example.android_todo_app.models.ToDo

class ToDoViewModel: ViewModel() {
    var list = ToDoList.todoList
    var newList = arrayListOf<ToDo>()

    fun addToDo(newToDo: ToDo) {
        newList.add(newToDo)
        list = newList
    }

    fun removeToDo(toDo:ToDo) {
        newList.remove(toDo)
        list = newList
    }

    fun updateToDo(toDo:ToDo, updated:ToDo) {
        newList.set(newList.indexOf(toDo), updated)
        list = newList
    }
}