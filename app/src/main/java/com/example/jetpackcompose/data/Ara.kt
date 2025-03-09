package com.example.jetpackcompose.data

import kotlinx.serialization.Serializable

@Serializable
data class Ara(
    val common: String? = null,
    val official: String? = null
)