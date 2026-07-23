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
import androidx.compose.material.icons.filled.Menu
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
import kotlinx.coroutines.launch

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
    val navController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    val context = LocalContext.current.applicationContext
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Whats app") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GreenJc,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = {scope.launch { drawerState.open() }}) {
                        Icon(Icons.Default.Menu,null)
                    }
                }
            )
        },




        bottomBar = {
            BottomAppBar(containerColor = GreenJc) {
                IconButton(
                    onClick =
                        {
                            selected.value = Icons.Default.Home
                            navController.navigate(Screens.Home.text)
                        },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Home,
                        null,
                        tint = if (selected.value== Icons.Default.Home)Color.White
                        else Color.DarkGray)
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navController.navigate(Screens.Search.text)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Search,null,
                        tint = if (selected.value== Icons.Default.Search) Color.White else Color.DarkGray)
                }

                FloatingActionButton(
                    onClick = {
                        showBottomSheet = true
                    },
                    modifier = Modifier.weight(1f),
                    containerColor = Color.White,
                    contentColor = Color.DarkGray
                ) {
                    Icon(Icons.Default.Add,null)
                }


                IconButton(
                    onClick =
                        {
                            selected.value = Icons.Default.Email
                            navController.navigate(Screens.Message.text)
                        },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Email,null,
                        tint = if (selected.value == Icons.Default.Email)Color.White else Color.DarkGray)
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Info
                        navController.navigate(Screens.Info.text)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Info,null,
                        tint = if (selected.value == Icons.Default.Info) Color.White else Color.DarkGray)
                }
            }
        }
    )
    {innerpaddng->
        Box(modifier = Modifier.padding(innerpaddng))
        {
            NavHost(navController = navController, startDestination = Screens.Home.text)
            {
                composable(Screens.Home.text){Home()}
                composable(Screens.Search.text){Search()}
                composable(Screens.Message.text){Message()}
                composable(Screens.Info.text){Info()}
                composable(Screens.Post.text){Post()}
                composable(Screens.Star.text){Star()}
            }
        }
    }


    if (showBottomSheet)
    {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            ShowBottomSheet(Icons.Default.ThumbUp,"Post") {
                showBottomSheet = false
                navController.navigate(Screens.Post.text)
            }

            ShowBottomSheet(Icons.Default.Star,"Stars") {
                showBottomSheet = false
                navController.navigate(Screens.Star.text)
            }
        }
    }
}

@Composable
fun ShowBottomSheet(Icon: ImageVector,title: String,onClick:() -> Unit)
{
    Row(modifier = Modifier.fillMaxWidth().clickable{onClick()}
        .padding(vertical = 12.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icon,null, tint = GreenJc)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnJetpackComposeTheme {
        MyBottomAppBar()
    }
}