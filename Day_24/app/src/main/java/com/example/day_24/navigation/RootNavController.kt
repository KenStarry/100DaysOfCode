package com.example.day_24.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.day_24.screens.DetailScreen
import com.example.day_24.screens.MainScreen
import com.example.day_24.screens.bottom_nav_screens.HomeScreen
import com.example.day_24.screens.bottom_nav_screens.OrdersScreen
import com.example.day_24.screens.bottom_nav_screens.ProfileScreen
import com.example.day_24.screens.bottom_nav_screens.WalletScreen

@Composable
fun RootNavController(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = BottomNavScreens.Home.route
    ) {

        //  Home screen composable
        composable(route = BottomNavScreens.Home.route) {
            HomeScreen(navHostController)
        }

        //  Home screen composable
        composable(route = BottomNavScreens.Orders.route) {
            OrdersScreen()
        }

        //  Home screen composable
        composable(route = BottomNavScreens.Wallet.route) {
            WalletScreen()
        }

        //  Home screen composable
        composable(route = BottomNavScreens.Profile.route) {
            ProfileScreen()
        }

        //  Home screen composable
        composable(route = Screens.DetailScreen.route) {
            DetailScreen()
        }

        composable(route = Screens.MainScreen.route) {
            MainScreen()
        }
    }

}



























