package com.example.learnjetpackcompose.NavigationComponent

sealed class Destinations(val router: String) {
    object MainScreen: Destinations("MainScreen")
    object HomeScreen: Destinations("HomeScreen")
}