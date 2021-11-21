package com.example.communcationingarden.data.source.gardenpicture.remote

import com.example.communcationingarden.data.GardenPicture
import com.example.communcationingarden.data.source.gardenpicture.GardenPictureDataSource
import com.example.communcationingarden.network.PictureRetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GardenPictureRemoteDataSource @Inject constructor(
    private val gardenPictureRetrofitService: PictureRetrofitService
): GardenPictureDataSource.Remote {
    
    override suspend fun getGardenPictureList(
        gardenName: String
    ): Result<List<GardenPicture>> =
        withContext(Dispatchers.IO) {
            kotlin.runCatching {
                val body = HashMap<String, String>().apply {
                    put("garden", gardenName)
                }
                gardenPictureRetrofitService.getPictureList(body).list
            }
            
        }
}
