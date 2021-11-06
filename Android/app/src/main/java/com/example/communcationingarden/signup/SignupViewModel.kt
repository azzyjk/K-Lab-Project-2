package com.example.communcationingarden.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.Event
import com.example.communcationingarden.data.source.LoginRepository

class SignupViewModel(
	private val loginRepository: LoginRepository
) : ViewModel() {
	
	private val _loginScreenEvent = MutableLiveData<Event<Unit>>()
	val loginScreenEvent: LiveData<Event<Unit>> = _loginScreenEvent
	
	fun openLoginScreen() {
		_loginScreenEvent.value = Event(Unit)
	}
}