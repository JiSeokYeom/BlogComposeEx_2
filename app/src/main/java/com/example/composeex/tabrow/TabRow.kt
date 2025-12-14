package com.example.composeex.tabrow

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.TabRow
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRow(
    navController: NavController
) {
    var selectTabIdx by remember { mutableIntStateOf(2) }
    val colorList = listOf(
        Color.White,
        Color.Yellow,
        Color.Cyan,
        Color.LightGray
    )

    val pagerState = rememberPagerState(
        pageCount = { 4 },
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            TabRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 45.dp),
                selectedTabIndex = selectTabIdx,
                tabs = {
                    repeat(4) { index ->
                        // 커스텀 방식
                        /*    Text(
                        text = "탭$index",
                    )*/

                        // 제공하는 Tab 컴포저블을 이용하는 방식
                        Tab(
                            selected = selectTabIdx == index,
                            onClick = {
                                selectTabIdx = index
                            },
                            text = {
                                Text(
                                    text = "탭$index",
                                )
                            }
                        )
                    }
                }
            )
            HorizontalPager(
                state = pagerState,
                pageSize = PageSize.Fixed(300.dp),
            ) { page ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorList[page])
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center,
                        text = "현재 페이지 $page",
                        fontSize = 17.sp
                    )
                }
            }
        }
    }
}

