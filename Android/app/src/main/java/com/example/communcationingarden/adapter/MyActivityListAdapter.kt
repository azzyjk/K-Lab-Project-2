package com.example.communcationingarden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.databinding.ItemMyActivityListBinding
import com.example.communcationingarden.home.HomeViewModel

class MyActivityListAdapter(
	private val homeViewModel: HomeViewModel
) :
	RecyclerView.Adapter<MyActivityListAdapter.CommunityActivityViewHolder>() {
	
	private var activityList = listOf<ActivityInfo>()
	
	class CommunityActivityViewHolder(
		private val binding: ItemMyActivityListBinding,
		private val homeViewModel: HomeViewModel
	):
		RecyclerView.ViewHolder(binding.root) {
		
		fun setup(activity: ActivityInfo) {
			binding.activity = activity
			binding.viewModel = homeViewModel
			binding.executePendingBindings()
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityActivityViewHolder {
		val binding =
			ItemMyActivityListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return CommunityActivityViewHolder(binding, homeViewModel)
	}
	
	override fun onBindViewHolder(holder: CommunityActivityViewHolder, position: Int) {
		holder.setup(activityList[position])
	}
	
	override fun getItemCount(): Int = activityList.size
	
	fun updateActivityList(newActivityList: List<ActivityInfo>) {
		activityList = newActivityList
		notifyDataSetChanged()
	}
}
