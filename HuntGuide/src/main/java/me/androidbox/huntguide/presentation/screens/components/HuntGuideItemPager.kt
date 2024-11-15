@file:OptIn(ExperimentalFoundationApi::class)

package me.androidbox.huntguide.presentation.screens.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun <T> HuntGuideItemPager(
    items: List<T>,
    content: @Composable (list: T) -> Unit,
    lastItemContent: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier,
    onCloseClicked: () -> Unit,
) {

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = {
            /** Always plus 1 for the view all page as the final page */
             if(lastItemContent != null) {
                 items.count() + 1
             } else {
                 items.count()
             }
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.clickable(
                onClick = onCloseClicked
            ),
            imageVector = Icons.Default.Close,
            contentDescription = "Close the hunt guide",
            tint = Color.Black
        )

        HorizontalPager(
            state = pagerState,
            pageSpacing = 16.dp,
            modifier = modifier.wrapContentHeight()
        ) { pageIndex ->

            when(pageIndex) {
                in items.indices -> {
                    content(items[pageIndex])
                }

                else -> {
                    lastItemContent?.invoke()
                }
            }
        }
    }
}