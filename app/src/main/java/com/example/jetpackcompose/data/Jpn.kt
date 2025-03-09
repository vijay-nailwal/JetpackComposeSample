package com.example.jetpackcompose.data

import kotlinx.serialization.Serializable

@Serializable
data class Jpn(
    val common: String? = null,
    val official: String? = null
)