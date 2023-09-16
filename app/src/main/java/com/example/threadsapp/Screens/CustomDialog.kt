package com.example.threadsapp.Screens


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.threadsapp.R
import com.example.threadsapp.data.MainViewModel
import com.example.threadsapp.items.newThreadItem
import com.example.threadsapp.model.newfeedUser
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDialog(
    onDismiss: () -> Unit
) {

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = onDismiss) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = stringResource(id = R.string.close)
                            )
                        }
                    },
                    title = {
                        Text(
                            text = stringResource(id = R.string.newthread),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                    },
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding( vertical = 50.dp)

            ) {

                val people by remember {
                    mutableStateOf(
                        mutableStateListOf<newfeedUser>(
                            newfeedUser(
                                "Lets talk about the incredible power of perseverance and how it can change your life",
                                0
                            )
                        )
                    )
                }

                LazyColumn(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(people.size) { it ->
                        newThreadItem(
                            newfeedUser = people[it]
                        )

                    }
                }
                Row() {
                    Spacer(modifier = Modifier.weight(0.5f))

                    Text(
                        text = "Add to thread",
                        style = LocalTextStyle.current.copy(
                            color = Color.Gray,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier
                            .weight(3f)
                            .clickable {
                                println("HOLLAAA")
                                people.add(
                                    newfeedUser(
                                        "Lets talk about the incredible power of perseverance and how it can change your life",
                                        0
                                    )
                                )

                            }
                    )

                    Spacer(modifier = Modifier.weight(1f))
                }


            }
        }


    }
}


@Preview
@Composable
fun DialogPreview() {
    ThreadsAppTheme {
        val viewModel = MainViewModel()
        CustomDialog(
            onDismiss = { viewModel.onDismissDialog() }
        )
    }
}