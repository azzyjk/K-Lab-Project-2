package com.example.communcationingarden.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.communcationingarden.data.GardenInfo
import com.example.communcationingarden.databinding.FragmentInfoBinding
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class InfoFragment : Fragment() {
	
	private var _binding: FragmentInfoBinding? = null
	private val binding get() = _binding!!
	private val infoViewModel: InfoViewModel by viewModels()
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentInfoBinding.inflate(layoutInflater, container, false).apply {
			viewModel = infoViewModel
			lifecycleOwner = viewLifecycleOwner
		}
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setSelectGarden()
	}
	
	private fun setSelectGarden() {
		arguments?.let { bundle ->
			val selectGardenJson = bundle.getString("selectGarden")!!
			val selectGarden = Json.decodeFromString<GardenInfo>(selectGardenJson)
			infoViewModel.setSelectGarden(selectGarden)
		}
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}