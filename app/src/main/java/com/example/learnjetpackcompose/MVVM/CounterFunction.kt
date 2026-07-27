package com.example.learnjetpackcompose.MVVM

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterFunction(counterViewModel: CounterViewModel = viewModel()){ //fun add(a: Int = 10) {println(a)} //function call {add()}// output // 10

    Column {
        Button(onClick = {counterViewModel.increaseCount()}) {
            Text("Click me")
        }
        Text("${counterViewModel.counter}")
    }

}