package com.example.communcationingarden.sns

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.communcationingarden.databinding.FragmentSnsBinding

class SnsFragment : Fragment() {
	
	private var _binding: FragmentSnsBinding? = null
	private val binding get() = _binding!!
	private val snsViewModel: SnsViewModel by viewModels()
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentSnsBinding.inflate(layoutInflater, container, false)
		return binding.root
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}