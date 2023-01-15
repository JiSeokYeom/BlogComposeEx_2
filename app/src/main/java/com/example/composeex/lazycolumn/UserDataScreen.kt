package com.example.composeex.lazycolumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composeex.UserData

@Composable
fun UserDataScreen(data: UserData) {
    Card {
        Row(
            Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = data.name
            )
            Text(text = data.age)
        }
        Divider(
            color = Color.Gray,
            thickness = 1.dp
        )
    }
}