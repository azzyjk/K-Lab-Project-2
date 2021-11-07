package com.example.communcationingarden.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.communcationingarden.adapter.CommunityActivityListAdapter
import com.example.communcationingarden.databinding.FragmentCommunityBinding
import com.example.communcationingarden.info.InfoViewModel

class CommunityFragment : Fragment() {
	
	private var _binding: FragmentCommunityBinding? = null
	private val binding get() = _binding!!
	private val infoViewModel: InfoViewModel by activityViewModels()
	private lateinit var activityListAdapter: CommunityActivityListAdapter
	
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
		infoViewModel.loadActivityList()
	}
	
	private fun initView() = with(binding) {
		activityListAdapter = CommunityActivityListAdapter(infoViewModel)
		communityActivityRecyclerView.adapter = activityListAdapter
	}
	
	private fun initObserve() = with(infoViewModel) {
		activityListLiveData.observe(viewLifecycleOwner) { activityList ->
			activityListAdapter.updateActivityList(activityList)
		}
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}