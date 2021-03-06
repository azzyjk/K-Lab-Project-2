package com.example.communcationingarden.login

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.communcationingarden.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivityLoginBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}
	
	override fun onTouchEvent(event: MotionEvent?): Boolean {
		val inputMethodManager =
			getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
		inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
		return true
	}
}

