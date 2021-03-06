package com.example.communcationingarden.signup

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
import com.example.communcationingarden.databinding.FragmentSignupBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment: Fragment() {
    
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!
    private val signUpViewModel: SignUpViewModel by viewModels()
    private lateinit var navigationController: NavController
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(layoutInflater, container, false).apply {
            viewModel = signUpViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationController = findNavController()
        initObserve()
    }
    
    private fun initObserve() = with(signUpViewModel) {
        loginScreenEvent.observe(viewLifecycleOwner, EventObserver {
            navigationController.navigate(R.id.loginFragment)
        })
        signUpSuccessEvent.observe(viewLifecycleOwner, EventObserver {
            Toast.makeText(requireContext(), "Sign Up Success!!", Toast.LENGTH_SHORT).show()
        })
        signUpFailEvent.observe(viewLifecycleOwner, EventObserver {
            Toast.makeText(requireContext(), "Sign Up Fail..", Toast.LENGTH_SHORT).show()
        })
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
