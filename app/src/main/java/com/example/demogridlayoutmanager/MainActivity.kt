package com.example.demogridlayoutmanager

import android.os.Bundle
import android.util.Size
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demogridlayoutmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val items = List(5) {
            "Item ${it + 1}"
        }
        val adapter = ItemsAdapter(getItemSize())
        val girdLayoutManager = GridLayoutManager(this, 6)
        girdLayoutManager.spanSizeLookup = ItemSpanSizeLookup(adapter)
        submitNewData(adapter, items)
        viewBinding.rvItems.setHasFixedSize(true)
        viewBinding.rvItems.layoutManager = girdLayoutManager
        viewBinding.rvItems.adapter = adapter
    }

    private fun submitNewData(
        adapter: ItemsAdapter,
        items: List<String>
    ) {
        adapter.submitList(items.mapIndexed { index, s ->
            ViewItem(
                id = index,
                name = s,
                gravity = getGravity(items.size, index)
            )
        })
    }

    private fun getGravity(size: Int, position: Int): Int {
        if (size % 3 == 0) return Gravity.CENTER
        if ((size % 3) == 2) {
            // Last item
            if (position == size - 1) return Gravity.START
            if (position == size - 2) return Gravity.END
        }
        return Gravity.CENTER
    }

    private fun getItemSize(): Size {
        val screenSize = resources.displayMetrics.widthPixels
        val itemPadding = resources.getDimensionPixelSize(R.dimen.item_padding)
        val width = (screenSize - (8 * itemPadding)) / 3
        val height = width * 1.2f // Ratio 1:1.2
        return Size(width, height.toInt())
    }
}
