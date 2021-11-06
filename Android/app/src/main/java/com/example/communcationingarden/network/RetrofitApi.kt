package com.example.communcationingarden.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
	
	private const val kLabBaseUrl = "https://klab0.herokuapp.com"
	private var loginRetrofitInstance: LoginRetrofitService? = null
	private var infoRetrofitInstance: InfoRetrofitService? = null
	
	fun getLoginRetrofitInstance(): LoginRetrofitService {
		if (loginRetrofitInstance == null) {
			loginRetrofitInstance = Retrofit.Builder()
				.baseUrl(kLabBaseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(LoginRetrofitService::class.java)
		}
		return loginRetrofitInstance!!
	}
	
	fun getInfoRetrofitInstance(): InfoRetrofitService {
		if (infoRetrofitInstance == null) {
			infoRetrofitInstance = Retrofit.Builder()
				.baseUrl(kLabBaseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(InfoRetrofitService::class.java)
		}
		return infoRetrofitInstance!!
	}
}