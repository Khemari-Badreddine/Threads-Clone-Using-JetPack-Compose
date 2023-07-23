package com.example.threadsapp.Screens

import android.view.View
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.threadsapp.R
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@Composable
fun ExploreScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.White),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Search",
            modifier = Modifier
                .align(Alignment.Start),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp

        )

        AndroidView(
            factory = {
                      View.inflate(it, R.layout.fragment_explore,null)

            },
            modifier = Modifier.fillMaxWidth(),
            update = {},

        )

    }
}

@Composable
@Preview
fun ExploreScreenPreview() {
    ThreadsAppTheme {
        ExploreScreen()
    }
}
