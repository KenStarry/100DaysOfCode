package com.example.day_17.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {

        //  Home Screen
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navHostController)
        }

        //  Details Screen
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(KEY_NAME) {
                    type = NavType.StringType
                    defaultValue = "Starry"
                }
            )
        ) {
            //  get the argument and pass it on to Details Screen
            DetailsScreen(navController = navHostController, it.arguments?.getString(KEY_NAME).toString())
        }

    }

}