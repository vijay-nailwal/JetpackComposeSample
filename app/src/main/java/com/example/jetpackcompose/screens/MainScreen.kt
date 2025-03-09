package com.example.jetpackcompose.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.components.CountryCard
import com.example.jetpackcompose.data.Country

@Composable
fun MainScreen(countryList: MutableList<Country>, innerPadding: PaddingValues) {
    Surface(
        modifier = Modifier.fillMaxSize().padding(paddingValues = innerPadding),
    ) {
        LazyColumn {
            items(countryList) {
                CountryCard(countryInfo = it)
            }
        }
    }
}