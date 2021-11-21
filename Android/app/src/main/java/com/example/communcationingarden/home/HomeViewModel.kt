package com.example.communcationingarden.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.GardenInfo
import com.example.communcationingarden.data.RegistActivityInfo
import com.example.communcationingarden.data.SnsInfo
import com.example.communcationingarden.data.source.activity.ActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val activityRepository: ActivityRepository
): ViewModel() {
    
    private val _selectGardenLiveData = MutableLiveData<GardenInfo>()
    val selectGardenInfoLiveData: LiveData<GardenInfo> get() = _selectGardenLiveData
    
    private val _activityListLiveData = MutableLiveData<List<ActivityInfo>>()
    val activityListLiveData get() = _activityListLiveData
    
    private val _myActivityListLiveData = MutableLiveData<List<ActivityInfo>>()
    val myActivityListLiveData get() = _myActivityListLiveData
    
    private val _gardenPictureListLiveData = MutableLiveData<List<SnsInfo>>()
    val gardenPictureListLiveData get() = _gardenPictureListLiveData
    
    private var userId: String? = null
    
    fun setSelectGarden(selectGardenInfo: GardenInfo) {
        _selectGardenLiveData.value = selectGardenInfo
    }
    
    fun setUserId(userId: String) {
        this.userId = userId
    }
    
    fun loadActivityList() = viewModelScope.launch {
        _selectGardenLiveData.value?.let { gardenInfo ->
            activityRepository.getAllActivityList(gardenInfo.name)
                .onSuccess { response ->
                    _activityListLiveData.value = response.activityList
                }
        }
    }
    
    fun loadMyActivity() = viewModelScope.launch {
        activityRepository.getUserActivityList(userId!!, _selectGardenLiveData.value!!.name)
            .onSuccess { response ->
                _myActivityListLiveData.value = response.activityList
            }
    }
    
    fun loadSnsList() = viewModelScope.launch {
    
    }
    
    fun requestParticipate(activityInfo: ActivityInfo) = viewModelScope.launch {
        activityRepository.requestParticipateActivity(userId!!, activityInfo)
            .onSuccess {
                loadActivityList()
            }
    }
    
    fun requestExitActivity(activityInfo: ActivityInfo) = viewModelScope.launch {
        activityRepository.requestExitActivity(userId!!, activityInfo)
            .onSuccess {
                loadMyActivity()
            }
    }
    
    fun requestRegistActivity(registActivityInfo: RegistActivityInfo) = viewModelScope.launch {
        activityRepository.requestRegistActivity(
            userId!!,
            _selectGardenLiveData.value!!.name,
            registActivityInfo
        )
            .onSuccess {
                loadActivityList()
            }
    }
}
