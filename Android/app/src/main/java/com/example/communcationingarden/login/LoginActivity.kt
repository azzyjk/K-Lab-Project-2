package com.example.communcationingarden.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.communcationingarden.databinding.ActivityLoginBinding
import com.example.communcationingarden.login.model.LoginViewModel

class LoginActivity : AppCompatActivity() {

	private lateinit var binding: ActivityLoginBinding
	private val loginViewModel: LoginViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}
}
