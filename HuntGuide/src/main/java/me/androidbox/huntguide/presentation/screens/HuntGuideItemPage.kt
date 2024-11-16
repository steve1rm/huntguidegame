package me.androidbox.huntguide.presentation.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HuntGuideItemPage(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    body: String,
    @DrawableRes image: Int
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = title, color = Color.White)

        Text(text = subTitle, color = Color.White)

        Text(text = body, color = Color.White)

    }
}