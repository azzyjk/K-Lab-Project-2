package com.example.communcationingarden.data.source.login

import com.example.communcationingarden.data.SignInInfo
import com.example.communcationingarden.data.SignUpInfo
import com.example.communcationingarden.data.source.login.remote.LoginRemoteDataSource
import com.example.communcationingarden.network.SignInResponse
import com.example.communcationingarden.network.SignUpResponse
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val remoteDataSource: LoginRemoteDataSource
): LoginRepository {
    
    override suspend fun requestSignUp(
        signUpInfo: SignUpInfo
    ): Result<SignUpResponse> {
        return remoteDataSource.requestSignUp(
            signUpInfo
        )
    }
    
    override suspend fun requestSignIn(
        signInInfo: SignInInfo
    ): Result<SignInResponse> {
        return remoteDataSource.requestSignIn(
            signInInfo
        )
    }
}
