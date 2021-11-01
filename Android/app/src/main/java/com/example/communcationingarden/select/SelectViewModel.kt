package com.example.communcationingarden.select

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.Event
import com.example.communcationingarden.data.Position

class SelectViewModel : ViewModel() {

	private val _mainScreenEvent = MutableLiveData<Event<Unit>>()
	val mainScreenEvent: LiveData<Event<Unit>> = _mainScreenEvent
	private var _userPositionLiveData = Position()
	val userPositionLiveData get() = _userPositionLiveData

	fun openMainScreen() {
		_mainScreenEvent.value = Event(Unit)
	}

	fun setUserPosition(position: Position) {
		_userPositionLiveData = position
	}
}