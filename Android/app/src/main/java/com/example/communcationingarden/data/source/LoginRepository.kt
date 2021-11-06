package com.example.communcationingarden.data.source

import com.example.communcationingarden.data.Position
import com.example.communcationingarden.data.SignInInfo
import com.example.communcationingarden.data.SignUpInfo
import com.example.communcationingarden.network.GardenListResponse
import com.example.communcationingarden.network.SignInResponse
import com.example.communcationingarden.network.SignUpResponse

interface LoginRepository {
	
	suspend fun requestSignUp(signUpInfo: SignUpInfo): Result<SignUpResponse>
	
	suspend fun requestSignIn(signInInfo: SignInInfo): Result<SignInResponse>
	
	suspend fun requestGardenList(userPosition: Position): Result<GardenListResponse>
}