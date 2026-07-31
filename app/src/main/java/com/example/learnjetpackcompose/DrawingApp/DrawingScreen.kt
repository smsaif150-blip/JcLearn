package com.example.learnjetpackcompose.DrawingApp

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

data class DrawPath(
    val path: Path,
    val color: Color
)

@Composable
fun DrawingScreen() {
    var redraw by remember {
        mutableStateOf(0)
    }
    var selectedColor by remember {
        mutableStateOf(Color.Black)
    }

    val paths = remember {
        mutableStateListOf<DrawPath>()
    }

    var currentPath by remember {
        mutableStateOf(Path())
    }

    val context = LocalContext.current.applicationContext

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.White)
        ) {
           // Text(text = "Paths = ${paths.size}")
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {//pointerInput = Touch Listener
                        // Unit = Restart করার মতো কোনো Key নেই
                        //যদিি এটি দিই তাহলে  pointerInput(color) = color বদলালে Listener আবার তৈরি হবে

                        detectDragGestures( //detectDragGestures = আঙুল টেনে (Drag) নড়ানোর Event ধরার Function।

                            onDragStart = { offset -> //// আঙুল প্রথম স্ক্রিনে লাগল

                                currentPath = Path()//নতুন একটা Drawing রেডি করা হচ্ছে।
                                currentPath.moveTo(offset.x, offset.y)//পেন্সিলকে এক জায়গা থেকে আরেক জায়গায় নেয়া হচ্ছে

                                paths.add(
                                    DrawPath(
                                        currentPath,
                                        selectedColor
                                    )
                                )
                            },

                            onDrag = { change, _ ->// আঙুল টানা হচ্ছে

                                currentPath.lineTo(
                                    change.position.x,
                                    change.position.y
                                )
                               redraw++
                            }
                        )
                    }
            ) {
                redraw
                paths.forEach {
                    drawPath(
                        path = it.path,
                        color = it.color,
                        style = Stroke(
                            width = 12f
                        )
                    )
                }

            }

        }

        HorizontalDivider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            ColorItem(Color.Red) {
                selectedColor = Color.Red
                Toast.makeText(context,"RED is selected", Toast.LENGTH_SHORT).show()
            }

            ColorItem(Color.Green) {
                selectedColor = Color.Green
                Toast.makeText(context,"GREEN is selected", Toast.LENGTH_SHORT).show()
            }

            ColorItem(Color.Blue) {
                selectedColor = Color.Blue
                Toast.makeText(context,"BLUE is selected", Toast.LENGTH_SHORT).show()
            }

            ColorItem(Color.Black) {
                selectedColor = Color.Black
                Toast.makeText(context,"BLACK is selected", Toast.LENGTH_SHORT).show()
            }
        }

        Button(
            onClick = {

                paths.clear()

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )

        ) {

            Text("Clear")

        }

    }

}

@Composable
fun ColorItem(
    color: Color,
    onClick: () -> Unit
) {

    Surface(
        modifier = Modifier
            .size(50.dp),
        shape = CircleShape,
        color = color,
        onClick = onClick
    ) {

    }

}

@Preview(showBackground = true)
@Composable
fun showDrawing()
{
    LearnJetpackComposeTheme {
        DrawingScreen()
    }
}