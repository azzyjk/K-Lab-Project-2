package com.example.communcationingarden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.communcationingarden.data.GardenPicture
import com.example.communcationingarden.databinding.ItemSnsListBinding

class GardenPictureListAdapter: RecyclerView.Adapter<GardenPictureListAdapter.SnsViewHolder>() {
    
    private var gardenPictureList = listOf<GardenPicture>()
    
    class SnsViewHolder(val binding: ItemSnsListBinding): RecyclerView.ViewHolder(binding.root) {
        
        fun setup(gardenPicture: GardenPicture) {
            binding.gardenPicture = gardenPicture
            binding.executePendingBindings()
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnsViewHolder {
        val binding = ItemSnsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SnsViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: SnsViewHolder, position: Int) {
        holder.setup(gardenPictureList[position])
    }
    
    override fun getItemCount(): Int = gardenPictureList.size
    
    fun updateSnsInfoList(newGardenPictureList: List<GardenPicture>) {
        gardenPictureList = newGardenPictureList
        notifyDataSetChanged()
    }
}
