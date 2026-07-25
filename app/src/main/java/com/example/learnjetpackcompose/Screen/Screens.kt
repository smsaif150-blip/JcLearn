package com.example.learnjetpackcompose.Screen

sealed class Screens(var text: String)
{
    object Home: Screens("home")
    object Search: Screens("search")
    object Message: Screens("message")
    object Info: Screens("info")
    object Post: Screens("post")
    object Star: Screens("star")
    object Login: Screens("login")
}
