package com.example.communcationingarden.community

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.source.info.InfoRepository

class CommunityViewModel(private val infoRepository: InfoRepository) : ViewModel() {
	
	private val _activityListLiveData = MutableLiveData<List<ActivityInfo>>()
	val activityListLiveData get() = _activityListLiveData
	
	fun loadActivityList() {
	}
}