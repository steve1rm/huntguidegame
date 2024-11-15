package me.androidbox.huntguide.presentation.models

import androidx.annotation.DrawableRes

data class HuntGuideModel(
    val title: String,
    val subTitle: String = "",
    val body: String = "",
    @DrawableRes val res: Int = 0
)
