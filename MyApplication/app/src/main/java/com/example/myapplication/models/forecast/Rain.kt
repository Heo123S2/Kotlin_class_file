package com.example.myapplication.models.forecast

import kotlinx.serialization.Serializable

@Serializable

data class Rain(
    val `3h`: Double
)