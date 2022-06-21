package com.example.homework5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyData(val name: String, val age: Int): Parcelable