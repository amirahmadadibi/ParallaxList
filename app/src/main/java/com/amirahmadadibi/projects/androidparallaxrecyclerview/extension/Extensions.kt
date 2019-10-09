package com.amirahmadadibi.projects.androidparallaxrecyclerview.extension

import android.widget.AbsListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amirahmadadibi.projects.androidparallaxrecyclerview.adapter.ShowViewHolder

/**
 * Created by Amirahmad Adibi.
 * Android Parallax Recyclerview | Copyrights 2019-10-09.
 */

fun RecyclerView.setupParallaxScrollListener() {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = layoutManager as? LinearLayoutManager ?: return

            val scrollOffset = recyclerView.computeHorizontalScrollOffset()
            val offsetFactor = (scrollOffset % measuredWidth) / measuredWidth.toFloat()

            val firstVsisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            findViewHolderForAdapterPosition(firstVsisibleItemPosition)?.let {
                (it as? ShowViewHolder)?.offset = -offsetFactor
            }

            val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
            if (firstVsisibleItemPosition != lastVisibleItemPosition) {
                findViewHolderForAdapterPosition(lastVisibleItemPosition)?.let {
                    (it as? ShowViewHolder)?.offset = 1 - offsetFactor
                }
            }
        }
    })
}