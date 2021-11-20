package com.example.communcationingarden.network

import retrofit2.http.Body
import retrofit2.http.POST

interface GardenRetrofitService {
    
    @POST("/garden")
    suspend fun requestGardenList(
        @Body body: HashMap<String, String>
    ): GardenListResponse
}
