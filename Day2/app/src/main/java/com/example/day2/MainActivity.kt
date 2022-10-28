package com.example.day2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day2.ui.theme.Day2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val painter = painterResource(id = R.drawable.img)
            val title = "Porsche"
            val header = "Jetpack Image Composables"

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = header,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold
                        ),

                    )

                    ImageCard(
                        painter = painter,
                        title = title
                    )
                }

            }

        }
    }
}

@Composable
fun ImageCard(

    painter: Painter,
    title: String,
    modifier: Modifier = Modifier
) {

    //  Our card surface layout
    Surface(
        modifier = modifier.fillMaxWidth(0.9f),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp
    ) {

        //  Box to hold our items
        Box(
            modifier = Modifier.height(300.dp),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {

                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }

            //  Our image
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = title
            )
        }

    }

}









