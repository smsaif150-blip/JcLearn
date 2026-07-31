package com.example.learnjetpackcompose.DrawingApp


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
data class MyDrawPath(
    val path: Path,
    val color: Color
)
@Composable
fun MyDrawerScreen() {

    var MycurrentPath by remember {
        mutableStateOf(Path())
    }

    val Mypaths = remember {
        mutableStateListOf<MyDrawPath>()
    }
    var MyselectedColor by remember {
        mutableStateOf(Color.Black)
    }
    var MyRedraw by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.White))
        {
            Canvas(modifier = Modifier.fillMaxSize()
                .pointerInput(Unit){
                    detectDragGestures(
                        onDragStart ={offset->
                            MycurrentPath = Path()
                            MycurrentPath.moveTo(offset.x,offset.y)

                            Mypaths.add(
                                MyDrawPath(
                                    MycurrentPath,
                                    MyselectedColor
                                )
                            )
                        },
                        onDrag = {change,_->
                            MycurrentPath.lineTo(
                                change.position.x,
                                change.position.y
                            )
                            MyRedraw++
                        }
                    )
                }
            )
            {
                MyRedraw
                Mypaths.forEach {
                    drawPath(
                        path =it.path ,
                        color = it.color,
                        style = Stroke(width = 12f)
                    )
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {

            showColors(Color.Red) {
                MyselectedColor = Color.Red
            }
            showColors(Color.Green) {
                MyselectedColor = Color.Green
            }
            showColors(Color.Blue) {
                MyselectedColor = Color.Blue
            }
            showColors(Color.Black) {
                MyselectedColor = Color.Black
            }
        }

        Button(onClick = {Mypaths.clear()}, modifier = Modifier.fillMaxWidth().padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)) { }
    }
}

@Composable
fun showColors(color: Color,onClick:()-> Unit)
{
    Surface(modifier = Modifier.size(50.dp),
        shape = RoundedCornerShape(16.dp),
        color = color,
        onClick = onClick
        ) {

    }
}



@Preview(showBackground = true)
@Composable
fun ShowColors()
{
    LearnJetpackComposeTheme {
        MyDrawerScreen()
    }
}