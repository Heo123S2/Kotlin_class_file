package com.example.myapplication.models.weather

import kotlinx.serialization.Serializable

@Serializable
data class Clouds(
    val all: Int
)