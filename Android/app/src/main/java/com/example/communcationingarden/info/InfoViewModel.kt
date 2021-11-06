package com.example.communcationingarden.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.GardenInfo
import com.example.communcationingarden.data.SnsInfo
import com.example.communcationingarden.data.source.info.InfoRepository
import kotlinx.coroutines.launch

class InfoViewModel(private val infoRepository: InfoRepository) : ViewModel() {
	
	private val _selectGardenLiveData = MutableLiveData<GardenInfo>()
	val selectGardenInfoLiveData: LiveData<GardenInfo> get() = _selectGardenLiveData
	private val _activityListLiveData = MutableLiveData<List<ActivityInfo>>()
	val activityListLiveData get() = _activityListLiveData
	private val _myActivityListLiveData = MutableLiveData<List<ActivityInfo>>()
	val myActivityListLiveData get() = _myActivityListLiveData
	private val _snsInfoListLiveData = MutableLiveData<List<SnsInfo>>()
	val snsInfoListLiveData get() = _snsInfoListLiveData
	
	fun setSelectGarden(selectGardenInfo: GardenInfo) {
		_selectGardenLiveData.value = selectGardenInfo
	}
	
	fun loadActivityList() = viewModelScope.launch {
		_selectGardenLiveData.value?.let { gardenInfo ->
			infoRepository.getAllActivityList(gardenInfo.name)
				.onSuccess { response ->
					_activityListLiveData.value = response.activityList
				}
		}
	}
	
	fun loadMyActivity() {
		TODO("Not yet implemented")
	}
	
	fun loadSnsList() {
		TODO("Not yet implemented")
	}
}