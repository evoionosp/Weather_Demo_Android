package com.example.weatherdemo.ui.main_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherdemo.R
import com.example.weatherdemo.SimpleTopAppBar
import com.example.weatherdemo.ui.components.NoNetwork
import com.example.weatherdemo.ui.theme.WeatherDemoTheme

@Composable
fun MainScreen() {
    WeatherDemoTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                SimpleTopAppBar("Weather App")
            }
        }
    }
}