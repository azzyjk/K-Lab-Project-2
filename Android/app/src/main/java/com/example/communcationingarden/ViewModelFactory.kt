package com.example.communcationingarden

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.communcationingarden.login.model.LoginViewModel
import com.example.communcationingarden.signup.SignupViewModel
import com.example.communcationingarden.util.Injection

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
	
	override fun <T : ViewModel?> create(modelClass: Class<T>): T = when {
		modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
			LoginViewModel(Injection.provideLoginRepository(context))
		}
		modelClass.isAssignableFrom(SignupViewModel::class.java) -> {
			SignupViewModel(Injection.provideLoginRepository(context))
		}
		else -> {
			throw IllegalArgumentException("Not Defined ViewModel")
		}
	} as T
}