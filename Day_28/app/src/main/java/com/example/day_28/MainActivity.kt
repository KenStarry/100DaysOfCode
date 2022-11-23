package com.example.day_28

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day_28.ui.theme.Day_28Theme
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val archive = SwipeAction(
                onSwipe = {
                    Toast.makeText(this, "Archived", Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_archive_24),
                        contentDescription = "Archive"
                    )
                },
                background = Color.Green,
                isUndo = true
            )

            val email = SwipeAction(
                onSwipe = {
                    Toast.makeText(this, "Marked as Read", Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_mark_email_read_24),
                        contentDescription = "Email"
                    )
                },
                background = Color(0xFF008cff),
                isUndo = false
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Swipeable Actions",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(32.dp))

                SwipeableActionsBox(
                    startActions = listOf(archive),
                    endActions = listOf(email)
                ) {

                    CardItem()

                }

            }

        }
    }
}

@Composable
fun CardItem() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(18.dp)
                .background(MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .weight(5f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Title",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Some Random Text",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.Normal
            )

        }

    }
}

@Preview
@Composable
fun CardItemPreview() {
    CardItem()
}