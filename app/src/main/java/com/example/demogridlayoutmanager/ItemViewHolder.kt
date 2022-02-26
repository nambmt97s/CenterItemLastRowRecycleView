package com.example.demogridlayoutmanager

import android.util.Size
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.demogridlayoutmanager.databinding.ItemInRecyclerviewBinding

class ItemViewHolder(
    private val binding: ItemInRecyclerviewBinding,
    itemSize: Size
) : RecyclerView.ViewHolder(binding.root) {

    init {
        val layoutParams = binding.mainItem.layoutParams
        layoutParams.width = itemSize.width
        layoutParams.height = itemSize.height
        binding.mainItem.layoutParams = layoutParams
    }

    fun bind(text: ViewItem) {
        val layoutParams = binding.mainItem.layoutParams as FrameLayout.LayoutParams
        layoutParams.gravity = text.gravity
        binding.mainItem.layoutParams = layoutParams
        binding.tvItem.text = text.name
    }
}