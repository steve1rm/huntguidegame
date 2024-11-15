package me.androidbox.huntguidegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.Navigator
import me.androidbox.huntguide.presentation.screens.HuntGuideScreen
import me.androidbox.huntguidegame.navigation.HomeScreenRoute
import me.androidbox.huntguidegame.navigation.HuntGuideScreenRoute
import me.androidbox.huntguidegame.ui.theme.HuntGuideGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HuntGuideGameTheme {
                Navigator(screen = HomeScreenRoute)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HuntGuideGameTheme {
        Greeting("Android")
    }
}