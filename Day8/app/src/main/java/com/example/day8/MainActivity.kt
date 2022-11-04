package com.example.mini1

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day8.FoodModel
import com.example.day8.R

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val painters = listOf(
                painterResource(id = R.drawable.ic_food),
                painterResource(id = R.drawable.ic_food),
                painterResource(id = R.drawable.ic_food)
            )
            Scaffold(
                topBar = {
                    TopAppBar(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primary),
                        title = {
                            Text(
                                text = "Foodly",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                fontStyle = FontStyle.Italic
                            )
                        }
                    )
                }
            ) { contentPadding ->

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        modifier = Modifier
                            .padding(vertical = 24.dp),
                        text = "Order Up",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF000000),
                    )

                    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp), content = {

                        itemsIndexed(

                            // add a list using the FoodModel class
                            listOf(
                                FoodModel(painters[0], "Chicken", "Ksh. 150", "Lunch"),
                                FoodModel(painters[1], "Black Forest", "Ksh. 650", "Dessert"),
                                FoodModel(painters[2], "Milkshake", "Ksh. 350", "Drink"),
                                FoodModel(painters[2], "Pilau", "Ksh. 450", "Lunch"),
                                FoodModel(painters[2], "Matoke", "Ksh. 300", "Supper"),
                                FoodModel(painters[2], "Mursik", "Ksh. 100", "Drink"),
                                FoodModel(painters[2], "Kaimati", "Ksh. 30", "Drink"),
                                FoodModel(painters[2], "Tea", "Ksh. 50", "Drink")
                            )

                        ) { index, item ->

                            MenuCard(
                                foodImage = item.foodImage,
                                foodName = item.foodName,
                                foodPrice = item.foodPrice,
                                foodCategory = item.foodCategory,
                            )

                            Spacer(modifier = Modifier.height(32.dp))
                        }
                    })

                }
            }
        }
    }
}

@Preview(
    name = "Menu Card Item",
    backgroundColor = 0xFF121212
)
@Composable
fun MenuCard(

    modifier: Modifier = Modifier,
    foodImage: Painter = painterResource(id = R.drawable.ic_food),
    foodName: String = "Chicken",
    foodPrice: String = "Ksh. 550",
    foodCategory: String = "Lunch"

) {

    Surface(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(16.dp)
            .aspectRatio(1F),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp
    ) {

        //  The column is the one that will be rounded
        Column(
            modifier
                .size(150.dp)
                .background(Color.Transparent)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = foodImage,
                contentDescription = foodName,
                modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = foodName,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = foodCategory,
                color = Color(0xFF212121),
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

        }

    }
}



























