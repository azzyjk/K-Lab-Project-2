package com.example.communcationingarden.util

import android.content.Context
import com.example.communcationingarden.data.source.garden.GardenRepositoryImpl
import com.example.communcationingarden.data.source.garden.local.GardenLocalDataSource
import com.example.communcationingarden.data.source.garden.remote.GardenRemoteDataSource
import com.example.communcationingarden.data.source.login.LoginRepositoryImpl
import com.example.communcationingarden.data.source.login.local.LoginLocalDataSource
import com.example.communcationingarden.data.source.login.remote.LoginRemoteDataSource
import com.example.communcationingarden.network.RetrofitApi

object Injection {
	
	fun provideLoginRepository(context: Context): LoginRepositoryImpl {
		val loginLocalDataSource = provideLoginLocalDataSource(context)
		val loginRemoteDataSource = provideLoginRemoteDataSource()
		return LoginRepositoryImpl(loginLocalDataSource, loginRemoteDataSource)
	}
	
	private fun provideLoginLocalDataSource(context: Context): LoginLocalDataSource {
		return LoginLocalDataSource()
	}
	
	private fun provideLoginRemoteDataSource(): LoginRemoteDataSource {
		return LoginRemoteDataSource(RetrofitApi.getLoginRetrofitInstance())
	}
	
	fun provideInfoRepository(context: Context): GardenRepositoryImpl {
		val infoLocalDataSource = provideInfoLocalDataSource(context)
		val infoRemoteDataSource = provideInfoRemoteDataSource()
		return GardenRepositoryImpl(infoLocalDataSource, infoRemoteDataSource)
	}
	
	fun provideInfoLocalDataSource(context: Context): GardenLocalDataSource {
		return GardenLocalDataSource()
	}
	
	fun provideInfoRemoteDataSource(): GardenRemoteDataSource {
		return GardenRemoteDataSource(RetrofitApi.getInfoRetrofitInstance())
	}
}
