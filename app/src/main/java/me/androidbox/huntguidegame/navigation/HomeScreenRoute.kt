package me.androidbox.huntguidegame.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import me.androidbox.huntguide.presentation.screens.HomeScreen

data object HomeScreenRoute : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        HomeScreen(
            onClickStart = {
                navigator?.push(HuntGuideScreenRoute)
            })
    }
}