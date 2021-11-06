package com.example.communcationingarden.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.communcationingarden.databinding.FragmentMyBinding

class MyFragment : Fragment() {
	
	private var _binding: FragmentMyBinding? = null
	private val binding get() = _binding!!
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentMyBinding.inflate(layoutInflater, container, false)
		return binding.root
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}