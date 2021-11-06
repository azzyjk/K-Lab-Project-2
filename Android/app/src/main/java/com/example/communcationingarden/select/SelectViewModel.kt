package com.example.communcationingarden.select

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.communcationingarden.Event
import com.example.communcationingarden.data.GardenInfo
import com.example.communcationingarden.data.Position
import com.example.communcationingarden.data.source.LoginRepository
import kotlinx.coroutines.launch

class SelectViewModel(private val loginRepository: LoginRepository) : ViewModel() {
	
	private val _mainScreenEvent = MutableLiveData<Event<Unit>>()
	val mainScreenEvent: LiveData<Event<Unit>> = _mainScreenEvent
	private val _gardenListLiveData = MutableLiveData<List<GardenInfo>>()
	val gardenListLiveData: LiveData<List<GardenInfo>> get() = _gardenListLiveData
	private var _userPosition = Position()
	val userPosition get() = _userPosition
	
	fun loadGardenList() = viewModelScope.launch {
		println("Hello")
		println(_userPosition)
		loginRepository.requestGardenList(_userPosition)
			.onSuccess {
				_gardenListLiveData.value = it.gardenList
			}.onFailure {
				println(it)
			}
	}
	
	fun openMainScreen() {
		_mainScreenEvent.value = Event(Unit)
	}
	
	fun setUserPosition(position: Position) {
		_userPosition = position
	}
}