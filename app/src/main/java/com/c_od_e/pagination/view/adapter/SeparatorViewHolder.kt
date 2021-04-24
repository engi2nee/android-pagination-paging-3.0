package com.c_od_e.pagination.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c_od_e.pagination.databinding.ItemSeperatorBinding

class SeparatorViewHolder(private val binding: ItemSeperatorBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(separatorText: String) {
        binding.separatorDescription.text = separatorText.toUpperCase()
    }

    companion object {
        fun create(view: ViewGroup): SeparatorViewHolder {
            val inflater = LayoutInflater.from(view.context)
            val binding = ItemSeperatorBinding.inflate(inflater, view, false)
            return SeparatorViewHolder(binding)
        }
    }
}