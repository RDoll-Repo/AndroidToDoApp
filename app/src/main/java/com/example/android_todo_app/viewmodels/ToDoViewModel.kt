package com.example.android_todo_app.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_todo_app.models.ToDo

class ToDoViewModel: ViewModel() {
    var list = MutableLiveData<ArrayList<ToDo>>()
    var newList = arrayListOf<ToDo>()

    fun addToDo(newToDo: ToDo) {
        newList.add(newToDo)
        list.value = newList
    }

    fun removeToDo(toDo:ToDo) {
        newList.remove(toDo)
        list.value = newList
    }

    fun updateToDo(toDo:ToDo, updated:ToDo) {
        newList.set(newList.indexOf(toDo), updated)
        list.value = newList
    }
}