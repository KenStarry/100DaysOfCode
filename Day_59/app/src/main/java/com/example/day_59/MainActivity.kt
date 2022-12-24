package com.example.day_59

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.day_59.ui.theme.Day_59Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day_59Theme {

                AnimateFloatAsContent()
            }
        }
    }
}

@Composable
fun AnimateFloatAsContent() {

    var isRotated by remember {
        mutableStateOf(false)
    }
    val rotationAngle by animateFloatAsState(
        targetValue = if (isRotated) 360f else 0f,
        animationSpec = tween(
            durationMillis = 1000,
            delayMillis = 100
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_wifi_protected_setup_24),
            contentDescription = "Rotator",
            modifier = Modifier
                .rotate(rotationAngle)
                .size(150.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { isRotated = !isRotated },
            modifier = Modifier
                .width(200.dp)
        ) {
            
            Text(text = "Rotate Image")

        }

    }

}




























