package com.example.communcationingarden.data.source.info.remote

import com.example.communcationingarden.data.source.info.InfoDataSource
import com.example.communcationingarden.network.ActivityResponse
import com.example.communcationingarden.network.InfoRetrofitService
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
}