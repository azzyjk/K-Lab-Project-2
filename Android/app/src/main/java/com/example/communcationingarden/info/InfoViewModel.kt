package com.example.communcationingarden.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.data.GardenInfo

class InfoViewModel : ViewModel() {
	
	private val _selectGardenLiveData = MutableLiveData<GardenInfo>()
	val selectGardenInfoLiveData: LiveData<GardenInfo> get() = _selectGardenLiveData
	
	fun setSelectGarden(selectGardenInfo: GardenInfo) {
		_selectGardenLiveData.value = selectGardenInfo
	}
}