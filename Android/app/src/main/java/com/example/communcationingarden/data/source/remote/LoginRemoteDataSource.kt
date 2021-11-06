package com.example.communcationingarden.data.source.remote

import com.example.communcationingarden.data.SignInInfo
import com.example.communcationingarden.data.SignUpInfo
import com.example.communcationingarden.data.source.LoginDataSource
import com.example.communcationingarden.network.KLabRetrofitService
import com.example.communcationingarden.network.SignInResponse
import com.example.communcationingarden.network.SignUpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRemoteDataSource(private val kLabRetrofitService: KLabRetrofitService) :
	LoginDataSource.Remote {
	
	override suspend fun requestSignUp(signUpInfo: SignUpInfo): Result<SignUpResponse> =
		withContext(Dispatchers.IO) {
			kotlin.runCatching {
				val body = HashMap<String, String>().apply {
					put("id", signUpInfo.id)
					put("pw", signUpInfo.password)
					put("name", signUpInfo.name)
				}
				kLabRetrofitService.requestSignUp(body)
			}
		}
	
	override suspend fun requestSignIn(signInInfo: SignInInfo): Result<SignInResponse> =
		withContext(Dispatchers.IO) {
			kotlin.runCatching {
				val body = HashMap<String, String>().apply {
					put("id", signInInfo.id)
					put("pw", signInInfo.password)
				}
				kLabRetrofitService.requestSignIn(body)
			}
		}
}