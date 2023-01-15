package com.example.composeex.lazycolumn

import android.content.ClipData.Item
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeex.UserData

@Composable
fun LazyColumnEx(
    navController: NavController
) {

    val userDataList: List<UserData> = setData()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("LazyColumnEx") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                })
        }
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //item 이용하여 단일 데이터 추가
            item {
                Text(
                    text = "첫 번째 데이터",
                    fontSize = 25.sp
                )
            }

            //items 이용하여 여러 데이터 추가
            items(15) { index ->
                Text(
                    text = "$index 데이터",
                    fontSize = 25.sp
                )
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp
                )
            }
            // 아래와 같이 Data Class를 넘겨 줄 수 있음
            items(userDataList) { userData ->
                UserDataScreen(userData)
            }
        }
    }
}


fun setData(): List<UserData> {
    val userDataList: ArrayList<UserData> = arrayListOf()
    for (i in 0..9) {
        userDataList.add(UserData("김이$i", "0$i"))
    }
    return userDataList
}



