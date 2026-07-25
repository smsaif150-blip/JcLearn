package com.example.learnjetpackcompose.Function

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayAlphabet(Alphabet: List<String>)
{
//    Column(modifier = Modifier.padding(20.dp)){
//        Alphabet.forEach {
//            Text(it, color = Color.Red, fontSize = 30.sp)
//        }//এই পদ্ধতির নাম হলো লিস্ট। এর সমস্যা হলো এটি স্ক্রল করা যায় না। স্ক্রিনের নিচের কিছু দেখা যায়না।
//    }

//    LazyColumn(modifier = Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
//        items(Alphabet)
//        {
//            Text(it,color = Color.Red, fontSize = 30.sp)
//        }
//    }// এটি হলো রিসাইক্লার ভিউ এর মতো। স্ক্রল করা যায়। এটাই প্রেফারেবল


    LazyRow(modifier = Modifier.fillMaxSize().padding(20.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        items(Alphabet){
            Text(it+" ",color = Color.Red, fontSize = 30.sp)
        }
    }
}