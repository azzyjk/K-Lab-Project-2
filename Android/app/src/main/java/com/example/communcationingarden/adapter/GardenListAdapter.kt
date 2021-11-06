package com.example.communcationingarden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.communcationingarden.data.GardenInfo
import com.example.communcationingarden.databinding.ItemGardenListBinding

class GardenListAdapter(private val onClick: (GardenInfo) -> Unit) :
	RecyclerView.Adapter<GardenListAdapter.GardenViewHolder>() {
	
	private var gardenList: List<GardenInfo> = listOf()
	
	class GardenViewHolder(
		private val binding: ItemGardenListBinding,
		private val onClick: (GardenInfo) -> Unit
	) :
		RecyclerView.ViewHolder(binding.root) {
		
		init {
			binding.root.setOnClickListener {
				binding.garden?.let {
					onClick(it)
				}
			}
		}
		
		fun setup(garden: GardenInfo) {
			binding.garden = garden
			binding.executePendingBindings()
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GardenViewHolder {
		val binding =
			ItemGardenListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return GardenViewHolder(binding, onClick)
	}
	
	override fun onBindViewHolder(holder: GardenViewHolder, position: Int) {
		holder.setup(gardenList[position])
	}
	
	override fun getItemCount(): Int = gardenList.size
	
	fun updateGardenList(newGardenList: List<GardenInfo>) {
		gardenList = newGardenList
		notifyDataSetChanged()
	}
}