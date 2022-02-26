package com.example.demogridlayoutmanager

import androidx.recyclerview.widget.DiffUtil

data class ViewItem(val id: Int, val name: String, val gravity: Int)

val ITEM_DIFF = object : DiffUtil.ItemCallback<ViewItem>() {
    override fun areItemsTheSame(oldItem: ViewItem, newItem: ViewItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ViewItem, newItem: ViewItem): Boolean {
        return oldItem == newItem
    }
}