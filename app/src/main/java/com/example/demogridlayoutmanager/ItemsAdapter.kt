package com.example.demogridlayoutmanager

import android.util.Size
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.demogridlayoutmanager.databinding.ItemInRecyclerviewBinding


class ItemsAdapter(private val itemSize: Size) : ListAdapter<ViewItem, ItemViewHolder>(ITEM_DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(
            ItemInRecyclerviewBinding.inflate(inflater, parent, false),
            itemSize = itemSize
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


