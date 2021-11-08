package com.example.communcationingarden.data.source.info

import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.RegistActivityInfo
import com.example.communcationingarden.network.ActivityResponse
import com.example.communcationingarden.network.ExitResponse
import com.example.communcationingarden.network.ParticipateResponse
import com.example.communcationingarden.network.RegistActivityResponse

interface InfoDataSource {
	interface Local {
	}
	
	interface Remote {
		
		suspend fun getAllActivityList(gardenName: String): Result<ActivityResponse>
		
		suspend fun requestParticipateActivity(
			userId: String,
			activityInfo: ActivityInfo
		): Result<ParticipateResponse>
		
		suspend fun getUserActivityList(
			userId: String,
			gardenName: String
		): Result<ActivityResponse>
		
		suspend fun requestExitActivity(
			userId: String,
			activityInfo: ActivityInfo
		): Result<ExitResponse>
		
		suspend fun requestRegistActivity(
			userId: String,
			gardenName: String,
			registActivityInfo: RegistActivityInfo
		): Result<RegistActivityResponse>
	}
}
