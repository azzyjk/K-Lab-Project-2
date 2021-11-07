package com.example.communcationingarden.info

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.communcationingarden.R
import com.example.communcationingarden.ViewModelFactory
import com.example.communcationingarden.data.GardenInfo
import com.example.communcationingarden.databinding.ActivityInfoBinding
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class InfoActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivityInfoBinding
	private lateinit var navigationController: NavController
	private val infoViewModel: InfoViewModel by viewModels {
		ViewModelFactory(this)
	}
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityInfoBinding.inflate(layoutInflater)
		setContentView(binding.root)
		setSupportActionBar(binding.toolBar)
		initView()
		setUserInfo()
	}
	
	private fun setUserInfo() {
		intent.extras?.let { bundle ->
			val userId = bundle.getString("userId")!!
			val selectGardenJson = bundle.getString("selectGarden")!!
			val selectGarden = Json.decodeFromString<GardenInfo>(selectGardenJson)
			infoViewModel.setSelectGarden(selectGarden)
			infoViewModel.setUserId(userId)
		}
	}
	
	private fun initView() {
		val navigationHostFragment =
			supportFragmentManager.findFragmentById(R.id.info_navHostFragment) as NavHostFragment
		navigationController = navigationHostFragment.findNavController()
		binding.bottomNavigation.setupWithNavController(navigationController)
	}
}
