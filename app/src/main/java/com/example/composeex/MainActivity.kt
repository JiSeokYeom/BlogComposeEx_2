package com.example.composeex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeex.SideEffect.SideEffectEx
import com.example.composeex.animation.AnimationEx
import com.example.composeex.bottom.BottomSheetEx
import com.example.composeex.hyperlink.HyperLinkEx
import com.example.composeex.lazycolumn.LazyColumnEx
import com.example.composeex.tabrow.TabRow

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
                    composable("bottomSheetEx") { BottomSheetEx(
                        navController = navController
                    ) }
                    composable("tabRow") { TabRow(
                        navController = navController
                    ) }


                }

            }
        }
    }
}
