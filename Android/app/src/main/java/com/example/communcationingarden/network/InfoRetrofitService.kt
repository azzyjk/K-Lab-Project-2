package com.example.communcationingarden.network

import retrofit2.http.Body
import retrofit2.http.POST

interface InfoRetrofitService {
	
	@POST("/activity_all")
	suspend fun getAllActivityList(@Body body: HashMap<String, String>): ActivityResponse
	
	@POST("/participate_activity")
	suspend fun requestParticipateActivity(@Body body: HashMap<String, String>): ParticipateResponse
	
	@POST("/activity_user")
	suspend fun requestUserActivityList(@Body body: HashMap<String, String>): ActivityResponse
	
	@POST("/out_activity")
	suspend fun requestExitActivity(@Body body: HashMap<String, String>): ExitResponse
}