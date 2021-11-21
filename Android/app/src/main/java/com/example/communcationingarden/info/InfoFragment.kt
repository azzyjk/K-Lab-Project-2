package com.example.communcationingarden.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.communcationingarden.EventObserver
import com.example.communcationingarden.R
import com.example.communcationingarden.adapter.GardenPictureListAdapter
import com.example.communcationingarden.data.GardenPicture
import com.example.communcationingarden.databinding.FragmentInfoBinding
import com.example.communcationingarden.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@AndroidEntryPoint
class InfoFragment: Fragment() {
    
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by activityViewModels()
    private val infoListAdapter by lazy {
        GardenPictureListAdapter(pictureOnClick)
    }
    private val pictureOnClick: (GardenPicture) -> Unit = { gardenPicture ->
        homeViewModel.openInfoDetailScreen(gardenPicture)
    }
    private val navigationController by lazy {
        findNavController()
    }
    
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
        homeViewModel.loadGardenPictureList()
    }
    
    private fun initView() = with(binding) {
        gardenPictureRecyclerView.adapter = infoListAdapter
        gardenPictureRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
            }
    }
    
    private fun initObserve() = with(homeViewModel) {
        gardenPictureListLiveData.observe(viewLifecycleOwner) { gardenPictureList ->
            infoListAdapter.updateSnsInfoList(gardenPictureList)
        }
    
        infoDetailEvent.observe(viewLifecycleOwner, EventObserver { gardenPicture ->
            val gardenPictureJson = Json.encodeToString(gardenPicture)
            val bundle = bundleOf(
                "gardenPicture" to gardenPictureJson
            )
            navigationController.navigate(R.id.infoDetailFragment, bundle)
        })
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
