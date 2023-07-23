package com.example.threadsapp.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.threadsapp.data.NavBarScreen
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@Composable
fun ActivityScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Text(
            text = "Activity",
            modifier = Modifier
                .align(Alignment.Start)
                .offset(15.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp

        )
        val scrollState = rememberScrollState(0)

        Row(
            modifier = Modifier
                .padding(7.dp)
                .horizontalScroll(state = scrollState)
                .fillMaxSize()


        ) {

            val cornerRadius = 10.dp
            var selectedIndex by remember { mutableStateOf(0) }

            val itemsList = listOf(
                "All",
                "Replies",
                "Mentions",
                "Verified",

                )
            itemsList.forEachIndexed { index, item ->

                OutlinedButton(
                    onClick = { selectedIndex = index },
                    modifier = when (index) {
                        0 ->
                            Modifier
                                .offset(0.dp, 0.dp)
                                .zIndex(if (selectedIndex == index) 1f else 0f)
                                .widthIn(100.dp)
                                .height(36.dp)

                        else ->
                            Modifier
                                .offset((10 * index).dp, 0.dp)
                                .zIndex(if (selectedIndex == index) 1f else 0f)
                                .widthIn(100.dp)
                                .height(36.dp)

                    },
                    shape =
                    RoundedCornerShape(
                        topStart = cornerRadius,
                        topEnd = cornerRadius,
                        bottomStart = cornerRadius,
                        bottomEnd = cornerRadius
                    ),
                    border = BorderStroke(
                        1.dp,
                        Color.Gray
                    ),
                    colors = if (selectedIndex == index) {
                        ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        )
                    } else {
                        ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    },
                    elevation = ButtonDefaults.buttonElevation(3.dp)
                ) {
                    Text(
                        text = item,
                        fontWeight = FontWeight.Bold,
                        )
                }
            }
        }

    }

}

@Composable
@Preview
fun ActivityScreenPreview() {
    ThreadsAppTheme {
        ActivityScreen()
    }
}