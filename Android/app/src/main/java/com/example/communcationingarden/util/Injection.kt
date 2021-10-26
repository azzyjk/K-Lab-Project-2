package com.example.communcationingarden.util

import android.content.Context
import com.example.communcationingarden.data.source.DevLoginRepository
import com.example.communcationingarden.data.source.local.LoginLocalDataSource
import com.example.communcationingarden.data.source.remote.LoginRemoteDataSource

object Injection {

	fun provideLoginRepository(context: Context): DevLoginRepository {
		val loginLocalDataSource = provideLoginLocalDataSource(context)
		val loginRemoteDataSource = provideLoginRemoteDataSource()
		return DevLoginRepository(loginLocalDataSource, loginRemoteDataSource)
	}

	private fun provideLoginLocalDataSource(context: Context): LoginLocalDataSource {
		return LoginLocalDataSource()
	}

	private fun provideLoginRemoteDataSource(): LoginRemoteDataSource {
		return LoginRemoteDataSource
	}
}