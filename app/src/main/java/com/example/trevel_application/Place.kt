package com.example.trevel_application

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Place(
    val place: String,
    val city: String,
    val country: String,
    val rating: Double,
    val isFavorite: Boolean,
    val price: Int,
    val duration: Int,
    val temperature: Int,

    @StringRes
    val description: Int,

    @DrawableRes
    val imageLink: Int
)