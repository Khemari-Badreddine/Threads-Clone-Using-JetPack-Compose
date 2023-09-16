package com.example.threadsapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.threadsapp.R
import com.example.threadsapp.data.IconResource
import com.example.threadsapp.items.feedItem
import com.example.threadsapp.model.feedUser
import com.example.threadsapp.model.newfeedUser
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val people by remember {
            mutableStateOf(
                mutableStateListOf(
                    feedUser(
                        R.drawable.avatar,
                        "Wade",
                        "Warren",
                        "god i wish my dreams come true",
                        R.drawable.postpic,
                        true
                    ),
                    feedUser(
                        R.drawable.avat,
                        "Kathryn",
                        "Murphy",
                        "I love the idea of turning setbacks into opportunities for growth. It's all about the mindset! \uD83D\uDCAA",
                        0,
                        true
                    ),
                    feedUser(
                        R.drawable.avata,
                        "Robert",
                        "Fox",
                        "hey, threads \uD83D\uDC40",
                        0,
                        false
                    ),
                    feedUser(
                        R.drawable.avatar,
                        "Hunter",
                        "Murphy",
                        "I love the idea of this app",
                        0,
                        false
                    )
                )
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
                    feedUser = people[it]
                )
            }
        }

    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    ThreadsAppTheme {
        HomeScreen(NavController(LocalContext.current))
    }
}