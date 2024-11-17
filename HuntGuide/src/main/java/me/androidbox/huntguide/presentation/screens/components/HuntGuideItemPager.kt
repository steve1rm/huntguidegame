@file:OptIn(ExperimentalFoundationApi::class, FlowPreview::class)

package me.androidbox.huntguide.presentation.screens.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import me.androidbox.huntguide.R

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
    var isPaused by remember {
        mutableStateOf(false)
    }

    /** So we can observe when the isPaused and current page has changed */
    val currentPageFlow = snapshotFlow { pagerState.currentPage }
    val isPausedFlow = snapshotFlow { isPaused }

    LaunchedEffect(isPaused) {
        /** Sets the slider duration of 10 seconds,
          * Will trigger when either current page or isPaused has changed  */
        combine(currentPageFlow.debounce(10_000), isPausedFlow) { currentPage, isPaused ->
            if (!isPaused) {
                if (currentPage >= items.count() - 1) {
                    /** When we reach the end reset to page 0 */
                    pagerState.animateScrollToPage(0)
                } else {
                    pagerState.animateScrollToPage(currentPage + 1)
                }
            }
        }.collect()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Image(
                modifier = Modifier.clickable(
                    onClick = onCloseClicked
                ).size(16.dp),
                painter = painterResource(R.drawable.cross),
                contentDescription = "Close the hunt guide",
            )

            /** Indicators */
            repeat(pagerState.pageCount) { iteration ->
                val resIndicator =
                    if (pagerState.currentPage < iteration) R.drawable.dark_indicator else R.drawable.white_indicator

                Image(
                    modifier = Modifier.size(width = 16.dp, height = 6.dp),
                    painter = painterResource(id = resIndicator),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        HorizontalPager(
            state = pagerState,
            pageSpacing = 16.dp,
            modifier = modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            isPaused = true
                            tryAwaitRelease()
                            isPaused = false
                        },
                        onTap = {
                            if(pagerState.currentPage < items.count()) {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            }
                        }
                    )
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
@Preview
@Composable
fun HuntGuideItemPagerPreview() {
    val items = listOf(1, 2, 3)
    HuntGuideItemPager(
        items = items,
        content = {
            Text(text = "Item: $it")
        },
        onCloseClicked = { }
    )
}