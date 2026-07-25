package com.example.learnjetpackcompose



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnjetpackcompose.Function.LoginPage
import com.example.learnjetpackcompose.Screen.Screens
import com.example.learnjetpackcompose.ui.theme.GreenJc
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import com.example.learnjetpackcompose.ui.theme.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnJetpackComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screens.Login.text) {

                    composable(Screens.Login.text){
                        LoginPage(navController)
                    }
                    composable(Screens.Home.text)
                    {
                        Home()
                    }

                }


            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar()
{
    val drawerState =rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val selectedIcon = remember {
        mutableStateOf(Icons.Default.Home)
    }
    var BottomSheet by remember {
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(modifier = Modifier
                    .background(GreenJc)
                    .fillMaxWidth()
                    .height(150.dp))
                Divider()
                NavigationDrawerItem(
                    label = {Text(text = "Star")},
                    selected = false,
                    onClick = {
                        selectedIcon.value = Icons.Default.Star
                        navController.navigate(Screens.Star.text)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = { Icon(Icons.Default.Star,null, tint = GreenJc) }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {Text(text = "Whatsapp")},
                    navigationIcon = {
                        IconButton(onClick =
                            {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(Icons.Default.Menu,null)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = GreenJc,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    )
                )
            },

            bottomBar = {
                BottomAppBar(containerColor = GreenJc) {
                    IconButton(onClick = {selectedIcon.value = Icons.Default.Home
                        navController.navigate(Screens.Home.text)
                    }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.Home,null, tint =
                                if (selectedIcon.value == Icons.Default.Home)
                                    Color.White
                                else
                                    Color.DarkGray
                        )
                    }

                    FloatingActionButton(onClick =
                        {
                            selectedIcon.value = Icons.Default.ThumbUp
                            BottomSheet = true
                        },
                        modifier = Modifier.weight(1f),
                        contentColor = Color.DarkGray,
                        content = { Icon(Icons.Default.Add, null) },
                        containerColor = Color.White
                    )

                    IconButton(onClick = {
                        selectedIcon.value = Icons.Default.Search
                        navController.navigate(Screens.Search.text)
                    }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.Search,null, tint =
                        if (selectedIcon.value== Icons.Default.Search)
                            Color.White
                            else
                            Color.DarkGray
                        )
                    }
                }
            }

        ) {paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
            {
                NavHost(navController=navController,
                    startDestination = Screens.Home.text) {
                    composable(Screens.Home.text){Home()}
                    composable(Screens.Message.text){Message()}
                    composable(Screens.Search.text){Search()}
                    composable(Screens.Star.text){Star()}
                    composable(Screens.Post.text){Post()}
                }
            }
        }

    }

    if (BottomSheet)
    {
        ModalBottomSheet(
            onDismissRequest = {
                BottomSheet = false
            },
            sheetState = sheetState
        ) {
            ShowBottomSheet(Icons.Default.ThumbUp,"Post"){
                BottomSheet = false
                navController.navigate(Screens.Post.text)
            }
        }
    }
}

@Composable
fun ShowBottomSheet(icon: ImageVector, title: String, onClick: () -> Unit) {
    Row(modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp).fillMaxWidth().clickable{onClick()})
    {
        Icon(icon,null, tint = GreenJc)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnJetpackComposeTheme {
       //
    }
}