package com.example.communcationingarden.data.source.garden

import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.RegistActivityInfo
import com.example.communcationingarden.data.source.garden.local.GardenLocalDataSource
import com.example.communcationingarden.data.source.garden.remote.GardenRemoteDataSource
import com.example.communcationingarden.network.ActivityResponse
import com.example.communcationingarden.network.ExitResponse
import com.example.communcationingarden.network.ParticipateResponse
import com.example.communcationingarden.network.RegistActivityResponse

class GardenRepositoryImpl(
	private val localDataSource: GardenLocalDataSource,
	private val remoteDataSource: GardenRemoteDataSource
): GardenRepository {
	
	override suspend fun getAllActivityList(gardenName: String): Result<ActivityResponse> {
		return remoteDataSource.getAllActivityList(gardenName)
	}
	
	override suspend fun requestParticipate(
		userId: String,
		activityInfo: ActivityInfo
	): Result<ParticipateResponse> {
		return remoteDataSource.requestParticipateActivity(userId, activityInfo)
	}
	
	override suspend fun getUserActivityList(
		userId: String,
		gardenName: String
	): Result<ActivityResponse> {
		return remoteDataSource.getUserActivityList(userId, gardenName)
	}
	
	override suspend fun requestExitActivity(
		userId: String,
		activityInfo: ActivityInfo
	): Result<ExitResponse> {
		return remoteDataSource.requestExitActivity(userId, activityInfo)
	}
	
	override suspend fun requestRegistActivity(
		userId: String,
		gardenName: String,
		registActivityInfo: RegistActivityInfo
	): Result<RegistActivityResponse> {
		return remoteDataSource.requestRegistActivity(userId, gardenName, registActivityInfo)
	}
}
