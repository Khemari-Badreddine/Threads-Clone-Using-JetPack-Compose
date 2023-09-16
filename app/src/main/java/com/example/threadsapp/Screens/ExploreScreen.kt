package com.example.threadsapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.threadsapp.R
import com.example.threadsapp.items.exploreItem
import com.example.threadsapp.model.CustomSearchView
import com.example.threadsapp.model.exploreUser
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@Composable
fun ExploreScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)

        ,

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

        CustomSearchView(search = "Search..", onValueChange = {})

        val people by remember {
            mutableStateOf(
                mutableListOf(
                    exploreUser(
                        R.drawable.profilepic,
                        "Jacob",
                        "Jones",
                        "jones177_jacob",
                        "21 followers",
                        true
                    ),
                    exploreUser(
                        R.drawable.avatar,
                        "juria",
                        "koko",
                        "koko87",
                        "3.3k followers",
                        true
                    ),
                    exploreUser(
                        R.drawable.profilepic,
                        "Hunter",
                        "Killer",
                        "hunter76",
                        "2.1k followers",
                        false
                    ),
                    exploreUser(
                        R.drawable.avat,
                        "Vatira",
                        "Allushin",
                        "vati_alu",
                        "2 followers",
                        false
                    ),
                    exploreUser(
                        R.drawable.avata,
                        "Liefs",
                        "Gibb",
                        "Liefx",
                        "5k followers",
                        true
                    ),


                    )
            )
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            items(people.size) { it ->
                exploreItem(
                    exploreUser = people[it]
                )
            }
        }

    }
}

@Composable
@Preview
fun ExploreScreenPreview() {
    ThreadsAppTheme {
        ExploreScreen(NavController(LocalContext.current))
    }
}
