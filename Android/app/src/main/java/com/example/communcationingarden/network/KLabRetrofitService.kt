package com.example.communcationingarden.network

import retrofit2.http.Body
import retrofit2.http.POST

interface KLabRetrofitService {
	
	@POST("/signup")
	suspend fun requestSignUp(@Body body: HashMap<String, String>): SignUpResponse
	@POST("/login")
	suspend fun requestSignIn(@Body body: HashMap<String, String>): SignInResponse
}