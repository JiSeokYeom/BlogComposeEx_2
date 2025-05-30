package com.example.composeex

import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeex.SideEffect.SideEffectEx
import com.example.composeex.animation.AnimationEx
import com.example.composeex.hyperlink.HyperLinkEx
import com.example.composeex.lazycolumn.LazyColumnEx
import com.example.composeex.lazycolumn.UserDataScreen
import kotlin.concurrent.timer

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "mainScreen") {
                    composable("mainScreen") { MainScreen(
                        navController = navController
                    ) }
                    composable("lazyColumnEx") { LazyColumnEx(
                        navController = navController
                    ) }
                    composable("hyperLinkEx") { HyperLinkEx(
                        navController = navController
                    ) }
                    composable("animationEx") { AnimationEx(
                        navController = navController
                    ) }
                    composable("sideEffectEx"){ SideEffectEx(
                        navController = navController
                    ) }
                    composable("bottomSheetEx") { SideEffectEx(
                        navController = navController
                    ) }
                }

            }
        }
    }
}
