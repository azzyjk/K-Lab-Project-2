package com.example.communcationingarden.data

import com.example.communcationingarden.util.toDistanceText
import com.google.gson.annotations.SerializedName

data class GardenInfo(
	@SerializedName("garden_name")
	val name: String,
	val distance: Int,
	val latitude: Double,
	val longitude: Double,
	val description: String
) {
	
	val distanceText get() = distance.toDistanceText()
}
