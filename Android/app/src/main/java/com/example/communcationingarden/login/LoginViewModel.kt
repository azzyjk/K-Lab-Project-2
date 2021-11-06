package com.example.communcationingarden.login.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.communcationingarden.Event
import com.example.communcationingarden.data.SignInInfo
import com.example.communcationingarden.data.source.login.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(val loginRepository: LoginRepository) : ViewModel() {
	
	private val _signupScreenEvent = MutableLiveData<Event<Unit>>()
	val signupScreenEvent: LiveData<Event<Unit>> = _signupScreenEvent
	private val _selectScreenEvent = MutableLiveData<Event<Unit>>()
	val selectScreenEvent: LiveData<Event<Unit>> = _selectScreenEvent
	private val _signInFailEvent = MutableLiveData<Event<Unit>>()
	val signInFailEvent: LiveData<Event<Unit>> get() = _signInFailEvent
	val idLiveData = MutableLiveData<String>()
	val passwordLiveData = MutableLiveData<String>()
	
	fun requestSignIn() = viewModelScope.launch {
		loginRepository.requestSignIn(
			SignInInfo(
				idLiveData.value!!,
				passwordLiveData.value!!
			)
		).onSuccess {
			if (it.name.isEmpty()) _signInFailEvent.value = Event(Unit)
			else openSelectScreen()
		}
	}
	
	fun openSignupScreen() {
		_signupScreenEvent.value = Event(Unit)
	}
	
	fun openSelectScreen() {
		_selectScreenEvent.value = Event(Unit)
	}
}
