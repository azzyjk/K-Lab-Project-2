package com.example.communcationingarden.data.source.info

import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.source.info.local.InfoLocalDataSource
import com.example.communcationingarden.data.source.info.remote.InfoRemoteDataSource
import com.example.communcationingarden.network.ActivityResponse
import com.example.communcationingarden.network.ParticipateResponse

class InfoRepositoryImpl(
	private val localDataSource: InfoLocalDataSource,
	private val remoteDataSource: InfoRemoteDataSource
) : InfoRepository {
	
	override suspend fun getAllActivityList(gardenName: String): Result<ActivityResponse> {
		return remoteDataSource.getAllActivityList(gardenName)
	}
	
	override suspend fun requestParticipate(
		userId: String,
		activityInfo: ActivityInfo
	): Result<ParticipateResponse> {
		return remoteDataSource.requestParticipate(userId, activityInfo)
	}
}