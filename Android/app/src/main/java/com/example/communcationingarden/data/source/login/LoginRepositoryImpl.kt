package com.example.communcationingarden.data.source.login

import com.example.communcationingarden.data.Position
import com.example.communcationingarden.data.SignInInfo
import com.example.communcationingarden.data.SignUpInfo
import com.example.communcationingarden.data.source.login.local.LoginLocalDataSource
import com.example.communcationingarden.data.source.login.remote.LoginRemoteDataSource
import com.example.communcationingarden.network.GardenListResponse
import com.example.communcationingarden.network.SignInResponse
import com.example.communcationingarden.network.SignUpResponse

class LoginRepositoryImpl(
	private val localDataSource: LoginLocalDataSource,
	private val remoteDataSource: LoginRemoteDataSource
) : LoginRepository {
	
	override suspend fun requestSignUp(signUpInfo: SignUpInfo): Result<SignUpResponse> {
		return remoteDataSource.requestSignUp(signUpInfo)
	}
	
	override suspend fun requestSignIn(signInInfo: SignInInfo): Result<SignInResponse> {
		return remoteDataSource.requestSignIn(signInInfo)
	}
	
	override suspend fun requestGardenList(userPosition: Position): Result<GardenListResponse> {
		return remoteDataSource.requestGardenList(userPosition)
	}
}