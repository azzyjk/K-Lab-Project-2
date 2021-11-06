package com.example.communcationingarden.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.communcationingarden.EventObserver
import com.example.communcationingarden.R
import com.example.communcationingarden.ViewModelFactory
import com.example.communcationingarden.databinding.FragmentLoginBinding
import com.example.communcationingarden.login.model.LoginViewModel

class LoginFragment : Fragment() {
	
	private var _binding: FragmentLoginBinding? = null
	private val binding get() = _binding!!
	private val loginViewModel: LoginViewModel by viewModels {
		ViewModelFactory(requireContext())
	}
	private lateinit var navigationController: NavController
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentLoginBinding.inflate(layoutInflater, container, false).apply {
			viewModel = loginViewModel
			lifecycleOwner = viewLifecycleOwner
		}
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		navigationController = findNavController()
		initObserve()
	}
	
	private fun initObserve() = with(loginViewModel) {
		signupScreenEvent.observe(viewLifecycleOwner, EventObserver {
			navigationController.navigate(R.id.signupFragment)
		})
		selectScreenEvent.observe(viewLifecycleOwner, EventObserver {
			navigationController.navigate(R.id.selectFragment)
		})
		signInFailEvent.observe(viewLifecycleOwner, EventObserver {
			Toast.makeText(requireContext(), "Failed Sign In...", Toast.LENGTH_SHORT).show()
		})
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}