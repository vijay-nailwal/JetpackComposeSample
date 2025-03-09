package com.example.jetpackcompose.data

import kotlinx.serialization.Serializable

@Serializable
data class CapitalInfo(
    val latlng: List<Double>? = null
)