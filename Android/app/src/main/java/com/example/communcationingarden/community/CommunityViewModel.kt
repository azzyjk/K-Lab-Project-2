package com.example.communcationingarden.community

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.data.ActivityInfo

class CommunityViewModel : ViewModel() {
	
	private val _activityListLiveData = MutableLiveData<List<ActivityInfo>>()
	val activityListLiveData get() = _activityListLiveData
	
	fun loadActivityList() {
		_activityListLiveData.value = listOf(
			ActivityInfo("Hello", "2021-05-05 18:00"),
			ActivityInfo("Hello", "2021-05-05 18:00"),
			ActivityInfo("Hello", "2021-05-05 18:00"),
		)
	}
}