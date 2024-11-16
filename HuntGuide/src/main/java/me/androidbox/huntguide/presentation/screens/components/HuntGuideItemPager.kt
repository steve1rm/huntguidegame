@file:OptIn(ExperimentalFoundationApi::class)

package me.androidbox.huntguide.presentation.screens.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
            /** Always plus 1 for the final page if available */
             if(lastItemContent != null) {
                 items.count() + 1
             } else {
                 items.count()
             }
        }
    )

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(true) {
        println("LaunchedEffect")

        while(true) {
            delay(5_000)
            var nextPage = pagerState.currentPage + 1
            println("Next Page $nextPage")

            if(nextPage >= items.count()) {
                /* Reset the next page to be the first page, to start over again */
                nextPage = 0
            }
            pagerState.animateScrollToPage(nextPage)

        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {

            Icon(
                modifier = Modifier.clickable(
                    onClick = onCloseClicked
                ),
                imageVector = Icons.Default.Close,
                contentDescription = "Close the hunt guide",
                tint = Color.Black
            )

            repeat(pagerState.pageCount) { iteration ->
                val color by animateColorAsState(
                    targetValue =  if (pagerState.currentPage < iteration) Color.LightGray else Color.DarkGray,
                    animationSpec = tween(durationMillis = 500)
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100f))
                        .background(color)
                        .width(20.dp)
                        .height(4.dp)
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            pageSpacing = 16.dp,
            modifier = modifier
                .fillMaxSize()
                .clickable {
                    if(pagerState.currentPage < items.count()) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }
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