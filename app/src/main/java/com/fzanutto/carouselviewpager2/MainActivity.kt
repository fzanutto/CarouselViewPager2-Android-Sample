package com.fzanutto.carouselviewpager2

import android.app.Activity
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.fzanutto.carouselviewpager2.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageResources = listOf(
            R.drawable.banana,
            R.drawable.strawberry,
            R.drawable.orange,
            R.drawable.apple,
            R.drawable.grape
        )

        val labels = listOf(
            "Banana",
            "Strawberry",
            "Orange",
            "Apple",
            "Grape"
        )

        val itemAdapter = ItemAdapter(imageResources, labels)
        binding.viewPager2.adapter = itemAdapter

        binding.viewPager2.offscreenPageLimit = 1

        // Horizontal margin from current item side to the parent container
        val horizontalItemMargin = resources.getDimension(R.dimen.horizontal_margin)

        val itemDecoration = object: RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.left = horizontalItemMargin.toInt()
                outRect.right = horizontalItemMargin.toInt()
            }
        }
        binding.viewPager2.addItemDecoration(itemDecoration)

        // How much of the side items will be visible
        val sideItemVisibility = resources.getDimension(R.dimen.side_item_visibility)

        val pageTranslationX = horizontalItemMargin + sideItemVisibility
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
        }
        binding.viewPager2.setPageTransformer(pageTransformer)
    }
}