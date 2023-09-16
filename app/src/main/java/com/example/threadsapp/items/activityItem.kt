package com.example.threadsapp.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.threadsapp.R
import com.example.threadsapp.model.activityUser
import com.example.threadsapp.model.divider
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@Composable
fun activityItem(activityUser: activityUser) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(10.dp)

    ) {
        val shape = CircleShape
        Box() {
            Image(
                painter = painterResource(id = activityUser.pfp),
                contentDescription = stringResource(id = R.string.pfp),
                modifier = Modifier
                    .border(2.dp, Color.White, shape)
                    .background(Color.White, shape)
                    .size(36.dp)
            )
            Image(
                painter = painterResource(
                    id =
                    if (activityUser.type == 0) R.drawable.followbadge
                    else R.drawable.requestbadge
                ),

                contentDescription = stringResource(id = R.string.pfp),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(16.dp)

            )
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)

        ) {
            Row(
                modifier = Modifier
            ) {
                Text(
                    text = activityUser.userName,
                    softWrap = false,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                )

                Text(
                    text = activityUser.time,
                    softWrap = false,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .offset(y = 1.5.dp)
                )
            }

            Text(
                text =
                if (activityUser.type == 0) stringResource(R.string.followedyou)
                else stringResource(R.string.followrequest),
                modifier = Modifier
                    .weight(1f, false)
                    .padding(0.dp),
                color = Color.Gray,
                style = MaterialTheme.typography.titleMedium,
            )


        }


        Box(
            modifier = Modifier
                .fillMaxWidth()

        ) {

            if (activityUser.type == 0) {
                button(
                    stringResource(R.string.follow),
                    Modifier
                        .padding(
                            horizontal = 5.dp
                        )
                        .widthIn(100.dp)
                        .height(36.dp)
                        .align(Alignment.CenterEnd)
                )
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Spacer(modifier = Modifier.width(14.dp))
                    button(
                        stringResource(R.string.confirm),
                        Modifier
                            .padding(
                                horizontal = 5.dp
                            )
                            .widthIn(71.dp)
                            .height(34.dp)
                    )

                    button(
                        stringResource(R.string.hide),
                        Modifier
                            .padding(
                            )
                            .widthIn(71.dp)
                            .height(34.dp)

                    )
                }
            }
        }


    }

}

@Composable
private fun button(title: String, modifier: Modifier) {

    val cornerRadius = 10.dp
    var selected by remember { mutableStateOf(false) }

    OutlinedButton(
        onClick = { selected = !selected },
        modifier = modifier,
        shape =
        RoundedCornerShape(
            topStart = cornerRadius,
            topEnd = cornerRadius,
            bottomStart = cornerRadius,
            bottomEnd = cornerRadius
        ),
        border = BorderStroke(
            1.dp,
            Color.LightGray
        ),
        colors =
        if (selected == false) {
            ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        } else {
            ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color.LightGray
            )
        },
        elevation = ButtonDefaults.buttonElevation(3.dp)
    ) {
        Text(
            text = title,
        )
    }

}


@Composable
@Preview
fun activityItemPreview() {
    ThreadsAppTheme {
        activityItem(
            activityUser(
                R.drawable.profilepic,
                stringResource(R.string.name_example),
                "12s",
                1,
                true
            )

        )
    }
}