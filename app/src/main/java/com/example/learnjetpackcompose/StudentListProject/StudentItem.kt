package com.example.learnjetpackcompose.StudentListProject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcompose.ui.theme.GreenJc
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

@Composable
fun StudentItem(model: StudentModel)
{
    Column(modifier = Modifier.background(Color.White).fillMaxWidth().height(120.dp)) {
        Card(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 6.dp), colors = CardDefaults.cardColors(
            GreenJc), shape = RoundedCornerShape(20.dp)) {
            Column(modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start) {
                Text("Name: "+model.name, color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Roll: "+model.roll.toString(), color = Color.Black)
                Text("Email: "+model.email, color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowStudentList()
{
    LearnJetpackComposeTheme {
        StudentItem(StudentModel("",0,""))
    }
}