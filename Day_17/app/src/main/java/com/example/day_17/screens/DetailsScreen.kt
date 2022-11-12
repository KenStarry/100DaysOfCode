package com.example.day_17.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navController: NavController,
    sentText: String = "No username"
) {

    Scaffold(
        topBar = {
            MyTopBar(
                onNavigationIconClicked = {
                    navController.navigate(route = Screen.Home.route) {
                        popUpTo(route = Screen.Home.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    ) { contentPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Details Page",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(100.dp))

            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate(route = Screen.Home.route) {
                            popUpTo(route = Screen.Home.route) {
                                inclusive = true
                            }
                        }
                    },
                text = "Hello there, $sentText",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary
            )

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    onNavigationIconClicked: () -> Unit
) {

    TopAppBar(
        title = {
            Text(text = "Details")
        },
        navigationIcon = {
            IconButton(onClick = {
                //  go back to home page
                onNavigationIconClicked()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back Arrow"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.MailOutline,
                    contentDescription = "Mail"
                )
            }
        }
    )
}

@Preview(
    name = "Details Preview",
    showSystemUi = true
)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(navController = rememberNavController(), "Starry")
}