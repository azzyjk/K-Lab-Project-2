package com.example.communcationingarden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.databinding.ItemCommunityActivityListBinding
import com.example.communcationingarden.info.InfoViewModel

class CommunityActivityListAdapter(
	private val infoViewModel: InfoViewModel
) : RecyclerView.Adapter<CommunityActivityListAdapter.CommunityActivityViewHolder>() {
	
	private var activityList = listOf<ActivityInfo>()
	
	class CommunityActivityViewHolder(
		private val binding: ItemCommunityActivityListBinding,
		private val infoViewModel: InfoViewModel
	) :
		RecyclerView.ViewHolder(binding.root) {
		
		fun setup(activity: ActivityInfo) {
			binding.activity = activity
			binding.viewModel = infoViewModel
			binding.executePendingBindings()
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityActivityViewHolder {
		val binding =
			ItemCommunityActivityListBinding.inflate(
				LayoutInflater.from(parent.context),
				parent,
				false
			)
		return CommunityActivityViewHolder(binding, infoViewModel)
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