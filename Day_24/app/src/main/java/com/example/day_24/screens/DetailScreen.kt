package com.example.day_24.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day_24.R
import com.example.day_24.ui.theme.Accent
import com.example.day_24.ui.theme.AccentLight
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
                .padding(contentPadding),
            verticalArrangement = Arrangement.spacedBy(24.dp)
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
                        imageVector = Icons.Sharp.Favorite,
                        contentDescription = "Favourite icon",
                        tint = Accent
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "180",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

            }

            //  lazy row
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

                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                                color = MaterialTheme.typography.bodySmall.color
                            )
                        ){
                            append("Ksh")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                                fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
                                color = MaterialTheme.typography.bodyLarge.color
                            )
                        ){
                            append("1,500")
                        }
                    },
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )


            }

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

@Preview
@Composable
fun PillPrev() {
    PillItem("Saushi")
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