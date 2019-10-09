package com.amirahmadadibi.projects.androidparallaxrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.amirahmadadibi.projects.androidparallaxrecyclerview.R
import com.amirahmadadibi.projects.androidparallaxrecyclerview.model.Show

/**
 * Created by Amirahmad Adibi.
 * Android Parallax Recyclerview | Copyrights 2019-10-09.
 */
class ShowAdapter(private val items: List<Show>) : RecyclerView.Adapter<ShowViewHolder>() {
    init {
        setHasStableIds(true)
    }
    override fun getItemCount(): Int = items.size
    override fun getItemId(position: Int): Long = items[position].hashCode().toLong()
    override fun onCreateViewHolder(parent: ViewGroup, vt: Int):ShowViewHolder{
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shop,parent,false)
        return ShowViewHolder(view)
    }
    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) = holder.bind(items[position])




}