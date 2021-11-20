package com.example.communcationingarden.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.communcationingarden.adapter.SnsListAdapter
import com.example.communcationingarden.databinding.FragmentInfoBinding
import com.example.communcationingarden.home.HomeViewModel

class InfoFragment: Fragment() {
    
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by activityViewModels()
    private val snsListAdapter = SnsListAdapter()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserve()
        homeViewModel.loadSnsList()
    }
    
    private fun initView() = with(binding) {
        snsRecyclerView.adapter = snsListAdapter
    }
    
    private fun initObserve() = with(homeViewModel) {
        snsInfoListLiveData.observe(viewLifecycleOwner) { snsList ->
            snsListAdapter.updateSnsInfoList(snsList)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
