package com.example.communcationingarden.data.source.activity.remote

import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.RegistActivityInfo
import com.example.communcationingarden.data.source.activity.ActivityDataSource
import com.example.communcationingarden.network.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ActivityRemoteDataSource(
    private val activityRetrofitService: ActivityRetrofitService
): ActivityDataSource.Remote {
    
    override suspend fun getAllActivityList(
        gardenName: String
    ): Result<ActivityResponse> =
        withContext(Dispatchers.IO) {
            kotlin.runCatching {
                val body = HashMap<String, String>().apply {
                    put("garden", gardenName)
                }
                activityRetrofitService.getAllActivityList(body)
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
                activityRetrofitService.requestParticipateActivity(body)
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
                activityRetrofitService.requestUserActivityList(body)
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
                activityRetrofitService.requestExitActivity(body)
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
                activityRetrofitService.requestRegistActivity(body)
            }
        }
}
