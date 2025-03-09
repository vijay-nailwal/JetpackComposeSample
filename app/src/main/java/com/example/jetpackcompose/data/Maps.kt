package com.example.jetpackcompose.data

import kotlinx.serialization.Serializable

@Serializable
data class Maps(
    val googleMaps: String? = null,
    val openStreetMaps: String? = null
)