package me.androidbox.huntguidegame.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import me.androidbox.huntguide.presentation.screens.HuntGuideScreen

data object HuntGuideScreenRoute : Screen {

    @Composable
    override fun Content() {
        HuntGuideScreen()
    }
}