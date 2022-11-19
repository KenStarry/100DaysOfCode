package com.example.day_21

sealed class Screens(
    val route: String
) {

    object Home: Screens(route = "home_screen")
    object Splash: Screens(route = "splash_screen")

}
