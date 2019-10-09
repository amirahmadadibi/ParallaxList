package com.amirahmadadibi.projects.androidparallaxrecyclerview.adapter

import android.view.View
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.amirahmadadibi.projects.androidparallaxrecyclerview.model.Show
import kotlinx.android.synthetic.main.item_shop.view.*
import kotlin.math.abs

/**
 * Created by Amirahmad Adibi.
 * Android Parallax Recyclerview | Copyrights 2019-10-09.
 */
class ShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val title = itemView.textViewPosterTitle
    private val description = itemView.textViewPosterDescription
    private val poster = itemView.imageViewPoster
    private val thumbnail = itemView.imageViewPostThumbnail
    private val interpolator = FastOutLinearInInterpolator()

    var offset: Float = 0f
        set(v) {
            // direction - Determines if the view will move to the left or right.
            // interpolatedValue - A value in the range [0.0..1.0] that determines how far the view should be moved, relative to the item view’s width.
            // itemView.measuredWidth - The width of the item root view.
            field = v.coerceIn(-1f, 1f)
            val direction = if (field < 0) -1f else 1f
            val interpolatedValue = interpolator.getInterpolation(abs(field))
            val translationx = direction * interpolatedValue * itemView.measuredWidth

            title.translationX = translationx
            description.translationX = translationx
            thumbnail.translationX = translationx
        }


    fun bind(viewModel: Show) {
        title.setText(viewModel.title)
        description.setText(viewModel.description)
        thumbnail.setImageResource(viewModel.image)
        poster.setImageResource(viewModel.image)
    }
}