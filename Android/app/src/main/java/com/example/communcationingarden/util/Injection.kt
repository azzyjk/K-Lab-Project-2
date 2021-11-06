package com.example.communcationingarden.util

import android.content.Context
import com.example.communcationingarden.data.source.info.InfoRepositoryImpl
import com.example.communcationingarden.data.source.info.local.InfoLocalDataSource
import com.example.communcationingarden.data.source.info.remote.InfoRemoteDataSource
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
	
	fun provideInfoRepository(context: Context): InfoRepositoryImpl {
		val infoLocalDataSource = provideInfoLocalDataSource(context)
		val infoRemoteDataSource = provideInfoRemoteDataSource()
		return InfoRepositoryImpl(infoLocalDataSource, infoRemoteDataSource)
	}
	
	fun provideInfoLocalDataSource(context: Context): InfoLocalDataSource {
		return InfoLocalDataSource()
	}
	
	fun provideInfoRemoteDataSource(): InfoRemoteDataSource {
		return InfoRemoteDataSource(RetrofitApi.getInfoRetrofitInstance())
	}
}