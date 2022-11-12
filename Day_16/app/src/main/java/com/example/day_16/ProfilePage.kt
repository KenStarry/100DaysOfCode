package com.example.day_16

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProfileCard() {

    //  card to hold our profile
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(8.dp)),
    ) {

        //  main content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp),
            horizontalAlignment = Alignment.Start
        ) {

            //  The top image row
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                //  profile image
                Image(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.lady1),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Crop
                )

                //  user statistics
                Column(
                    modifier = Modifier
                        .weight(3f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    //  row for the numbers
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        content = {
                            itemsIndexed(
                                listOf(
                                    StatsModel("100+", "connections"),
                                    StatsModel("852", "followers"),
                                    StatsModel("156", "following")
                                )
                            ) { index, item ->

                                StatsCard(count = item.count, subtitle = item.desc)
                            }
                        },
                        contentPadding = PaddingValues(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    //  row for the buttons
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth(),
                            content = {
                                itemsIndexed(
                                    listOf("Follow", "Message")
                                ) { index, item ->
                                    FollowButton(text = item)

                                    Spacer(modifier = Modifier.width(8.dp))
                                }
                            },
                            horizontalArrangement = Arrangement.Center
                        )

                    }
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            //  user name
            Text(
                text = "Silvia S.",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            //  user description
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                //  user location
                Text(
                    text = "Istanbul, Turkey",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.width(16.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp),
                    color = Color(0xFF008cff).copy(alpha = 0.3f)
                )

                Spacer(modifier = Modifier.width(16.dp))

                //  user Bio
                Text(
                    text = "UI Designer - Apple",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            //  Hashtags
            LazyRow(content = {
                itemsIndexed(
                    listOf("# Designer", "# Developer", "# Android")
                ) { index, item ->

                    HashTags(item)
                    Spacer(modifier = Modifier.width(8.dp))
                }
            })

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {

                Button(
                    modifier = Modifier
                        .weight(5f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF008CFF),
                        contentColor = Color.White
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Connect")
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(width = 1.dp, color = Color(0xFF008cff), shape = CircleShape),
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "More",
                        tint = Color(0xFF323232)
                    )
                }

            }

        }

    }

}

@Preview(name = "Stats Card")
@Composable
fun StatsCard(
    count: String = "100+",
    subtitle: String = "followers"
) {

    Column(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = count,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )

        Text(
            text = subtitle,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF323232)
        )
    }
}

@Preview
@Composable
fun FollowButton(
    text: String = "Follow"
) {

    Button(
        modifier = Modifier
            .height(35.dp)
            .padding(0.dp),
        colors = ButtonDefaults
            .buttonColors(
                containerColor = Color(0xFF008cff).copy(alpha = 0.4f),
                contentColor = Color.White
            ),
        onClick = { /*TODO*/ }
    ) {
        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
fun HashTags(
    hashtag: String = "# Hashtag"
) {

    Surface(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .background(Color.Transparent)
            .border(
                width = 1.dp,
                color = Color(0xFF323232).copy(alpha = 0.3f),
                shape = RoundedCornerShape(32.dp)
            ),
        shape = RoundedCornerShape(32.dp),
        shadowElevation = 0.dp
    ) {

        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 2.dp),
            text = hashtag,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color(0xFF323232)
        )

    }
}

@Preview(name = "Profile Card")
@Composable
fun ProfileCardPreview() {
    ProfileCard()
}
































