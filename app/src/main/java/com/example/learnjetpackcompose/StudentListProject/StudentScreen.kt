package com.example.learnjetpackcompose.StudentListProject

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun StudentScreen()
{
    val students = listOf(
        StudentModel("Shawal Mahmud Saif",101,"saif@gmail.com"),
        StudentModel("Hasan Mahmud sifat",102,"sifat@gmail.com"),
        StudentModel("Imrul Hasan",103,"imrul@gmail.com")
    )

    LazyColumn {
        items(students){ student->
            StudentItem(student)
        }
    }
}