package com.example.day_21.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.day_21.AnimatedSplashScreen
import com.example.day_21.Screens

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Home.route) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Home Screen",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        composable(route = Screens.Splash.route) {
            AnimatedSplashScreen(navController = navHostController)
        }
    }
}














