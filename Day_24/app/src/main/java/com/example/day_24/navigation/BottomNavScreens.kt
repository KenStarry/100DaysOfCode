package com.example.day_24.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.day_24.R

sealed class BottomNavScreens(
    val route: String,
    val icon: ImageVector,
    val title: String
) {

    //  Home Screen
    object Home : BottomNavScreens(
        route = "home_screen",
        icon = Icons.Outlined.Home,
        title = "Home"
    )

    //  Orders Screen
    object Orders : BottomNavScreens(
        route = "orders_screen",
        icon = Icons.Outlined.ShoppingCart,
        title = "Orders"
    )

    //  Wallet Screen
    object Wallet : BottomNavScreens(
        route = "wallet_screen",
        icon = Icons.Outlined.AccountBox,
        title = "Wallet"
    )

    //  Profile Screen
    object Profile : BottomNavScreens(
        route = "profile_screen",
        icon = Icons.Outlined.ShoppingCart,
        title = "Profile"
    )

}

















































