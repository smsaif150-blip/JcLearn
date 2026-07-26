package com.example.learnjetpackcompose.NavigationComponent

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyNavigation(navController: NavController)
{
    NavHost(navController = navController as NavHostController, startDestination = Destinations.MainScreen.router) {
        composable(Destinations.MainScreen.router){
            MainScreens(navController)
        }
        composable(Destinations.HomeScreen.router)
        {
            HomeScreen(navController)
        }
    }
}