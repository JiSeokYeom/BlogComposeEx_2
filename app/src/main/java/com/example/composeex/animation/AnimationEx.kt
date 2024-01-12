package com.example.composeex.animation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeex.animation.visibility.ColumnVisibility
import com.example.composeex.animation.visibility.EtcVisibility
import com.example.composeex.animation.visibility.FadeInVisibility
import com.example.composeex.animation.visibility.RowVisibility

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationEx(
    navController: NavController
) {
    var isChange by remember { mutableStateOf(false) }
    var etcIsChange by remember { mutableStateOf(false) }

    // animateColorAsState로 감싸 주고 by를 이용해서 받아온다
    val imageColor by animateColorAsState(if (isChange) Blue else Red)

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        // animateColorAsState
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onClick = { isChange = !isChange }
                ) {
                    Text(
                        text = "컬러 변경",
                        fontSize = 17.sp
                    )
                }
                Box(
                    modifier = Modifier
                        .size(128.dp)
                        .background(imageColor)
                )
            }

            // AnimatedVisibility
            var isVisible by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                RowVisibility(
                    isVisible = isVisible,
                    onClickVisible = {
                        isVisible = !isVisible
                    }
                )
                ColumnVisibility(
                    isVisible = isVisible,
                    onClickVisible = {
                        isVisible = !isVisible
                    }
                )
            }


            EtcVisibility(
                isVisible = etcIsChange,
                onClickVisible = {
                    etcIsChange = !etcIsChange
                }
            )

            FadeInVisibility(
                isVisible = etcIsChange,
                onClickVisible = {
                    etcIsChange = !etcIsChange
                }
            )
        }
    }
}