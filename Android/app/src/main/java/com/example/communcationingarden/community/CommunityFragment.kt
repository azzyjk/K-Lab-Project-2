package com.example.communcationingarden.community

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.communcationingarden.R
import com.example.communcationingarden.adapter.CommunityActivityListAdapter
import com.example.communcationingarden.data.RegistActivityInfo
import com.example.communcationingarden.databinding.FragmentCommunityBinding
import com.example.communcationingarden.home.HomeViewModel

class CommunityFragment : Fragment() {
	
	private var _binding: FragmentCommunityBinding? = null
	private val binding get() = _binding!!
	private val homeViewModel: HomeViewModel by activityViewModels()
	private lateinit var activityListAdapter: CommunityActivityListAdapter
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setHasOptionsMenu(true)
	}
	
	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		super.onCreateOptionsMenu(menu, inflater)
		inflater.inflate(R.menu.community_menu, menu)
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			R.id.action_add -> {
				showAddDialog()
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}
	
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
		homeViewModel.loadActivityList()
	}
	
	private fun initView() = with(binding) {
		activityListAdapter = CommunityActivityListAdapter(homeViewModel)
		communityActivityRecyclerView.adapter = activityListAdapter
	}
	
	private fun initObserve() = with(homeViewModel) {
		activityListLiveData.observe(viewLifecycleOwner) { activityList ->
			activityListAdapter.updateActivityList(activityList)
		}
	}
	
	private fun showAddDialog() {
		val dialog = AddDialogFragment()
		dialog.listener = object: AddDialogFragment.NoticeDialogListener {
			override fun onDialogPositiveClick(registActivityInfo: RegistActivityInfo) {
				homeViewModel.requestRegistActivity(registActivityInfo)
			}
		}
		dialog.show(childFragmentManager, "ADD_DIALOG")
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}
