package com.example.learnjetpackcompose.FloatingActionBar

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnjetpackcompose.ui.theme.GreenJc

@Composable
fun PracticeFloatingActionbar()
{
    Box(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current.applicationContext
        FloatingActionButton(modifier = Modifier.padding(16.dp).align(Alignment.BottomEnd),
            containerColor = GreenJc,onClick = { Toast.makeText(context,"FAB", Toast.LENGTH_SHORT).show()})
        {
            Icon(Icons.Default.Add,null)
        }
    }
}

@Composable
fun PracticeExtendFloatingActionbar()
{
    val context = LocalContext.current.applicationContext
    Box(modifier = Modifier.fillMaxSize())
    {
        ExtendedFloatingActionButton(modifier = Modifier.padding(16.dp).align(alignment = Alignment.BottomEnd)
        , onClick = {Toast.makeText(context,"Extended Floating Actionbar ", Toast.LENGTH_SHORT).show()}, containerColor = GreenJc) {
            Icon(Icons.Default.Menu,null)
            Text("Click Menu")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowFAB()
{
    PracticeExtendFloatingActionbar()
}