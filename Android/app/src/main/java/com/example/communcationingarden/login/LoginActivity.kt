package com.example.communcationingarden.login

import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.communcationingarden.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

	private lateinit var binding: ActivityLoginBinding
	private lateinit var locationManager: LocationManager

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}
}

