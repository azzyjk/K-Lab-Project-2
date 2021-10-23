package com.example.communcationingarden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.communcationingarden.data.Garden
import com.example.communcationingarden.databinding.ItemGardenListBinding

class GardenListAdapter(private val onClick: () -> Unit) :
	RecyclerView.Adapter<GardenListAdapter.GardenViewHolder>() {

	private var gardenList: List<Garden> = listOf()

	class GardenViewHolder(
		private val binding: ItemGardenListBinding,
		private val onClick: () -> Unit
	) :
		RecyclerView.ViewHolder(binding.root) {

		init {
			binding.root.setOnClickListener {
				binding.garden?.let {
					onClick()
				}
			}
		}

		fun setup(garden: Garden) {
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

	fun updateGardenList(newGardenList: List<Garden>) {
		gardenList = newGardenList
		notifyDataSetChanged()
	}
}