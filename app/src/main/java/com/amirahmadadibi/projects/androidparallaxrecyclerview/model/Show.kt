package com.amirahmadadibi.projects.androidparallaxrecyclerview.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by Amirahmad Adibi.
 * Android Parallax Recyclerview | Copyrights 2019-10-09.
 */

data class Show(
    @StringRes val title:Int,
    @StringRes val description:Int,
    @DrawableRes val image:Int
)