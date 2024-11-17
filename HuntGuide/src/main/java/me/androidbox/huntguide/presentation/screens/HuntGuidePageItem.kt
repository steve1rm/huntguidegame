package me.androidbox.huntguide.presentation.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HuntGuidePageItem(
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
            Text(
                text = title.uppercase(),
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = subTitle.uppercase(),
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = body,
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
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
    HuntGuidePageItem(
        title = "08 extract a prize",
        subTitle = "become an official winner",
        body = "If you happen to find a prize; you will need to extract it using an extraction rocket found on the mini-map to become an official winner.\n\n" +
                "Extraction rockets are dangerous areas as you could come across campers trying to steal your prize.\n\n" +
                "If you manage to successfully make it to the rocket, you will then need to input a 4 digit code which will appear on your screen for the extraction to be successful.",
        image = android.R.drawable.ic_menu_report_image
    )
}