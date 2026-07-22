package com.example.learnjetpackcompose


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnjetpackcompose.Screen.Screens
import com.example.learnjetpackcompose.ui.theme.GreenJc
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import com.example.learnjetpackcompose.ui.theme.Post

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnJetpackComposeTheme {
                Surface {
                    MyBottomAppBar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar()
{
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    val navigationController = rememberNavController()
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }


    Scaffold(
        bottomBar = {
         BottomAppBar(
             containerColor = GreenJc
         ) {

             IconButton(onClick = {selected.value = Icons.Default.Home
             navigationController.navigate(Screens.Home.text)
             },
                 modifier = Modifier.weight(1f)) {
                 Icon(Icons.Default.Home,null,
                     tint = if (selected.value== Icons.Default.Home)Color.White else Color.DarkGray)
             }


             IconButton(onClick = {selected.value = Icons.Default.Search
                 navigationController.navigate(Screens.Search.text)
             },
                 modifier = Modifier.weight(1f)) {
                 Icon(Icons.Default.Search,null,
                     tint = if (selected.value ==Icons.Default.Search) Color.White else Color.DarkGray)
             }

             FloatingActionButton(
                 onClick = {
                   showBottomSheet = true//for bottom sheet
                 },
                 modifier = Modifier.weight(1f),
                 containerColor = Color.White,
                 contentColor = Color.DarkGray) {
                 Icon(Icons.Default.Add,null)
             }

             IconButton(onClick = {selected.value = Icons.Default.Email
             navigationController.navigate(Screens.Message.text)},
                 modifier = Modifier.weight(1f)) {
                 Icon(Icons.Default.Email,null,
                     tint = if (selected.value== Icons.Default.Email)Color.White else Color.DarkGray)
             }

             IconButton(onClick = {selected.value = Icons.Default.Info
                 navigationController.navigate(Screens.Info.text)
                                  },
                 modifier = Modifier.weight(1f)) {
                 Icon(Icons.Default.Info,null,
                     tint = if (selected.value== Icons.Default.Info)Color.White else Color.DarkGray)
             }

         }
        }
    ) {paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
        {

            NavHost(
                navController = navigationController, startDestination = Screens.Home.text
            ){
                composable(Screens.Home.text){Home()}
                composable(Screens.Message.text){Message()}
                composable(Screens.Search.text){Search()}
                composable(Screens.Info.text){Info()}
                composable(Screens.Post.text){ Post()}
                composable(Screens.Star.text){Star()}

            }
        }
    }
    //Adding bottom sheet logic
    if (showBottomSheet)
    {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
         ShowBottomSheet(Icons.Default.ThumbUp,"Post ") {
             showBottomSheet = false
             navigationController.navigate(Screens.Post.text){
                 popUpTo(0)
             }
         }

           ShowBottomSheet(Icons.Default.Star,"Rate now") {
               showBottomSheet = false
               navigationController.navigate(Screens.Star.text)
           }
            ShowBottomSheet(Icons.Default.ThumbUp,"Post ") {
             showBottomSheet = false
             navigationController.navigate(Screens.Post.text){
                 popUpTo(0)
             }
         }

           ShowBottomSheet(Icons.Default.Star,"Rate now") {
               showBottomSheet = false
               navigationController.navigate(Screens.Star.text)
           }
            ShowBottomSheet(Icons.Default.ThumbUp,"Post ") {
             showBottomSheet = false
             navigationController.navigate(Screens.Post.text){
                 popUpTo(0)
             }
         }

           ShowBottomSheet(Icons.Default.Star,"Rate now") {
               showBottomSheet = false
               navigationController.navigate(Screens.Star.text)
           }


        }
    }
}

@Composable
fun ShowBottomSheet(image: ImageVector,title: String,onClick:() -> Unit)
{
    Row(modifier = Modifier.fillMaxWidth().clickable{onClick()}
        .padding(vertical = 12.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically)
    {
        Icon(image,null, tint = GreenJc)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title, fontSize = 15.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnJetpackComposeTheme {
        MyBottomAppBar()
    }
}