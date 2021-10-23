package com.example.communcationingarden.data

import com.example.communcationingarden.util.toDistanceText

data class Garden(
	val name: String,
	val distance: Double
) {

	val distanceText = distance.toDistanceText()
}
