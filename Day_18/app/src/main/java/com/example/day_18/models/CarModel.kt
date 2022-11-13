package com.example.day_18.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class CarModel(
    val carImage: Painter?,
    val carBackground: Color?,
    val carRating: Double,
    val carModel: String,
    val carHorsePower: String,
    val carAccelerationTime: String,
    val carPrice: String
) {
    constructor(): this(
        null, Color.Cyan, 0.0, "", "", "", ""
    )
}