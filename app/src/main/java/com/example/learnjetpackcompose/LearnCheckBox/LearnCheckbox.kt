package com.example.learnjetpackcompose.LearnCheckBox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import java.util.zip.Checksum

@Composable
fun LearnCheckBox()
{
    var Kotlinchecked by remember {
        mutableStateOf(false)
    }
    var JavaChecked by remember{
        mutableStateOf(false)
    }
    var JetpackChecked by remember{
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start) {

        AllChecks(Kotlinchecked,"Kotlin") {
            Kotlinchecked = it
        }
        AllChecks(JavaChecked,"Java") {
            JavaChecked = it
        }

//        Checkbox(
//            checked = JetpackChecked,
//            onCheckedChange = {
//                JetpackChecked = it
//            }
//        )
//        Text("Jetpack Compose")
    }

    }



@Preview(showBackground = true)
@Composable
fun showPreview()
{
    LearnJetpackComposeTheme {
        LearnCheckBox()
    }
}