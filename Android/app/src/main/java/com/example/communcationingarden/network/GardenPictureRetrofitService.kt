package com.example.communcationingarden.network

import retrofit2.http.Body
import retrofit2.http.POST

interface GardenPictureRetrofitService {
    
    @POST("/info")
    suspend fun getPictureList(
        @Body body: HashMap<String, String>
    ): GardenPictureListResponse
}
