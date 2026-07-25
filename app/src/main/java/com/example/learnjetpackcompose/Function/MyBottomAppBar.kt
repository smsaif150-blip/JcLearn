package com.example.learnjetpackcompose.Function

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.learnjetpackcompose.Home
import com.example.learnjetpackcompose.Message
import com.example.learnjetpackcompose.Screen.Screens
import com.example.learnjetpackcompose.Search
//import com.example.learnjetpackcompose.ShowBottomSheet
import com.example.learnjetpackcompose.Star
import com.example.learnjetpackcompose.ui.theme.GreenJc
import com.example.learnjetpackcompose.ui.theme.Post
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar(navController: NavController)
{
    val drawerState =rememberDrawerState(initialValue = DrawerValue.Closed)
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
                NavHost(navController= navController as NavHostController,
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
