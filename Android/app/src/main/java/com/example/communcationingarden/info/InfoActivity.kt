package com.example.communcationingarden.info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.communcationingarden.R
import com.example.communcationingarden.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivityInfoBinding
	private lateinit var navigationController: NavController
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityInfoBinding.inflate(layoutInflater)
		setContentView(binding.root)
		setSupportActionBar(binding.toolBar)
		initView()
		sendSelectGardenInfo()
	}
	
	private fun sendSelectGardenInfo() {
		navigationController.navigate(R.id.infoFragment, intent.extras)
	}
	
	private fun initView() {
		val navigationHostFragment =
			supportFragmentManager.findFragmentById(R.id.info_navHostFragment) as NavHostFragment
		navigationController = navigationHostFragment.findNavController()
		binding.bottomNavigation.setupWithNavController(navigationController)
	}
}
