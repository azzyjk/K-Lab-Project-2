package com.example.communcationingarden.data.source.info.remote

import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.source.info.InfoDataSource
import com.example.communcationingarden.network.ActivityResponse
import com.example.communcationingarden.network.InfoRetrofitService
import com.example.communcationingarden.network.ParticipateResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InfoRemoteDataSource(private val infoRetrofitService: InfoRetrofitService) :
	InfoDataSource.Remote {
	
	override suspend fun getAllActivityList(gardenName: String): Result<ActivityResponse> =
		withContext(Dispatchers.IO) {
			kotlin.runCatching {
				val body = HashMap<String, String>().apply {
					put("garden", gardenName)
				}
				infoRetrofitService.getAllActivityList(body)
			}
		}
	
	override suspend fun requestParticipateActivity(
		userId: String,
		activityInfo: ActivityInfo
	): Result<ParticipateResponse> =
		withContext(Dispatchers.IO) {
			kotlin.runCatching {
				val body = HashMap<String, String>().apply {
					put("activity_no", activityInfo.no.toString())
					put("id", userId)
				}
				infoRetrofitService.requestParticipateActivity(body)
			}
		}
	
	override suspend fun getUserActivityList(
		userId: String,
		gardenName: String
	): Result<ActivityResponse> =
		withContext(Dispatchers.IO) {
			kotlin.runCatching {
				val body = HashMap<String, String>().apply {
					put("garden", gardenName)
					put("id", userId)
				}
				infoRetrofitService.requestUserActivityList(body)
			}
		}
}