package com.example.myapplication.models.forecast

import kotlinx.serialization.Serializable

@Serializable

data class ForecastWeatherResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ForecastWeather>,
    val message: Int
)