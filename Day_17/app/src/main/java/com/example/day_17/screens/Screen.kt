package com.example.day_17.screens

const val KEY_NAME = "name"

sealed class Screen(
    val route: String
) {

    object Home: Screen(route = "home_screen")

    //  pass the name - "optional argument"
    object Details: Screen(route = "details_screen?$KEY_NAME={$KEY_NAME}") {

        fun passName(name: String): String {
            return "details_screen?$KEY_NAME=$name"
        }
    }
}
