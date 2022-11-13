package com.example.day_18.screens.main_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.day_18.navigation.BottomNavScreens
import com.example.day_18.navigation.RootNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    //  we can host our bottom navigation bar here
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { NavBar(navHostController = navController) }
    ) { contentPadding ->

        Box(modifier = Modifier.padding(contentPadding)) {
            //  call our graph
            RootNavGraph(navController = navController, contentPadding)
        }
    }
}

@Composable
fun NavBar(
    navHostController: NavHostController
) {

    //  all our screens
    val screens = listOf(
        BottomNavScreens.Home,
        BottomNavScreens.Cards,
        BottomNavScreens.Track,
        BottomNavScreens.Settings
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen ->
            NavItem(
                screen = screen,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }
}

@Composable
fun RowScope.NavItem(
    screen: BottomNavScreens,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {

    NavigationBarItem(

        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                //  avoid screen duplicates
                launchSingleTop = true
            }
        },

        label = {
            Text(text = screen.title)
        },

        alwaysShowLabel = true,

        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navbar Icon"
            )
        },
    )
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}















