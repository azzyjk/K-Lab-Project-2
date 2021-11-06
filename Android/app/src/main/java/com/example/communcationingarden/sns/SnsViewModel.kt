package com.example.communcationingarden.sns

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.data.SnsInfo

class SnsViewModel : ViewModel() {
	
	private val _snsInfoListLiveData = MutableLiveData<List<SnsInfo>>()
	val snsInfoListLiveData get() = _snsInfoListLiveData
	
	fun loadSnsList() {
		_snsInfoListLiveData.value = listOf(
			SnsInfo("TEST"),
			SnsInfo("TEST"),
			SnsInfo("TEST")
		)
	}
}