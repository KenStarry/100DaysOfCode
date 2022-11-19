package com.example.day_24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.day_24.screens.MainScreen
import com.example.day_24.ui.theme.Day_24Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day_24Theme {
                MainScreen()
            }
        }
    }
}