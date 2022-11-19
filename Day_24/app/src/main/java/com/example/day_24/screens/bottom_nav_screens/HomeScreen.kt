package com.example.day_24.screens.bottom_nav_screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //  discount card
        DiscountCard()
    }
}

@Composable
fun DiscountCard() {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        //  holder
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            //  the background color
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF2e303d).copy(alpha = 0.8f))
            )

            //  content
            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                //  text content
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Get Special Discount",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFfafafa)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Up To 85%",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFffffff)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = {
                        Toast.makeText(context, "Voucher Claimed", Toast.LENGTH_SHORT).show()
                    }) {

                        Text(text = "claim voucher")
                    }

                }

                //  the image
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = com.example.day_24.R.drawable.image_removebg_preview),
                        contentDescription = "Food image"
                    )
                }

            }

        }

    }

}

@Preview
@Composable
fun DiscountCardPreview() {
    DiscountCard()
}

@Preview(
    name = "Home",
    device = Devices.DEFAULT
)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}