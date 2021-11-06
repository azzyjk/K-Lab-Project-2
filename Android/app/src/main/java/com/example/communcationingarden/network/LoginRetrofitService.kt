package com.example.communcationingarden.network

import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitService {
	
	@POST("/signup")
	suspend fun requestSignUp(@Body body: HashMap<String, String>): SignUpResponse
	
	@POST("/login")
	suspend fun requestSignIn(@Body body: HashMap<String, String>): SignInResponse
	
	@POST("/garden")
	suspend fun requestGardenList(@Body body: HashMap<String, String>): GardenListResponse
}