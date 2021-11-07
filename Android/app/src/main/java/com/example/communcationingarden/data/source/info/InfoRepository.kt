package com.example.communcationingarden.data.source.info

import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.network.ActivityResponse
import com.example.communcationingarden.network.ParticipateResponse

interface InfoRepository {
	
	suspend fun getAllActivityList(gardenName: String): Result<ActivityResponse>
	
	suspend fun requestParticipate(
		userId: String,
		activityInfo: ActivityInfo
	): Result<ParticipateResponse>
	
	suspend fun getUserActivityList(userId: String, gardenName: String): Result<ActivityResponse>
}