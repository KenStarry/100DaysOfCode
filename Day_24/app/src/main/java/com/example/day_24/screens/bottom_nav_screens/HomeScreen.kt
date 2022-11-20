package com.example.day_24.screens.bottom_nav_screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.sharp.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.day_24.Constants
import com.example.day_24.FoodCardModel
import com.example.day_24.R
import com.example.day_24.navigation.Screens
import com.example.day_24.ui.theme.Accent
import com.example.day_24.ui.theme.AccentLight
import com.example.day_24.ui.theme.StarIconColor

@Composable
fun HomeScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(all = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        //  discount card
        DiscountCard()

        // search bar
        SearchBar()

        //  popular food title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Popular Food",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "View all",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )

        }

        //  Lazy grid
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            columns = GridCells.Adaptive(120.dp),
            state = rememberLazyGridState(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            itemsIndexed(
                Constants.foodList

            ) { index, item ->

                FoodCard(
                    navController,
                    foodImage = painterResource(id = item.foodImage),
                    foodName = item.foodName,
                    foodPrice = item.foodPrice,
                    foodRating = item.foodRating
                )
            }
        }
    }
}

//  discount card
@Composable
fun DiscountCard() {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .width(300.dp)
            .height(160.dp),
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
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFfafafa)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Up To 85%",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFffffff)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            Toast.makeText(context, "Voucher Claimed", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Accent
                        ),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
                    ) {
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

//  search bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {

    var textFieldValue by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier
            .width(230.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(24.dp)),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextField(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray.copy(alpha = 0.3f)),
            value = textFieldValue,
            onValueChange = { text ->
                textFieldValue = text
            },
            singleLine = true,
            maxLines = 1,
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Sharp.Search,
                    contentDescription = "Search Icon",
                    tint = Color.LightGray
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                cursorColor = Accent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

//  food category
@Composable
fun FoodCard(
    navController: NavHostController,
    foodImage: Painter,
    foodName: String,
    foodPrice: String,
    foodRating: String,
) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .width(180.dp)
            .height(200.dp)
            .clickable {
                //Navigate to detail screen
                navController.navigate(route = Screens.DetailScreen.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) { saveState = true }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onSecondary),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            //  food image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .wrapContentHeight(),
            ) {

                //  food image
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = foodImage,
                        contentDescription = "Food card Icon",
                        contentScale = ContentScale.Fit
                    )
                }

                //  food rating
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        modifier = Modifier
                            .size(18.dp),
                        imageVector = Icons.Sharp.Favorite,
                        contentDescription = "Favourite icon",
                        tint = Accent
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = foodRating,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            //  food name
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = foodName,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            //  food price & icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                //  food name
                Text(
                    text = foodPrice,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                //  food add to cart
                Card(
                    modifier = Modifier
                        .size(40.dp),
                    shape = CircleShape
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(AccentLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(18.dp),
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = "Shopping Cart",
                            tint = Accent
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}

@Preview
@Composable
fun DiscountCardPreview() {
    DiscountCard()
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar()
}

@Preview
@Composable
fun FoodCardPreview() {
    FoodCard(
        rememberNavController(),
        foodName = "Sushi",
        foodImage = painterResource(id = R.drawable.image_removebg_preview__3_),
        foodPrice = "$25.99",
        foodRating = "170"
    )
}

@Preview(
    name = "Home",
    device = Devices.DEFAULT
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}