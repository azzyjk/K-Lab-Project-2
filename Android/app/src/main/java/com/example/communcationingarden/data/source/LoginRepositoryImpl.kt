package com.example.communcationingarden.data.source

import com.example.communcationingarden.data.source.local.LoginLocalDataSource
import com.example.communcationingarden.data.source.remote.LoginRemoteDataSource

class LoginRepositoryImpl(
	private val localDataSource: LoginLocalDataSource,
	private val remoteDataSource: LoginRemoteDataSource
) {
}