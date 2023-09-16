package com.example.threadsapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.Indicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.threadsapp.R
import com.example.threadsapp.items.feedItem
import com.example.threadsapp.model.customButton
import com.example.threadsapp.model.feedUser
import com.example.threadsapp.model.profileUser
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@Composable
fun ProfileScreen(profileUser: profileUser, navController: NavController) {
    val cornerRadius = 10.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .clickable { }
            ) {

                Image(
                    painter = painterResource(id = R.drawable.back_arrow),
                    contentDescription = stringResource(id = R.string.pfp),
                    modifier = Modifier
                        .size(24.dp)
                )
                Text(
                    text = stringResource(R.string.back),
                    modifier = Modifier
                        .offset(y = -2.dp),
                    fontSize = 18.sp
                )
            }

            Spacer(
                Modifier
                    .weight(1f)
            )

            Row(
                modifier = Modifier
                    .clickable { }
            ) {

                Image(
                    painter = painterResource(id = R.drawable.instagram),
                    contentDescription = stringResource(id = R.string.pfp),
                    modifier = Modifier
                        .size(24.dp)
                )

                Spacer(
                    Modifier
                        .width(16.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = stringResource(id = R.string.pfp),
                    modifier = Modifier
                        .size(24.dp)
                )
            }

        }

        Column(
            modifier = Modifier
                .padding(vertical = 20.dp)
        ) {
            Row() {

                Column() {
                    Text(
                        text = "Jacob Jones",
                        softWrap = false,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier,
                        fontWeight = FontWeight.Bold
                    )

                    Row() {
                        Text(
                            text = "jones177_ jacob",
                            softWrap = false,
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier
                                .padding(vertical = 5.dp),
                        )


                        val Red = Color(0xF5F5F50)
                        Text(
                            text = "threads.net",
                            softWrap = false,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(vertical = 3.dp, horizontal = 8.dp)
                                .background(
                                    Red,
                                    RoundedCornerShape(
                                        topStart = cornerRadius,
                                        topEnd = cornerRadius,
                                        bottomStart = cornerRadius,
                                        bottomEnd = cornerRadius
                                    )
                                )
                                .padding(5.dp)

                        )

                    }


                }
                val shape = CircleShape
                Spacer(
                    Modifier
                        .weight(1f)
                )

                Box() {
                    Image(
                        painter = painterResource(id = profileUser.pfp),
                        contentDescription = stringResource(id = R.string.pfp),
                        modifier = Modifier
                            .border(2.dp, Color.White, shape)
                            .background(Color.White, shape)
                            .size(64.dp)
                    )

                    if (profileUser.verified) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.verified
                            ),
                            contentDescription = stringResource(id = R.string.pfp),
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .size(24.dp)

                        )
                    }

                }

            }

            Text(
                text = profileUser.bio,
                modifier = Modifier
                    .width(270.dp)
                    .padding(vertical = 5.dp),
                style = MaterialTheme.typography.titleMedium,

                )

            Text(
                text = profileUser.followers,
                softWrap = false,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(vertical = 5.dp)

            )

            Row() {

                customButton(
                    text = stringResource(R.string.edit),
                    modifier = Modifier
                        .weight(1f)
                        .width(173.dp),
                    onButtonClicked = {},
                    isEnabled = true
                )
                customButton(
                    text = stringResource(R.string.share),
                    modifier = Modifier
                        .weight(1f)
                        .width(173.dp),
                    onButtonClicked = {
                    },
                    isEnabled = true
                )
            }

            var state by remember { mutableStateOf(0) }
            val titles = listOf("Threads", "Replies")

            TabRow(
                selectedTabIndex = state,
                indicator =
                { tabPositions ->

                    Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[state]),
                        color = Color.Black

                    )

                },
                tabs = {

                    titles.forEachIndexed { index, title ->
                        Tab(
                            selected = state == index,
                            onClick = { state = index },
                            selectedContentColor = Color.Black,
                            unselectedContentColor = Color.Gray,
                            text = {
                                Text(
                                    text = title,
                                    maxLines = 2,
                                    fontSize = 17.sp,
                                    overflow = TextOverflow.Ellipsis
                                )

                            },

                            )
                    }

                }

            )

            if (state == 0) {
                Threads(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)

                )
            } else {
                Replies(modifier = Modifier
                    .fillMaxSize()

                )
            }


        }


    }
}

@Composable
fun Threads(modifier: Modifier) {

    var str = stringResource(id = R.string.para)

    val people by remember {
        mutableStateOf(
            mutableListOf(
                feedUser(
                    R.drawable.profilepic,
                    "Jacob",
                    "Jones",
                   str,
                    0,
                    true
                ),
                feedUser(
                    R.drawable.profilepic,
                    "Jacob",
                    "Jones",
                    "lmao",
                    0,
                    true
                ),
                feedUser(
                    R.drawable.profilepic,
                    "Jacob",
                    "Jones",
                    "Remember, your thoughts shape your reality. Choose to focus on the good, and watch your world transform.",
                    R.drawable.postpic,
                    true
                )
            )
        )
    }
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        items(people.size) { it ->
            feedItem(
                feedUser = people[it]
            )
        }
    }
}

@Composable
fun Replies(modifier: Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) { Text(
        text = "Coming soon...",
        modifier = Modifier
            .align(Alignment.Center)

    ) }

}

@Preview
@Composable
fun ProfileScreenPreview() {
    ThreadsAppTheme {
        ProfileScreen(
            profileUser(
                R.drawable.profilepic,
                "Jacob",
                "Jones",
                stringResource(R.string.jones177_jacob),
                stringResource(R.string.bio),
                "21 followers",
                true
            ),
            NavController(LocalContext.current)


        )
    }

}