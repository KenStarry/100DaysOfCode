package com.example.day3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day3.ui.theme.Day3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF212121))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFF008CFF),
                                fontWeight = FontWeight.Bold,
                                fontSize = 48.sp
                            )
                        ) {
                            append("F")
                        }
                        append("oody")
                    },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = Color.White
                )
                
                Spacer(modifier = Modifier.height(50.dp))

                HotelMenuCard(
                    title = "Fish Curry",
                    painter = painterResource(id = R.drawable.food1))

                Spacer(modifier = Modifier.height(50.dp))

                HotelMenuCard(
                    title = "Chicken",
                    painter = painterResource(id = R.drawable.food2))

                Spacer(modifier = Modifier.height(50.dp))

                //  Button
                Button(onClick = {

                    Toast.makeText(this@MainActivity, "Food ordered", Toast.LENGTH_SHORT).show()

                }) {

                    Text(
                        text = "Order Now"
                    )
                }
            }

        }
    }
}

@Composable
fun HotelMenuCard(

    title: String,
    painter: Painter,

    ) {

    Surface(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF212121))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painter,
                contentDescription = title,
                modifier = Modifier
                    .size(100.dp),
                contentScale = ContentScale.FillWidth
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = title,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }

    }

}











