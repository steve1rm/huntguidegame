package me.androidbox.huntguide.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import me.androidbox.huntguide.presentation.models.HuntGuideModel
import me.androidbox.huntguide.presentation.screens.components.HuntGuideItemPager

@Composable
fun HuntGuideScreen(
    onCloseClicked: () -> Unit
) {

    val huntGuideItems = remember {
        populateItems()
    }

    HuntGuideItemPager(
        items = huntGuideItems,
        content = { huntGuideItem ->
            HuntGuideItemPage(
                title = huntGuideItem.title
            )
        },
        onCloseClicked = onCloseClicked
    )
}


fun populateItems(): List<HuntGuideModel> {
    return listOf(
        HuntGuideModel(
            title = "01 MASTER YOURLOADOUT"
        ),
        HuntGuideModel(
            title = "02 MASTER YOURLOADOUT"
        ),
        HuntGuideModel(
            title = "03 MASTER YOURLOADOUT"
        ),
        HuntGuideModel(
            title = "04 MASTER YOURLOADOUT"
        ),
        HuntGuideModel(
            title = "05 MASTER YOURLOADOUT"
        ),
        HuntGuideModel(
            title = "06 MASTER YOURLOADOUT"
        ),
        HuntGuideModel(
            title = "07 MASTER YOURLOADOUT"
        ),
        HuntGuideModel(
            title = "07 MASTER YOURLOADOUT"
        ),
        HuntGuideModel(
            title = "08 MASTER YOURLOADOUT"
        ),
        HuntGuideModel(
            title = "09 MASTER YOURLOADOUT"
        ),
        HuntGuideModel(
            title = "10 MASTER YOURLOADOUT"
        )
    )
}
