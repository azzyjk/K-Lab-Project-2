package com.example.communcationingarden.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.communcationingarden.ViewModelFactory
import com.example.communcationingarden.adapter.CommunityActivityListAdapter
import com.example.communcationingarden.databinding.FragmentCommunityBinding

class CommunityFragment : Fragment() {
	
	private var _binding: FragmentCommunityBinding? = null
	private val binding get() = _binding!!
	private val communityViewModel: CommunityViewModel by viewModels {
		ViewModelFactory(requireContext())
	}
	private val activityListAdapter = CommunityActivityListAdapter()
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentCommunityBinding.inflate(layoutInflater, container, false)
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initView()
		initObserve()
		communityViewModel.loadActivityList()
	}
	
	private fun initView() = with(binding) {
		communityActivityRecyclerView.adapter = activityListAdapter
	}
	
	private fun initObserve() = with(communityViewModel) {
		activityListLiveData.observe(viewLifecycleOwner) { activityList ->
			activityListAdapter.updateActivityList(activityList)
		}
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}