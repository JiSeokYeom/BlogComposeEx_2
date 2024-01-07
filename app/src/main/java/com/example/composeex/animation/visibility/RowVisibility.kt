package com.example.composeex.animation.visibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RowVisibility(
    isVisible: Boolean,
    onClickVisible: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .border(1.dp, Color.Blue)
            .padding(top = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally),
            text = "Row의 AnimatedVisibility",
            fontSize = 17.sp,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp),
        ) {
            Button(
                modifier = Modifier
                    .padding(horizontal = 40.dp),
                onClick = { onClickVisible() }
            ) {
                Text(
                    text = if (isVisible) "HIDE" else "SHOW",
                    fontSize = 17.sp
                )
            }
            // AnimatedVisibility 안에 visible를 isVisible로 지정
            // 이외 아무것도 안 정해주면 기본 애니메이션 적용
            AnimatedVisibility(visible = isVisible) {
                Box(
                    modifier = Modifier
                        .size(128.dp)
                        .background(Color.Blue)
                )
            }
        }
    }
}