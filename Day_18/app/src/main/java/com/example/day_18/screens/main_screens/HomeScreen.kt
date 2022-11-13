package com.example.day_18.screens.main_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day_18.R
import com.example.day_18.models.CarModel

@Composable
fun HomeScreen(
    padding: PaddingValues
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFefefef))
            .padding(16.dp),
    ) {

        TopBarCard()

        Spacer(modifier = Modifier.height(16.dp))
        CategoryToggles()

        Spacer(modifier = Modifier.height(16.dp))
        CarCardsLazyList()

        Spacer(modifier = Modifier.height(64.dp))
    }
}


//  top bar card
@Composable
fun TopBarCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            //  user text
            Column(
                modifier = Modifier
                    .weight(8f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Lilian Smith",
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Text(
                    text = "Personal Discount Available",
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black.copy(alpha = 0.7f)
                )
            }

            //  User Image
            Box(
                modifier = Modifier
                    .weight(2f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    painter = painterResource(id = com.example.day_18.R.drawable.lady1),
                    contentDescription = "Lady",
                    contentScale = ContentScale.Crop
                )
            }
        }

    }
}

//  top bar card preview
@Preview
@Composable
fun TopBarCardPreview() {
    TopBarCard()
}

//  categories lazylist
@Composable
fun CategoryToggles() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        //  our lazy row
        LazyRow(
            modifier = Modifier
                .weight(5f),
            content = {
                itemsIndexed(
                    listOf("SUV", "Sedan", "Convertible", "Pickup", "Helicopter")

                ) { index, item ->

                    CategoryToggleItem(text = item)
                }
            },
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        //  toggle icon
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "Toggle Boards",
                        tint = Color.White
                    )
                }

            }
        }

        Spacer(modifier = Modifier.width(16.dp))

    }
}

@Composable
fun CategoryToggleItem(
    text: String
) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .background(Color(0xFFefefef))
            .border(
                width = 1.dp,
                color = Color.LightGray.copy(alpha = 0.3f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {

        Text(
            text = text,
            color = Color.Black.copy(alpha = 0.5f),
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            fontWeight = FontWeight.Normal
        )

    }
}

@Preview
@Composable
fun CategoryTogglesPreview() {
    CategoryToggles()
}

@Preview
@Composable
fun CategoryToggleItemPreview() {
    CategoryToggleItem(text = "SUV")
}

//  Car Card
@Composable
fun CarCardsLazyList() {

    val images = listOf(
        painterResource(id = R.drawable.mclaren),
        painterResource(id = R.drawable.maclaren_2),
        painterResource(id = R.drawable.porsche),
        painterResource(id = R.drawable.rolls),
    )

    LazyColumn(content = {
        itemsIndexed(
            listOf(
                CarModel(
                    images[1],
                    Color(0xFF008CFF).copy(alpha = 0.2f),
                    4.8,
                    "Mclaren p670",
                    "673hp",
                    "3.1s",
                    "$1,500/Day"
                ),
                CarModel(
                    images[2],
                    Color.Cyan.copy(alpha = 0.2f),
                    4.8,
                    "Porsche 911-Premium",
                    "573hp",
                    "2.1s",
                    "$1,300/Day"
                ),
                CarModel(
                    images[3],
                    Color.Magenta.copy(alpha = 0.2f),
                    4.8,
                    "Rolls Royce - Cullinan",
                    "773hp",
                    "1.1s",
                    "$2,300/Day"
                ),
                CarModel(
                    images[2],
                    Color.Black.copy(alpha = 0.2f),
                    4.8,
                    "Porsche 911 - Spyder",
                    "480hp",
                    "4.1s",
                    "$350/Day"
                ),
            )
        ) { index, item ->

            CarCard(item)
        }
    },
    contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    )
}

@Composable
fun CarCard(
    carModel: CarModel
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(carModel.carBackground!!)
                .padding(16.dp),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                //  rating on top
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    //  rating
                    Row(
                        modifier = Modifier
                            .weight(8f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_star_rate_24),
                            contentDescription = "Rating icon",
                            tint = Color.Yellow
                        )

                        Text(
                            modifier = Modifier
                                .padding(start = 8.dp),
                            text = carModel.carRating.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(2f),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(20.dp),
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Rating icon",
                            tint = Color.Black.copy(alpha = 0.3f)
                        )
                    }
                }

                //  Car image holder
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                ) {

                    //  Car image
                    Image(
                        modifier = Modifier
                            .fillMaxSize(),
                        painter = carModel.carImage!!,
                        contentDescription = "Car Image",
                        contentScale = ContentScale.Fit
                    )

                }


                //  car model
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    text = carModel.carModel,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black.copy(alpha = 0.8f)
                )

                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .background(Color.LightGray.copy(alpha = 0.8f))
                )

                //  car details
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    //  horsepower
                    Row(
                        modifier = Modifier
                            .weight(2f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            painter = painterResource(id = R.drawable.ic_baseline_power_24),
                            contentDescription = "Speed icon"
                        )

                        Text(
                            text = carModel.carHorsePower,
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black.copy(alpha = 0.8f)
                        )
                    }

                    //  Acceleration
                    Row(
                        modifier = Modifier
                            .weight(3f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            painter = painterResource(id = R.drawable.ic_baseline_timelapse_24),
                            contentDescription = "Speed icon"
                        )

                        Text(
                            text = carModel.carAccelerationTime,
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black.copy(alpha = 0.8f)
                        )
                    }

                    //  Price
                    Row(
                        modifier = Modifier
                            .weight(2f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            painter = painterResource(id = R.drawable.ic_baseline_attach_money_24),
                            contentDescription = "Speed icon"
                        )

                        Text(
                            text = carModel.carPrice,
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black.copy(alpha = 0.8f)
                        )
                    }

                }

            }
        }

    }

}

@Preview
@Composable
fun CarCardPreview() {
    CarCard(
        carModel = CarModel(
            painterResource(id = R.drawable.maclaren_2),
            Color.Blue.copy(alpha = 0.1f),
            4.8,
            "Porsche 911 - Spyder",
            "480hp",
            "4.1s",
            "$350/Day"
        )
    )
}

//  Home screen preview
@Preview(
    name = "Home Screen",
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(PaddingValues(16.dp))
}















