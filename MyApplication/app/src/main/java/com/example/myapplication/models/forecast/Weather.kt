package com.example.myapplication.models.forecast

import kotlinx.serialization.Serializable

@Serializable

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)