package com.example.day__10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day__10.ui.theme.Day__10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            androidx.compose.material3.Surface(
                color = Color(0xFF101010),
                modifier = Modifier
                    .fillMaxSize()
            ) {
                
                DropDown(
                    text = "Hello Jetpack",
                    modifier = Modifier.padding(16.dp)
                ) {

                    //  our content
                    Text(
                        text = "Boom!, Here I am!",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color.Cyan)
                    )
                    
                }

            }
        }
    }
}

@Composable
fun DropDown(
    text: String,
    modifier: Modifier = Modifier,
    initiallyOpened: Boolean = false,
    content: @Composable () -> Unit
) {

    var isOpen by remember {
        mutableStateOf(initiallyOpened)
    }

    val alpha = animateFloatAsState(
        targetValue = if (isOpen) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

    val rotateX = animateFloatAsState(
        targetValue = if (isOpen) 0f else -90f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

    Column(
        modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = text,
                color = Color.White,
                fontSize = 16.sp
            )
            
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Open or close dropdown",
                tint = Color.White,
                modifier = Modifier
                    .clickable {
                        isOpen = !isOpen
                        //  Use scale to toggle up and down arrows
                    }
                    .scale(1f, if (isOpen) -1f else 1f)
            )

        }
        
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    //  Allows us to do any kind of 3d animations
                    transformOrigin = TransformOrigin(0.5f, 0f)
                    rotationX = rotateX.value
                },
            contentAlignment = Alignment.Center
        ) {
            content()
        }

    }
}