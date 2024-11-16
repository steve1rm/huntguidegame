package me.androidbox.huntguide.presentation.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.androidbox.huntguide.R
import java.nio.file.WatchEvent

@Composable
fun OutlinedHuntGuideButton(
    modifier: Modifier = Modifier,
    onClickStart: () -> Unit) {

    OutlinedButton(
        modifier = modifier.widthIn(min = 248.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Black,
        ),
        border = BorderStroke(
            width = 1.5.dp,
            color = Color.White
        ),
        onClick = onClickStart
    ) {
        Icon(
            imageVector = Icons.Outlined.Info,
            contentDescription = "Information",
            tint = Color.White
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column() {
            Text(text = stringResource(R.string.start_button_title).uppercase(), color = Color.White, fontSize = 14.sp)

            Text(text = stringResource(R.string.start_button_subtitle), color = Color.White, fontSize = 11.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedHuntGuideButtonPreview() {
    OutlinedHuntGuideButton(onClickStart = {})
}