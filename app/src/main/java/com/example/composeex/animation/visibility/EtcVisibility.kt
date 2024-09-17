package com.example.composeex.animation.visibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun EtcVisibility(
    isVisible: Boolean,
    onClickVisible: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .border(1.dp, Color.Blue)
            .padding(top = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally),
            text = "expandHorizontally / shrinkHorizontally",
            fontSize = 17.sp,
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp),
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                onClick = { onClickVisible() }
            ) {
                Text(
                    text = if (isVisible) "HIDE" else "SHOW",
                    fontSize = 17.sp
                )
            }
            /** enter = expandHorizontally() exit = shrinkHorizontally() 적용 **/
            AnimatedVisibility(
                visible = isVisible,
                enter = expandHorizontally(),
                exit = shrinkHorizontally(),
            ) {
                Box(
                    modifier = Modifier
                        .size(128.dp)
                        .padding(top = 20.dp)
                        .background(Color.Blue)
                )
            }
        }
    }
}