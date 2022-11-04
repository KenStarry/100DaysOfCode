package com.example.day8

import androidx.compose.ui.graphics.painter.Painter

data class FoodModel(

    val foodImage: Painter,
    val foodName: String,
    val foodPrice: String,
    val foodCategory: String,

) {
}