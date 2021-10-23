package com.example.communcationingarden.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.communcationingarden.EventObserver
import com.example.communcationingarden.databinding.ActivityLoginBinding
import com.example.communcationingarden.info.MainActivity
import com.example.communcationingarden.select.SelectViewModel

class LoginActivity : AppCompatActivity() {

	private lateinit var binding: ActivityLoginBinding
	private val selectViewModel: SelectViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)
		initObserve()
	}

	private fun initObserve() = with(selectViewModel) {
		mainScreenEvent.observe(this@LoginActivity, EventObserver {
			startMainScreen()
		})
	}

	private fun startMainScreen() {
		val intent = Intent(this, MainActivity::class.java)
		startActivity(intent)
	}
}
