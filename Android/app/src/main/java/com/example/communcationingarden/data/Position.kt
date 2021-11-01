package com.example.communcationingarden.data

import kotlinx.serialization.Serializable

@Serializable
data class Position(
	val latitude: Double = 0.0,
	val longitude: Double = 0.0,
)
