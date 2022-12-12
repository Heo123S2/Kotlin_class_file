package com.example.myapplication.models.forecast

import kotlinx.serialization.Serializable

@Serializable

data class ForecastWeather(
    val clouds: Clouds,
    val dt: Long,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val rain: Rain? = null,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)