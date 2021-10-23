package com.example.communcationingarden.select

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.communcationingarden.adapter.GardenListAdapter
import com.example.communcationingarden.data.Garden
import com.example.communcationingarden.databinding.FragmentSelectBinding

class SelectFragment : Fragment() {

	private var _binding: FragmentSelectBinding? = null
	private val binding get() = _binding!!
	private val selectViewModel: SelectViewModel by activityViewModels()
	private val onClick: () -> Unit = {
		selectViewModel.openMainScreen()
	}
	private val gardenListAdapter = GardenListAdapter(onClick)

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentSelectBinding.inflate(layoutInflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		dummyAdapterItem()
		initView()
	}

	private fun dummyAdapterItem() {
		gardenListAdapter.updateGardenList(
			listOf(
				Garden("TEST1", 2.2),
				Garden("TEST2", 2.2),
				Garden("TEST3", 2.2),
				Garden("TEST4", 2.2),
				Garden("TEST5", 2.2)
			)
		)
	}

	private fun initView() = with(binding) {
		gardenListRecyclerView.adapter = gardenListAdapter
		gardenListRecyclerView.addItemDecoration(
			DividerItemDecoration(
				requireContext(),
				LinearLayoutManager.VERTICAL
			)
		)
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}