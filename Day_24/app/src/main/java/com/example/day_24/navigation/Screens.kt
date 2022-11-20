package com.example.day_24.navigation

//  other screens
sealed class Screens(
    val route: String
) {
    object DetailScreen : Screens(route = "detail_screen")
    object MainScreen : Screens(route = "main_screen")
}
