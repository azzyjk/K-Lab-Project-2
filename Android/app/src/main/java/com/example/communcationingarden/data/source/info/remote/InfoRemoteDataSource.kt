package com.example.communcationingarden.data.source.info.remote

import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.RegistActivityInfo
import com.example.communcationingarden.data.source.info.InfoDataSource
import com.example.communcationingarden.network.*
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
	
	override suspend fun requestExitActivity(
		userId: String,
		activityInfo: ActivityInfo
	): Result<ExitResponse> =
		withContext(Dispatchers.IO) {
			kotlin.runCatching {
				val body = HashMap<String, String>().apply {
					put("activity_no", activityInfo.no.toString())
					put("id", userId)
				}
				infoRetrofitService.requestExitActivity(body)
			}
		}
	
	override suspend fun requestRegistActivity(
		userId: String,
		gardenName: String,
		registActivityInfo: RegistActivityInfo
	): Result<RegistActivityResponse> =
		withContext(Dispatchers.IO) {
			kotlin.runCatching {
				val body = HashMap<String, String>().apply {
					put("id", userId)
					put("garden", gardenName)
					put("name", registActivityInfo.activityName)
					put("date", registActivityInfo.date)
					put("time", registActivityInfo.time)
					put("url", registActivityInfo.time)
					put("max", registActivityInfo.max.toString())
				}
				infoRetrofitService.requestRegistActivity(body)
			}
		}
}
