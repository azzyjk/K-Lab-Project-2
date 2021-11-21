package com.example.communcationingarden.infodetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.communcationingarden.data.GardenPicture
import com.example.communcationingarden.databinding.FragmentInfoDetailBinding
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class InfoDetailFragment: Fragment() {
    
    private var _binding: FragmentInfoDetailBinding? = null
    private val binding get() = _binding!!
    private val infoDetailViewModel: InfoDetailViewModel by viewModels()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }
    
    private fun initViewModel() {
        arguments?.let { bundle ->
            val json = bundle.getString("gardenPicture")!!
            val gardenPicture = Json.decodeFromString<GardenPicture>(json)
            infoDetailViewModel.initViewModel(gardenPicture)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
