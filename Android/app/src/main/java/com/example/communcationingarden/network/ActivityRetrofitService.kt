package com.example.communcationingarden.network

import retrofit2.http.Body
import retrofit2.http.POST

interface ActivityRetrofitService {
    
    @POST("/activity_all")
    suspend fun getAllActivityList(
        @Body body: HashMap<String, String>
    ): ActivityResponse
    
    @POST("/participate_activity")
    suspend fun requestParticipateActivity(
        @Body body: HashMap<String, String>
    ): ParticipateResponse
    
    @POST("/activity_user")
    suspend fun requestUserActivityList(
        @Body body: HashMap<String, String>
    ): ActivityResponse
    
    @POST("/out_activity")
    suspend fun requestExitActivity(
        @Body body: HashMap<String, String>
    ): ExitResponse
    
    @POST("/add_activity")
    suspend fun requestRegistActivity(
        @Body body: HashMap<String, String>
    ): RegistActivityResponse
}
