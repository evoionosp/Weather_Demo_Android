package com.example.weatherdemo.ui.details_page

import com.example.weatherdemo.domain.WeatherDetails
import com.example.weatherdemo.util.formatTemperature

data class DetailsUiState(
    val details: WeatherDetails = WeatherDetails(),
    val offline: Boolean = false
) {

    val name = details.city
    val fTemp: String = formatTemperature(details.temperature)
    val fTempMin: String = formatTemperature(details.temperatureMin)
    val fTempMax: String = formatTemperature(details.temperatureMax)
}