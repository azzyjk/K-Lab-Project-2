package com.example.communcationingarden.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.communcationingarden.adapter.MyActivityListAdapter
import com.example.communcationingarden.databinding.FragmentMyBinding

class MyFragment : Fragment() {
	
	private var _binding: FragmentMyBinding? = null
	private val binding get() = _binding!!
	private val myViewModel: MyViewModel by viewModels()
	private val myActivityListAdapter = MyActivityListAdapter()
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentMyBinding.inflate(layoutInflater, container, false)
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initView()
		initObserve()
		myViewModel.loadMyActivity()
	}
	
	private fun initView() = with(binding) {
		myActivityRecyclerView.adapter = myActivityListAdapter
	}
	
	private fun initObserve() = with(myViewModel) {
		myActivityListLiveData.observe(viewLifecycleOwner) { myActivityList ->
			myActivityListAdapter.updateActivityList(myActivityList)
		}
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}