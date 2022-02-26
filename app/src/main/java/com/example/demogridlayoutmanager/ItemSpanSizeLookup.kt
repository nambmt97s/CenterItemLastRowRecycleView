package com.example.demogridlayoutmanager

import androidx.recyclerview.widget.GridLayoutManager

class ItemSpanSizeLookup(private val adapter: ItemsAdapter) : GridLayoutManager.SpanSizeLookup() {
    override fun getSpanSize(position: Int): Int {
        val realSpanCount = 3
        val fullRow = adapter.itemCount / realSpanCount + 1
        if (adapter.itemCount % 3 == 0) {
            return 2
        }
        if ((position.toDouble()) / realSpanCount.toDouble() >= (fullRow - 1)) {
            if (adapter.currentList.size % 3 == 1) {
                return 6
            }
            if ((position + 1) % 3 == 1 || (position + 1) % 3 == 2) {
                return 3
            }
        }
        return 2
    }
}
