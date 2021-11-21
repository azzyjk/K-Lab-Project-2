package com.example.communcationingarden.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.communcationingarden.adapter.MyActivityListAdapter
import com.example.communcationingarden.databinding.FragmentMyBinding
import com.example.communcationingarden.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyFragment : Fragment() {
    
    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by activityViewModels()
    private lateinit var myActivityListAdapter: MyActivityListAdapter
    
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
        homeViewModel.loadMyActivity()
    }
    
    private fun initView() = with(binding) {
        myActivityListAdapter = MyActivityListAdapter(homeViewModel)
        myActivityRecyclerView.adapter = myActivityListAdapter
    }
    
    private fun initObserve() = with(homeViewModel) {
        myActivityListLiveData.observe(viewLifecycleOwner) { myActivityList ->
            myActivityListAdapter.updateActivityList(myActivityList)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
