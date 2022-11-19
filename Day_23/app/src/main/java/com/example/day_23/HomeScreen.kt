package com.example.day_23

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    //  use a state to be able to call our composable functions
    var isDialogOpen by remember {
        mutableStateOf(false)
    }

    if (isDialogOpen)
        ShowDialog()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isDialogOpen = true
                },
                interactionSource = remember { MutableInteractionSource() },
                shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.surfaceTint,
                elevation = FloatingActionButtonDefaults.elevation(),
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "FAB Add"
                )
            }
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
                text = "FAB",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFF303030)
            )

        }
    }
}

@Composable
fun ShowDialog() {

    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = {
            Text(text = "FAB Button")
        },
        text = {
            Text(text = "A FAB Button was clicked!")
        },
        confirmButton = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Ok")
            }
        },
        dismissButton = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Cancel")
            }
        }
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}