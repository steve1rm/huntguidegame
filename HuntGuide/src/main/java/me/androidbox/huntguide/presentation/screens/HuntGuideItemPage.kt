package me.androidbox.huntguide.presentation.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HuntGuideItemPage(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    body: String,
    @DrawableRes image: Int
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = title, color = Color.White)

            Text(text = subTitle, color = Color.White)

            Text(text = body, color = Color.White)
        }

        Image(
            modifier = Modifier.aspectRatio(1f),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = image),
            contentDescription = null
        )
    }
}
@Preview
@Composable
fun HuntGuideItemPagePreview() {
    HuntGuideItemPage(
        title = "Title",
        subTitle = "Subtitle",
        body = "Body",
        image = android.R.drawable.ic_menu_report_image
    )
}