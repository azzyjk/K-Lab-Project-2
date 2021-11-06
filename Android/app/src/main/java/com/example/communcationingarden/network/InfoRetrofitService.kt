package com.example.communcationingarden.network

import retrofit2.http.Body
import retrofit2.http.POST

interface InfoRetrofitService {
	
	@POST("/activity_all")
	suspend fun getAllActivityList(@Body body: HashMap<String, String>): ActivityResponse
}