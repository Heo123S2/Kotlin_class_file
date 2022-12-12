package com.example.myapplication

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

object KtorManager {
    val httpClient = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                kotlinx.serialization.json.Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    useArrayPolymorphism = true
                }
            )
        }
    }
}
