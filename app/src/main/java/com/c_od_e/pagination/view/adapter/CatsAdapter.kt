package com.c_od_e.pagination.view.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.c_od_e.pagination.model.CatListItem

class CatsAdapter : PagingDataAdapter<CatListItem, RecyclerView.ViewHolder>(COMPARATOR) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is CatListItem.CatItem -> ViewType.CAT.ordinal
            is CatListItem.SeparatorItem -> ViewType.SEPARATOR.ordinal
            null -> throw UnsupportedOperationException("Unexpected View")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ViewType.CAT.ordinal) {
            CatViewHolder.create(parent)
        } else {
            SeparatorViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let {
            when (it) {
                is CatListItem.CatItem -> (holder as? CatViewHolder)?.bind(it.cat)
                is CatListItem.SeparatorItem -> (holder as? SeparatorViewHolder)?.bind(it.letter)
            }
        }
    }

    companion object {
        private enum class ViewType {
            CAT, SEPARATOR
        }

        private val COMPARATOR = object : DiffUtil.ItemCallback<CatListItem>() {
            override fun areItemsTheSame(oldItem: CatListItem, newItem: CatListItem): Boolean {
                return compareCat(oldItem, newItem) ||
                        compareSeparator(oldItem, newItem)
            }

            override fun areContentsTheSame(oldItem: CatListItem, newItem: CatListItem): Boolean =
                oldItem == newItem
        }

        private fun compareSeparator(
            oldItem: CatListItem,
            newItem: CatListItem
        ) = (oldItem is CatListItem.SeparatorItem && newItem is CatListItem.SeparatorItem &&
                oldItem.letter == newItem.letter)

        private fun compareCat(
            oldItem: CatListItem,
            newItem: CatListItem
        ) = (oldItem is CatListItem.CatItem && newItem is CatListItem.CatItem &&
                oldItem.cat.id == newItem.cat.id)
    }
}