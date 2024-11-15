package me.androidbox.huntguide.presentation.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    onClickStart: () -> Unit
) {

        Button(
            onClick = onClickStart
        ) {
            Text("Hunt Guide")
        }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onClickStart = {})
}