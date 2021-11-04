package com.example.communcationingarden.select

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.communcationingarden.EventObserver
import com.example.communcationingarden.R
import com.example.communcationingarden.adapter.GardenListAdapter
import com.example.communcationingarden.data.Garden
import com.example.communcationingarden.data.Position
import com.example.communcationingarden.databinding.FragmentSelectBinding
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SelectFragment : Fragment() {
	
	private var _binding: FragmentSelectBinding? = null
	private val binding get() = _binding!!
	private val selectViewModel: SelectViewModel by viewModels()
	private lateinit var locationManager: LocationManager
	private lateinit var navigationController: NavController
	private val onClick: () -> Unit = {
		selectViewModel.openMainScreen()
	}
	private val gardenListAdapter = GardenListAdapter(onClick)
	// TODO:해당 부분 수정
	private val locationPermissionRequest =
		registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
			when {
				permissions.getOrDefault(
					Manifest.permission.ACCESS_FINE_LOCATION,
					false
				) && permissions.getOrDefault(
					Manifest.permission.ACCESS_COARSE_LOCATION,
					false
				) -> {
					getUserCurrentLocation()
				}
				else -> {
				}
			}
		}
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentSelectBinding.inflate(layoutInflater, container, false)
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		dummyAdapterItem()
		initView()
		initObserver()
		checkLocationPermission()
	}
	@SuppressLint("MissingPermission")
	private fun getUserCurrentLocation() {
		val userLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
		userLocation?.let { location ->
			val latitude = location.latitude
			val longitude = location.longitude
			selectViewModel.setUserPosition(Position(latitude, longitude))
		}
	}
	
	private fun checkLocationPermission() {
		locationPermissionRequest.launch(
			arrayOf(
				Manifest.permission.ACCESS_FINE_LOCATION,
				Manifest.permission.ACCESS_COARSE_LOCATION
			)
		)
	}
	
	private fun initObserver() = with(selectViewModel) {
		mainScreenEvent.observe(viewLifecycleOwner, EventObserver {
			val userPositionJson = Json.encodeToString(selectViewModel.userPositionLiveData)
			val bundle = bundleOf("userPosition" to userPositionJson)
			navigationController.navigate(R.id.infoActivity, bundle)
		})
	}
	
	private fun dummyAdapterItem() {
		gardenListAdapter.updateGardenList(
			listOf(
				Garden("TEST1", 2.2),
				Garden("TEST2", 2.2),
				Garden("TEST3", 2.2),
				Garden("TEST4", 2.2),
				Garden("TEST5", 2.2)
			)
		)
	}
	
	private fun initView() = with(binding) {
		gardenListRecyclerView.adapter = gardenListAdapter
		gardenListRecyclerView.addItemDecoration(
			DividerItemDecoration(
				requireContext(),
				LinearLayoutManager.VERTICAL
			)
		)
		navigationController = findNavController()
		locationManager =
			requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}