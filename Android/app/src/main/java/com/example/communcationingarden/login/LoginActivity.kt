package com.example.communcationingarden.login

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.communcationingarden.EventObserver
import com.example.communcationingarden.data.Position
import com.example.communcationingarden.databinding.ActivityLoginBinding
import com.example.communcationingarden.info.InfoActivity
import com.example.communcationingarden.select.SelectViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LoginActivity : AppCompatActivity() {

	private lateinit var binding: ActivityLoginBinding
	private lateinit var locationManager: LocationManager
	private val selectViewModel: SelectViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)
		initObserve()
		initView()
		getUserCurrentLocation()
	}

	private fun initView() {
		locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
	}

	private fun initObserve() = with(selectViewModel) {
		mainScreenEvent.observe(this@LoginActivity, EventObserver {
			startMainScreen()
		})
	}

	private fun startMainScreen() {
		val userPositionJson = Json.encodeToString(selectViewModel.userPositionLiveData)
		val intent = Intent(this, InfoActivity::class.java).apply {
			putExtra("Position", userPositionJson)
		}
		startActivity(intent)
	}

	private fun getUserCurrentLocation() {
		checkLocationPermission()
		val userLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
		userLocation?.let { location ->
			val latitude = location.latitude
			val longitude = location.longitude
			selectViewModel.setUserPosition(Position(latitude, longitude))
		}
	}

	private fun checkLocationPermission() {
		if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			requestPermissions(
				arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
				LOCATION_PERMISSION_REQUEST_CODE
			)
		}
	}

	companion object {

		const val LOCATION_PERMISSION_REQUEST_CODE = 100
	}
}
