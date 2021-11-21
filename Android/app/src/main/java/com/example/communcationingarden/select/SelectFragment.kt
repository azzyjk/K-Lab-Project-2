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
import com.example.communcationingarden.data.GardenInfo
import com.example.communcationingarden.data.Position
import com.example.communcationingarden.databinding.FragmentSelectBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@AndroidEntryPoint
class SelectFragment: Fragment() {
    
    private var _binding: FragmentSelectBinding? = null
    private val binding get() = _binding!!
    private val selectViewModel: SelectViewModel by viewModels()
    private lateinit var locationManager: LocationManager
    private lateinit var navigationController: NavController
    private val onClick: (GardenInfo) -> Unit = {
        selectViewModel.selectGarden(it)
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
            selectViewModel.loadGardenList()
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
            val userId = requireArguments().getString("userId")
            val selectGardenInfoJson = Json.encodeToString(selectViewModel.selectGarden)
            val bundle = bundleOf(
                "selectGarden" to selectGardenInfoJson,
                "userId" to userId
            )
            navigationController.navigate(R.id.homeActivity, bundle)
        })
        gardenListLiveData.observe(viewLifecycleOwner) { gardenList ->
            gardenListAdapter.updateGardenList(gardenList)
        }
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
