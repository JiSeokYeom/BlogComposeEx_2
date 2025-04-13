package com.example.composeex.bottom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheerEx(
    navController: NavController
){

    // show, hide 사용을 위해 추가
    val coroutineScope = rememberCoroutineScope()

    // sheetState를 위해 rememberModalBottomSheetState 생성 (기본으로 닫힘 상태)
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetContent = {
            // 바텀 시트 내부 콘텐츠
            val fruitList = listOf("사과", "바나나", "포도", "오렌지", "토마토")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 15.dp)
            ) {
                fruitList.forEach { fruitName ->
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = fruitName,
                        fontSize = 14.sp
                    )
                }
            }
        },
        content = {
            // 메인 콘텐츠
            Box(modifier = Modifier.fillMaxSize()){
                Button(onClick = {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }) {
                    Text(
                        text = "과일 리스트 바텀 시트"
                    )
                }
            }
        }
    )

}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewBottomSheetEx(){
    BottomSheerEx(navController = rememberNavController())
}