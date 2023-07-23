package com.example.threadsapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.threadsapp.R
import com.example.threadsapp.data.IconResource
import com.example.threadsapp.items.feedItem
import com.example.threadsapp.model.Person
import com.example.threadsapp.ui.theme.ThreadsAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val people = remember {
            listOf(
                Person(
                    R.drawable.avatar,
                    "Khemari",
                    "Badreddine",
                    "god i wish this app works",
                    R.drawable.postpic
                ),
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            item {
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp),
                    tint = Color.Black,
                    painter = IconResource.fromDrawableResource(R.drawable.threads_logo)
                        .asPainterResource(),
                    contentDescription = null
                )
            }
            items(people.size) { it ->
                feedItem(
                    person = people[it]
                )
            }
        }

    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    ThreadsAppTheme {
        HomeScreen()
    }
}