package com.example.communcationingarden.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.GardenInfo
import com.example.communcationingarden.data.RegistActivityInfo
import com.example.communcationingarden.data.SnsInfo
import com.example.communcationingarden.data.source.garden.GardenRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val gardenRepository: GardenRepository): ViewModel() {
	
	private val _selectGardenLiveData = MutableLiveData<GardenInfo>()
	val selectGardenInfoLiveData: LiveData<GardenInfo> get() = _selectGardenLiveData
	private val _activityListLiveData = MutableLiveData<List<ActivityInfo>>()
	val activityListLiveData get() = _activityListLiveData
	private val _myActivityListLiveData = MutableLiveData<List<ActivityInfo>>()
	val myActivityListLiveData get() = _myActivityListLiveData
	private val _snsInfoListLiveData = MutableLiveData<List<SnsInfo>>()
	val snsInfoListLiveData get() = _snsInfoListLiveData
	private var userId: String? = null
	
	fun setSelectGarden(selectGardenInfo: GardenInfo) {
		_selectGardenLiveData.value = selectGardenInfo
	}
	
	fun setUserId(userId: String) {
		this.userId = userId
	}
	
	fun loadActivityList() = viewModelScope.launch {
		_selectGardenLiveData.value?.let { gardenInfo ->
			gardenRepository.getAllActivityList(gardenInfo.name)
				.onSuccess { response ->
					_activityListLiveData.value = response.activityList
				}
		}
	}
	
	fun loadMyActivity() = viewModelScope.launch {
		gardenRepository.getUserActivityList(userId!!, _selectGardenLiveData.value!!.name)
			.onSuccess { response ->
				_myActivityListLiveData.value = response.activityList
			}
	}
	
	fun loadSnsList() {
	}
	
	fun requestParticipate(activityInfo: ActivityInfo) = viewModelScope.launch {
		gardenRepository.requestParticipate(userId!!, activityInfo)
			.onSuccess {
				loadActivityList()
			}
	}
	
	fun requestExitActivity(activityInfo: ActivityInfo) = viewModelScope.launch {
		gardenRepository.requestExitActivity(userId!!, activityInfo)
			.onSuccess {
				loadMyActivity()
			}
	}
	
	fun requestRegistActivity(registActivityInfo: RegistActivityInfo) = viewModelScope.launch {
		gardenRepository.requestRegistActivity(
			userId!!,
			_selectGardenLiveData.value!!.name,
			registActivityInfo
		)
			.onSuccess {
				loadActivityList()
			}
	}
}
