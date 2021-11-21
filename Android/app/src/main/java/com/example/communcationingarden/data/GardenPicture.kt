package com.example.communcationingarden.data

import kotlinx.serialization.Serializable

@Serializable
data class GardenPicture(
    val garden: String,
    val name: String,
    val description: String,
    val img: String,
)
