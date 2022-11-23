package com.example.day_24.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.sharp.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day_24.R
import com.example.day_24.ui.theme.Accent
import com.example.day_24.ui.theme.AccentLight
import com.example.day_24.ui.theme.StarIconColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {

    //  scaffold to add a top app bar
    Scaffold(
        topBar = { DetailTopBar() }
    ) { contentPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(contentPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            //  main content
            ImageSection()

            //  name and rating row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Original Sushi",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )

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
                        imageVector = Icons.Sharp.Star,
                        contentDescription = "Favourite icon",
                        tint = StarIconColor
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "180",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

            }

            //  categories
            LazyRow(
                content = {
                    itemsIndexed(
                        listOf("Large", "Medium", "Small", "Deluxe")
                    ) { index, item ->

                        PillItem(pillText = item)

                    }
                },
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(start = 16.dp)
            )

            //  food price
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                //  price
                SmallAndLargeText(
                    modifier = Modifier
                        .padding(16.dp),
                    smallText = "Ksh ",
                    largeText = "550"
                )

                //  quantity
                QuantityCounter()

            }

            //  About section
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = "About Sushi",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1
            )

            //  About section
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                        "Ut enim ad minim veniam, laboris nisi ut aliquip ex ea commodo consequat. ",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.typography.bodyMedium.color.copy(alpha = 0.3f),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )

            //  place order section
            Box(
                modifier = Modifier
                    .width(280.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(24.dp)),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.onSecondary),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    //  total price column
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        //  price
                        SmallAndLargeText(
                            smallText = "Ksh ",
                            largeText = "550"
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Total Price",
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            fontWeight = FontWeight.Normal
                        )

                    }

                    //  place order button
                    Box(
                        modifier = Modifier
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {

                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Place Order")
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar() {

    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Details",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )

            }
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Sharp.ArrowBack,
                    contentDescription = "Arrow Back icon"
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Send Icon"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSection() {

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        //  horizontal page
        HorizontalPager(
            count = 5,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            itemSpacing = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)

        ) {
            Box(
                modifier = Modifier
                    .width(280.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mahmoud_fawzy_boj8rp7_vqa_unsplash),
                    contentDescription = "Detail Image",
                    contentScale = ContentScale.Crop
                )
            }
        }

        //  pager indicators
        HorizontalPagerIndicator(
            pagerState = pagerState,
            indicatorWidth = 5.dp,
            indicatorHeight = 5.dp,
            indicatorShape = CircleShape,
            activeColor = Accent,
            inactiveColor = AccentLight
        )
    }

}

//  pill categories item
@Composable
fun PillItem(
    pillText: String
) {

    Box(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(18.dp)),
    ) {

        Row(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(MaterialTheme.colorScheme.onSecondary)
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.image_removebg_preview__3_),
                contentDescription = "Pill image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(24.dp)
            )

            Text(
                text = pillText,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )

        }

    }
}

//  annotated string
@Composable
fun SmallAndLargeText(
    modifier: Modifier = Modifier,
    smallText: String,
    largeText: String
) {

    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.typography.bodySmall.color,
                )
            ) {
                append(smallText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.typography.bodyLarge.color
                )
            ) {
                append(largeText)
            }
        },
        modifier.padding(horizontal = 8.dp)
    )

}

//  quantity counter
@Composable
fun QuantityCounter() {

    var counterText by remember {
        mutableStateOf(1)
    }

    Box(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(30.dp))
    ) {

        //  add and minus button
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(MaterialTheme.colorScheme.onSecondary)
                .padding(
                    horizontal = 8.dp,
                    vertical = 8.dp
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            //  minus icon
            IconButton(onClick = {
                if (counterText > 1) {
                    counterText -= 1
                }
            }) {
                Icon(
                    imageVector = Icons.Sharp.Remove,
                    contentDescription = "Minus Icon",
                    tint = MaterialTheme.typography.titleLarge.color.copy(alpha = 0.6f)
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = counterText.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.typography.titleLarge.color
            )

            Spacer(modifier = Modifier.width(4.dp))

            //  plus icon
            IconButton(onClick = {
                counterText += 1
            }) {
                Icon(
                    imageVector = Icons.Sharp.Add,
                    contentDescription = "Plus Icon",
                    tint = MaterialTheme.typography.titleLarge.color.copy(alpha = 0.6f)
                )
            }

        }

    }
}

@Preview
@Composable
fun PillPrev() {
    PillItem("Saushi")
}

@Preview
@Composable
fun QuantityPrev() {
    QuantityCounter()
}

@Preview
@Composable
fun DetailsTopBarPrev() {
    DetailTopBar()
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen()
}