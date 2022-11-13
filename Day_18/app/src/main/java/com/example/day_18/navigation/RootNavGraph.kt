package com.example.day_18.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.day_18.screens.main_screens.CardsScreen
import com.example.day_18.screens.main_screens.HomeScreen
import com.example.day_18.screens.main_screens.SettingsScreen
import com.example.day_18.screens.main_screens.TrackScreen

@Composable
fun RootNavGraph(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = BottomNavScreens.Home.route
    ) {

        composable(route = BottomNavScreens.Home.route) {
            HomeScreen(padding)
        }

        composable(route = BottomNavScreens.Cards.route) {
            CardsScreen()
        }

        composable(route = BottomNavScreens.Track.route) {
            TrackScreen()
        }

        composable(route = BottomNavScreens.Settings.route) {
            SettingsScreen()
        }
    }

}