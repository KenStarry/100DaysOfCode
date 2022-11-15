package com.example.day_20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.day_20.ui.theme.BtnCol1
import com.example.day_20.ui.theme.BtnCol2
import com.example.day_20.ui.theme.Day_20Theme

//  Gradient button
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day_20Theme {

                Box(
                    modifier = Modifier
                        .background(Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFFC5C7D),
                                Color(0xFF6A82FB)
                            )
                        ))
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    GradientButton(
                        text = "Gradient",
                        textColor = Color.White,
                        gradient = Brush.horizontalGradient(
                            colors = listOf(
                                BtnCol1, BtnCol2
                            )
                        )
                    ) {

                    }
                }
            }
        }
    }
}