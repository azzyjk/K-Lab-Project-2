package com.example.communcationingarden.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.communcationingarden.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
	
	private var _binding: FragmentInfoBinding? = null
	private val binding get() = _binding!!
	private val infoViewModel: InfoViewModel by activityViewModels()
	
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
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}