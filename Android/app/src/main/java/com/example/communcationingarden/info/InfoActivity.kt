package com.example.communcationingarden.info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.communcationingarden.R
import com.example.communcationingarden.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

	private lateinit var binding: ActivityInfoBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityInfoBinding.inflate(layoutInflater)
		setContentView(binding.root)
		setSupportActionBar(binding.toolBar)
	}
}
