package com.example.myapplication.models.forecast

import kotlinx.serialization.Serializable

@Serializable

data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)