package com.example.communcationingarden.data.source.login

import com.example.communcationingarden.data.SignInInfo
import com.example.communcationingarden.data.SignUpInfo
import com.example.communcationingarden.network.SignInResponse
import com.example.communcationingarden.network.SignUpResponse

interface LoginDataSource {
    interface Local {
    
    }
    
    interface Remote {
        
        suspend fun requestSignUp(
            signUpInfo: SignUpInfo
        ): Result<SignUpResponse>
        
        suspend fun requestSignIn(
            signInInfo: SignInInfo
        ): Result<SignInResponse>
    }
}
