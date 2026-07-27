package com.example.learnjetpackcompose.MVVM

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    var counter by mutableStateOf(0)

    fun increaseCount()
    {
        counter++
    }
}