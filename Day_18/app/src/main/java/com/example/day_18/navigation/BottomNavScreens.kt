package com.example.day_18.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    //  Home Screen
    object Home: BottomNavScreens(
        route = "home_screen",
        title = "Home",
        icon = Icons.Filled.Home
    )

    //  Cards Screen
    object Cards: BottomNavScreens(
        route = "cards_screen",
        title = "Cards",
        icon = Icons.Filled.PlayArrow
    )

    //  Track Screen
    object Track: BottomNavScreens(
        route = "track_screen",
        title = "Track",
        icon = Icons.Filled.LocationOn
    )

    //  Track Screen
    object Settings: BottomNavScreens(
        route = "settings_screen",
        title = "Settings",
        icon = Icons.Filled.Settings
    )

}
