package com.c_od_e.pagination.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.c_od_e.pagination.R
import com.c_od_e.pagination.databinding.ItemCatBinding
import com.c_od_e.pagination.model.Cat

class CatViewHolder(private val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Cat?) {
        binding.imageCat.load(item?.url) {
            placeholder(R.drawable.ic_launcher_background)
        }
    }

    companion object {
        fun create(view: ViewGroup): CatViewHolder {
            val inflater = LayoutInflater.from(view.context)
            val binding = ItemCatBinding.inflate(inflater, view, false)
            return CatViewHolder(binding)
        }
    }
}