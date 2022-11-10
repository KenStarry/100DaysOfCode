package com.example.day_15

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(
    title: String,
    desc: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Duis vitae augue eget diam commodo gravida interdum sed mi. " +
            "Duis mattis, augue nec laoreet ultrices, dui risus dictum neque,"
) {

    //  a variable to hold our expanded state
    var expandedState by remember {
        mutableStateOf(false)
    }

    //  a variable to animate the dropdown icon
    val iconRotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            //  animate our height as it grows and shrinks
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            expandedState = !expandedState
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            //  our title and arrow icon
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = "My Title",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                IconButton(
                    modifier = Modifier
                        .alpha(0.7f)
                        .weight(1f)
                        .rotate(iconRotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {

                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dropdown Arrow"
                    )

                }
            }

            //  Show description if expanded
            if (expandedState) {
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                            "Duis vitae augue eget diam commodo gravida interdum sed mi. " +
                            "Duis mattis, augue nec laoreet ultrices, dui risus dictum neque,",
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

    }
}

@Preview(name = "My Card")
@Composable
fun ExpandableCardPreview() {
    ExpandableCard("Title 1")
}