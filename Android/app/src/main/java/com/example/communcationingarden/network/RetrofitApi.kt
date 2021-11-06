package com.example.communcationingarden.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
	
	private const val kLabBaseUrl = "https://klab0.herokuapp.com"
	private var kLabRetrofitInstance: KLabRetrofitService? = null
	
	fun getKLabRetrofitInstance(): KLabRetrofitService {
		if (kLabRetrofitInstance == null) {
			kLabRetrofitInstance = Retrofit.Builder()
				.baseUrl(kLabBaseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(KLabRetrofitService::class.java)
		}
		return kLabRetrofitInstance!!
	}
}