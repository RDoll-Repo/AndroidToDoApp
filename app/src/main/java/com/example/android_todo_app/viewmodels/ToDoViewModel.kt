package com.example.android_todo_app.viewmodels

import android_todo_app.databinding.ActivityMainBinding
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_todo_app.ToDoList
import com.example.android_todo_app.ToDoRecyclerAdapter
import com.example.android_todo_app.models.ToDo

class ToDoViewModel(): ViewModel() {
    val data: MutableLiveData<ArrayList<ToDo>> by lazy {
        MutableLiveData<ArrayList<ToDo>>()
    }

    var list = ToDoList.todoList

    fun addToDo(newToDo: ToDo) {
        list.add(newToDo)
        data.value = list
    }

    fun removeToDo(toDo:ToDo) {
        list.remove(toDo)
        data.value = list
    }

    fun updateToDo(toDo:ToDo, updated:ToDo) {
        list.set(list.indexOf(toDo), updated)
        data.value = list
    }
}