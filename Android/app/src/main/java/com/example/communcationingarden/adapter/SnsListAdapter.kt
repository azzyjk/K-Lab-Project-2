package com.example.communcationingarden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.communcationingarden.data.SnsInfo
import com.example.communcationingarden.databinding.ItemSnsListBinding

class SnsListAdapter : RecyclerView.Adapter<SnsListAdapter.SnsViewHolder>() {
	
	private var snsInfoList = listOf<SnsInfo>()
	
	class SnsViewHolder(val binding: ItemSnsListBinding) : RecyclerView.ViewHolder(binding.root) {
		
		fun setup(snsInfo: SnsInfo) {
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnsViewHolder {
		val binding = ItemSnsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return SnsViewHolder(binding)
	}
	
	override fun onBindViewHolder(holder: SnsViewHolder, position: Int) {
		holder.setup(snsInfoList[position])
	}
	
	override fun getItemCount(): Int = snsInfoList.size
	
	fun updateSnsInfoList(newSnsInfoList: List<SnsInfo>) {
		snsInfoList = newSnsInfoList
		notifyDataSetChanged()
	}
}