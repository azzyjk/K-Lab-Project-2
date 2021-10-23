package com.example.communcationingarden.login.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.Event

class LoginViewModel : ViewModel() {

	private val _mainScreenEvent = MutableLiveData<Event<Unit>>()
	val mainScreenEvent: LiveData<Event<Unit>> = _mainScreenEvent

	fun openMainScreen() {
		_mainScreenEvent.value = Event(Unit)
	}
}
