package com.example.day_16

data class StatsModel(

    val count: String,
    val desc: String
) {

    constructor(): this("", "")
}