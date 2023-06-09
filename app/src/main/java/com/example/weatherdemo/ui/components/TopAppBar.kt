package com.example.weatherdemo

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun SimpleTopAppBar(title: String){
    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text(title)
            },
            backgroundColor = MaterialTheme.colors.primarySurface,
//            navigationIcon = {
//                IconButton(onClick = {/* Do Something*/ }) {
//                    Icon(Icons.Filled.ArrowBack, null)
//                }
//            }, actions = {
//                IconButton(onClick = {/* Do Something*/ }) {
//                    Icon(Icons.Filled.Share, null)
//                }
//                IconButton(onClick = {/* Do Something*/ }) {
//                    Icon(Icons.Filled.Settings, null)
//                }
//            }
        )
    }
}