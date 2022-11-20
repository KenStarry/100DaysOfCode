package com.example.day_24.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.day_24.navigation.BottomNavScreens
import com.example.day_24.navigation.RootNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
) {

    //  add bottom nav navigation
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopBar(navHostController = navController) },
        bottomBar = { BottomBar(navHostController = navController) }
    ) { contentPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {

            RootNavController(navHostController = navController)
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}


//  top app bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navHostController: NavHostController
) {

    //  the screens taht will make our top App Bar show
    val screens = listOf(
        BottomNavScreens.Home,
        BottomNavScreens.Orders,
        BottomNavScreens.Wallet,
        BottomNavScreens.Profile
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val validDestinations = screens.any {
        //  if any of the screens matches
        it.route == currentDestination?.route
    }

    if (validDestinations) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Home",
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Menu,
                        contentDescription = "Menu Icon"
                    )
                }
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Notification Icon"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    }
}


//  Bottom App Bar
@Composable
fun BottomBar(
    navHostController: NavHostController
) {

    val screens = listOf(
        BottomNavScreens.Home,
        BottomNavScreens.Orders,
        BottomNavScreens.Wallet,
        BottomNavScreens.Profile,
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ) {
            screens.forEach { screen ->

                //  create a navigation bar item
                NavBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navHostController = navHostController
                )
            }
        }
    }
}

@Composable
fun RowScope.NavBarItem(
    screen: BottomNavScreens,
    currentDestination: NavDestination?,
    navHostController: NavHostController,
) {

    NavigationBarItem(
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Nav Icon"
            )
        },

        onClick = {
            //    navigate to the selected screen
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },

        label = {
            Text(text = screen.title)
        }
    )

}
































