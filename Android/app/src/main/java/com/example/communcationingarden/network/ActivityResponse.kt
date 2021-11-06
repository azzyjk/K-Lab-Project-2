package com.example.communcationingarden.network

import com.example.communcationingarden.data.ActivityInfo
import com.google.gson.annotations.SerializedName

data class ActivityResponse(
	@SerializedName("activity")
	val activityList: List<ActivityInfo>
)
