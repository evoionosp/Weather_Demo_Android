package com.example.weatherdemo.repository

import com.example.weatherdemo.domain.WeatherDetails
import com.example.weatherdemo.network.WeatherDetailsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class WeatherDetailsRepository @Inject constructor(private val weatherDetailsApi: WeatherDetailsApi) {

    suspend fun getWeatherDetails(place: String): Flow<WeatherDetails> = flow {
        val tmp = weatherDetailsApi.getWeatherDetails(place)
        Timber.tag("TestTAAG").d(tmp.toString())
        emit(WeatherDetails())
    }
}