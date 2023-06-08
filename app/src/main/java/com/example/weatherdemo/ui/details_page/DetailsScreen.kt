package com.example.weatherdemo.ui.details_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherdemo.ui.components.NoNetwork

@Composable
fun DetailsScreen() {
    val viewModel = hiltViewModel<DetailsViewModel>()
    val uiState = viewModel.uiState

    if (uiState.offline) {
        NoNetwork()
    } else {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(16.dp)
        ) {
//            AsyncImage(
//                modifier = Modifier.size(100.dp),
//                model = uiState.details.avatar,
//                contentDescription = null
//            )
            Column {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = uiState.details.city,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    text = uiState.fTemp,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    text = uiState.fTempMax,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    text = uiState.fTempMin,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}