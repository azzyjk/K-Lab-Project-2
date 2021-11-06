package com.example.communcationingarden.login.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.Event
import com.example.communcationingarden.data.source.LoginRepository

class LoginViewModel(loginRepository: LoginRepository) : ViewModel() {
	
	private val _signupScreenEvent = MutableLiveData<Event<Unit>>()
	val signupScreenEvent: LiveData<Event<Unit>> = _signupScreenEvent
	private val _selectScreenEvent = MutableLiveData<Event<Unit>>()
	val selectScreenEvent: LiveData<Event<Unit>> = _selectScreenEvent
	
	fun openSignupScreen() {
		_signupScreenEvent.value = Event(Unit)
	}
	
	fun openSelectScreen() {
		_selectScreenEvent.value = Event(Unit)
	}
}
