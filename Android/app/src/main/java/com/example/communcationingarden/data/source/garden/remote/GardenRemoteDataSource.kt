package com.example.communcationingarden.data.source.garden.remote

import com.example.communcationingarden.data.Position
import com.example.communcationingarden.data.source.garden.GardenDataSource
import com.example.communcationingarden.network.GardenListResponse
import com.example.communcationingarden.network.GardenRetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GardenRemoteDataSource @Inject constructor(
    private val gardenRetrofitService: GardenRetrofitService
): GardenDataSource.Remote {
    
    override suspend fun requestGardenList(
        userPosition: Position
    ): Result<GardenListResponse> =
        withContext(Dispatchers.IO) {
            kotlin.runCatching {
                val body = HashMap<String, String>().apply {
                    put("latitude", userPosition.latitude.toString())
                    put("longitude", userPosition.longitude.toString())
                }
                gardenRetrofitService.requestGardenList(body)
            }
        }
}
