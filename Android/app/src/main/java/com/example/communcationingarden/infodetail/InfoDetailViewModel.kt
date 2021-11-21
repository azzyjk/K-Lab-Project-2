package com.example.communcationingarden.infodetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.communcationingarden.data.GardenPicture
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoDetailViewModel @Inject constructor(

): ViewModel() {
    
    private val _gardenPictureLiveData = MutableLiveData<GardenPicture>()
    val gardenPictureLiveData: LiveData<GardenPicture> get() = _gardenPictureLiveData
    
    fun initViewModel(gardenPicture: GardenPicture) {
        _gardenPictureLiveData.value = gardenPicture
    }
}
