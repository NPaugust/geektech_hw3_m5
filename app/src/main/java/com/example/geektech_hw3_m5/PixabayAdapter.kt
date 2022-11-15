package com.example.geektech_hw3_m5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.geektech_hw3_m5.databinding.ItemImageBinding

import com.example.geektech_hw3_m5.model.ImageModel

class PixabayAdapter(val list: List<ImageModel>) :
    RecyclerView.Adapter<PixabayAdapter.PixaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PixaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PixaViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImageModel) {
            binding.imageView.load(imageModel.largeImageURL)
        }


    }
}