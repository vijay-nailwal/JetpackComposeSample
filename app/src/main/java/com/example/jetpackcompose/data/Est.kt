package com.example.jetpackcompose.data

import kotlinx.serialization.Serializable

@Serializable
data class Est(
    val common: String? = null,
    val official: String? = null
)