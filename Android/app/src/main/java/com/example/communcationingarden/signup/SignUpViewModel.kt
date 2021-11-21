package com.example.communcationingarden.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.communcationingarden.Event
import com.example.communcationingarden.data.SignUpInfo
import com.example.communcationingarden.data.source.login.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
	private val loginRepository: LoginRepository
): ViewModel() {
	
	private val _loginScreenEvent = MutableLiveData<Event<Unit>>()
	val loginScreenEvent: LiveData<Event<Unit>> = _loginScreenEvent
	private val _signUpSuccessEvent = MutableLiveData<Event<Unit>>()
	val signUpSuccessEvent: LiveData<Event<Unit>> = _signUpSuccessEvent
	private val _signUpFailEvent = MutableLiveData<Event<Unit>>()
	val signUpFailEvent: LiveData<Event<Unit>> = _signUpFailEvent
	val idLiveData = MutableLiveData<String>()
	val passwordLiveData = MutableLiveData<String>()
	val nameLiveData = MutableLiveData<String>()
	
	fun requestSignUp() = viewModelScope.launch {
		loginRepository.requestSignUp(
			SignUpInfo(
				idLiveData.value!!,
				passwordLiveData.value!!,
				nameLiveData.value!!
			)
		).onSuccess {
			println(it)
			if (it.result == "pass") {
				_signUpSuccessEvent.value = Event(Unit)
				openLoginScreen()
			}
			if (it.result == "fail") _signUpFailEvent.value = Event(Unit)
		}
	}
	
	private fun openLoginScreen() {
		_loginScreenEvent.value = Event(Unit)
	}
}
