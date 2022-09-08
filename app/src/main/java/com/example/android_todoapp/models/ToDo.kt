package com.example.android_todoapp.models

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class ToDo(var description: String, var dueDate: String, val createdAt: String, var completed: Boolean){}