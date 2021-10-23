package com.example.communcationingarden.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.Event

class SignupViewModel : ViewModel() {

	private val _loginScreenEvent = MutableLiveData<Event<Unit>>()
	val loginScreenEvent: LiveData<Event<Unit>> = _loginScreenEvent

	fun openLoginScreen() {
		println("Hello")
		_loginScreenEvent.value = Event(Unit)
	}
}