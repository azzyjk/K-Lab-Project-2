package com.example.communcationingarden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.databinding.ItemCommunityActivityBinding

class CommunityActivityListAdapter :
	RecyclerView.Adapter<CommunityActivityListAdapter.CommunityActivityViewHolder>() {
	
	private var activityList = listOf<ActivityInfo>()
	
	class CommunityActivityViewHolder(val binding: ItemCommunityActivityBinding) :
		RecyclerView.ViewHolder(binding.root) {
		
		fun setup(activity: ActivityInfo) {
			binding.activity = activity
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityActivityViewHolder {
		val binding =
			ItemCommunityActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return CommunityActivityViewHolder(binding)
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