package com.example.day5

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day5.ui.theme.Day5Theme
import com.example.day5.ui.theme.HouseModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day5Theme {

                val state = rememberLazyListState(
                    initialFirstVisibleItemIndex = 0
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Lazy Lists",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )

                    //  A lazy column to populate our houses
                    LazyColumn(content = {

                        itemsIndexed(
                            listOf(
                                HouseModel(R.drawable.house1, "Executive", "Ksh. 150,000"),
                                HouseModel(R.drawable.house2, "Joylands", "Ksh. 10,000"),
                                HouseModel(R.drawable.house3, "Palace", "Ksh. 15,000"),
                                HouseModel(R.drawable.house4, "Muthaiga", "Ksh. 50,000"),
                                HouseModel(R.drawable.house5, "Sichirai", "Ksh. 12,000"),
                            )
                        ) { index, house ->

                            Spacer(modifier = Modifier.height(50.dp))

                            HouseCard(
                                painter = painterResource(id = house.img),
                                title = house.title,
                                price = house.price,
                                modifier = Modifier
                                    .clickable {
                                        Toast.makeText(this@MainActivity, house.title, Toast.LENGTH_SHORT).show()
                                    }
                            )
                        }
                    }, state = state)
                }
            }
        }
    }
}

@Preview(
    name = "House Card"
)
@Composable
fun HouseCard(
    modifier: Modifier = Modifier,
    painter: Painter = painterResource(id = R.drawable.house13),
    title: String = "House",
    price: String = ""
) {

    Surface(
        modifier
            .width(250.dp)
            .height(250.dp)
            .background(Color(0xFF212121)),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp
    ) {

        Column(
            modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painter,
                contentDescription = title,
                modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )

        }

    }

}


