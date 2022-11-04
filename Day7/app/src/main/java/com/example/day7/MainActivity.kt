package com.example.day7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.day7.ui.theme.Day7Theme
import kotlin.random.Random
import kotlin.random.nextInt

//  Animations in jetpack compose
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //  sizeState to hold the dp value
            var sizeState by remember {
                mutableStateOf(200.dp)
            }
            var colorState by remember {
                mutableStateOf(Color.Yellow)
            }
            //  animate our sizeState
            val size by animateDpAsState(
                targetValue = sizeState,
                //  Specify the animation details
                tween(
                    durationMillis = 1000,
                    delayMillis = 300,
                    easing = LinearEasing
                )
            )
            //  animate our colorState
            val col by animateColorAsState(
                targetValue = colorState,
                tween(
                    durationMillis = 1000,
                    delayMillis = 300,
                    easing = LinearEasing
                )
            )

            Box(
                modifier = Modifier
                    .size(size)
                    .background(col),
                contentAlignment = Alignment.Center
            ) {

                Button(onClick = {
                    // animate the box onClick
                    sizeState += 50.dp
                    colorState = Color(
                        Random.nextInt(0, 255),
                        Random.nextInt(0, 255),
                        Random.nextInt(0, 255)
                    )

                }) {

                    Text(text = "Increase Size")
                }

            }
        }
    }
}