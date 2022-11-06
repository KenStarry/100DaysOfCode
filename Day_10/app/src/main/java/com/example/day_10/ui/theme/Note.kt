package com.example.day_10.ui.theme

data class Note(

    val noteTitle: String,
    val noteDesc: String
) {

    constructor() : this("", "")
}