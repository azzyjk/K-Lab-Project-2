package com.example.communcationingarden.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.communcationingarden.databinding.FragmentLoginBinding
import com.example.communcationingarden.login.model.LoginViewModel

class LoginFragment : Fragment() {

	private var _binding: FragmentLoginBinding? = null
	private val binding get() = _binding!!
	private val loginViewModel: LoginViewModel by activityViewModels()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentLoginBinding.inflate(layoutInflater, container, false).apply {
			viewModel = loginViewModel
		}
		return binding.root
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}