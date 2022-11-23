package com.example.day_27

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.skydoves.colorpicker.compose.*

@Composable
fun ColorPicker() {

    //   controller for our color picker
    val controller = rememberColorPickerController()
    var colorHex by remember {
        mutableStateOf("#ffffff")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Color Picker",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.titleLarge.fontSize
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = colorHex,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleMedium.fontSize
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        //  alpha tile
        AlphaTile(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(8.dp)),
            controller = controller,
            tileEvenColor = Color.White,
            tileOddColor = Color.LightGray,
            tileSize = 16.dp
        )

        Spacer(modifier = Modifier.height(24.dp))

        //  the color wheel
        HsvColorPicker(
            modifier = Modifier
                .size(300.dp),
            controller = controller,
            onColorChanged = {
                colorHex = "#${it.hexCode}"
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        //  our slider
        AlphaSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(35.dp),
            controller = controller
        )

        //  brightness slider
        BrightnessSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(35.dp),
            controller = controller
        )
    }
}

@Preview
@Composable
fun ColorPickerPrev() {
    ColorPicker()
}