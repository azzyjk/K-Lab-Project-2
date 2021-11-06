package com.example.communcationingarden.util

import android.content.Context
import com.example.communcationingarden.data.source.LoginRepositoryImpl
import com.example.communcationingarden.data.source.local.LoginLocalDataSource
import com.example.communcationingarden.data.source.remote.LoginRemoteDataSource
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
		return LoginRemoteDataSource(RetrofitApi.getKLabRetrofitInstance())
	}
}