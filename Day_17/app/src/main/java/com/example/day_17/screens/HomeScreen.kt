package com.example.day_17.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {

    var userInput by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            placeholder = {
                Text(text = "e.g. john Doe")
            },
            label = {
                Text(text = "Name")
            },
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Name icon",
                        tint = Color(0xFF323232)
                    )
                }
            },
            trailingIcon = {
                if (userInput.isNotBlank()){
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Name icon",
                            tint = Color(0xFF323232)
                        )
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    //  navigate to the next page
                }
            )
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(onClick = {

            navController.navigate(route = Screen.Details.passName(userInput))

        }) {
            Text(text = "Send Data")
        }

    }

}

@Preview(
    name = "Home Screen",
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}