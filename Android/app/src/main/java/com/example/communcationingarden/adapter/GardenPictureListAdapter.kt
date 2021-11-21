package com.example.communcationingarden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.communcationingarden.data.GardenPicture
import com.example.communcationingarden.databinding.ItemSnsListBinding

class GardenPictureListAdapter(
    private val pictureOnClick: (GardenPicture) -> Unit
): RecyclerView.Adapter<GardenPictureListAdapter.SnsViewHolder>() {
    
    private var gardenPictureList = listOf<GardenPicture>()
    
    class SnsViewHolder(
        private val binding: ItemSnsListBinding,
        private val pictureOnClick: (GardenPicture) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        
        init {
            binding.root.setOnClickListener {
                binding.gardenPicture?.let { gardenPicture ->
                    pictureOnClick(gardenPicture)
                }
                
            }
        }
        
        fun setup(gardenPicture: GardenPicture) {
            binding.gardenPicture = gardenPicture
            binding.executePendingBindings()
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnsViewHolder {
        val binding = ItemSnsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SnsViewHolder(binding, pictureOnClick)
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
