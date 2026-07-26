package com.example.learnjetpackcompose.Function

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun LearnConstrains()
{
    ConstraintLayout(modifier = Modifier.fillMaxSize()){//ConstraintLayout টাকে পুরো স্ক্রিনে ছড়িয়ে দেয়া হয়েছে
        val (RedButton,BlueButton,GreenButton,BlackButton) = createRefs()//চারটি বাটনের মধ্যে সংযোগ স্থাপনের জন্য এই লাইনটি লিখা হয়েছে

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Red), modifier = Modifier.constrainAs(RedButton){// এই বাটনটির নাম করণ করা হলো RedButton
            top.linkTo(parent.top,margin = 16.dp)//
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }) {
            Text(text = "Red Button")
        }

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Blue), modifier = Modifier.constrainAs(BlueButton){
            top.linkTo(RedButton.bottom)
        }) {
            Text(text = "Blue Button")
        }

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Black), modifier = Modifier.constrainAs(BlackButton){
            top.linkTo(RedButton.bottom)// ব্লু বাটন এবং ব্লেক বাটন দুটিকেই রেড বাটনের নিচে রাখা হলো। কিন্তু তারা ওভার লেপড হয়ে গেছে।
        }) {
            Text(text = "Black Button")
        }

        createHorizontalChain(BlueButton,BlackButton, chainStyle = ChainStyle.Spread)// ব্লু বাটন এবং ব্লেক বাটন দুটি ওভার লেপড হওয়ায় চেইন ইউজ করা হয়েছে
        val Guideline = createGuidelineFromBottom(0.1f)//নিচের দিকে ১০% গাইডলাইন ইউজ করা হয়েছে।

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Green), modifier = Modifier.constrainAs(GreenButton){
            bottom.linkTo(Guideline)// বাটনটিকে নিচে রাখা হয়েছে
        }) {
            Text(text = "Green Button")
        }
    }
}


