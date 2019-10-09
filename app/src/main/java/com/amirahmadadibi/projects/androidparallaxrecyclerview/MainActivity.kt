package com.amirahmadadibi.projects.androidparallaxrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.amirahmadadibi.projects.androidparallaxrecyclerview.adapter.ShowAdapter
import com.amirahmadadibi.projects.androidparallaxrecyclerview.extension.setupParallaxScrollListener
import com.amirahmadadibi.projects.androidparallaxrecyclerview.model.Show
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val moviewList = mutableListOf<Show>()
        moviewList +=   Show(R.string.title1,R.string.description1,R.drawable.photo1)
        moviewList +=   Show(R.string.title2,R.string.description2,R.drawable.photo2)
        moviewList +=   Show(R.string.title3,R.string.description3,R.drawable.photo3)
        setContentView(R.layout.activity_main)
        recyclerview.apply {
            // Create and attach the adapter
            adapter = ShowAdapter(moviewList)

            // Configure to be a horizontal list
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            // Attach a snap helper, more on that below
            PagerSnapHelper().attachToRecyclerView(this)

            // Where most of the parallax magic happens
            setupParallaxScrollListener()
        }

    }
}
