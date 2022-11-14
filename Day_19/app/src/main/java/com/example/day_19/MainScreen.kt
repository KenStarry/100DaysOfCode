package com.example.day_19

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day_19.ui.theme.Day_19Theme

@Composable
fun MainScreen() {

    var darkThemeState by remember {
        mutableStateOf(false)
    }

    var darkThemeText by remember {
        mutableStateOf("Go Dark")
    }

    Day_19Theme(darkTheme = darkThemeState) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = Modifier
                    .size(250.dp),
                painter = painterResource(id = R.drawable.undraw_pancakes_238t),
                contentDescription = "svg image"
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Light Mode",
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.Black.copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                //  change dark theme state
                darkThemeState = !darkThemeState

                if (darkThemeState)
                    darkThemeText = "Go Light"
                else
                    darkThemeText = "Go Dark"

            }) {
                Text(text = darkThemeText)
            }
        }

    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}