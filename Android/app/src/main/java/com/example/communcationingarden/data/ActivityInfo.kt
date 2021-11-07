package com.example.communcationingarden.data

import com.google.gson.annotations.SerializedName

data class ActivityInfo(
	val no: Int,
	@SerializedName("garden")
	val gardenName: String,
	@SerializedName("name")
	val activityName: String,
	val date: String,
	val time: String,
	val url: String,
	@SerializedName("max")
	val maxParticipantsNumber: Int,
	@SerializedName("cur")
	val currentParticipantsNumber: Int
) {
	
	val participantCountText get() = "$currentParticipantsNumber / $maxParticipantsNumber"
}