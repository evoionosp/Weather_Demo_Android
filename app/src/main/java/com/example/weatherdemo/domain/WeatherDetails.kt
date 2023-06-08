package com.example.weatherdemo.domain

import com.squareup.moshi.Json

data class WeatherDetails(
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val city : String = "",
    val country: String = "",
    val temperature : Double = 0.0,
    val temperatureMin: Double = 0.0,
    val temperatureMax: Double = 0.0,
    val windSpeed: Int = 0,
    val windAngle: Int = 0,
    val feelsLike: Double = 0.0,
    val humidity: Int = 0,
    val pressure: Int = 0,
    val weatherCondition: String = "",
    val weatherDescription: String = "",
    val sunrise: Int = 0,
    val sunset: Int = 0
)