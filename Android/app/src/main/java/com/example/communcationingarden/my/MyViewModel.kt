package com.example.communcationingarden.my

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.data.ActivityInfo

class MyViewModel : ViewModel() {
	
	private val _myActivityListLiveData = MutableLiveData<List<ActivityInfo>>()
	val myActivityListLiveData get() = _myActivityListLiveData
	
	fun loadMyActivity() {
		_myActivityListLiveData.value = listOf(ActivityInfo("Hello", "2021-05-05 18:00"))
	}
}