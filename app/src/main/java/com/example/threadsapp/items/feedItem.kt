package com.example.threadsapp.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.threadsapp.R
import com.example.threadsapp.data.IconResource
import com.example.threadsapp.model.Person
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@Composable
fun feedItem(person: Person) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .background(Color.White)
            .padding(10.dp),

        ) {
        Column(
        ) {
            val shape = CircleShape
            Image(
                painter = painterResource(id = person.pfp),
                contentDescription = stringResource(id = R.string.pfp),
                modifier = Modifier
                    .padding(4.dp) // margin
                    .align(Alignment.CenterHorizontally)
                    .border(2.dp, Color.White, shape)
                    .background(Color.White, shape)
                    .size(36.dp),
            )
            Divider(
                color = Color.LightGray,
                modifier = Modifier
                    .fillMaxHeight(.9f)
                    .width(1.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

        Column(
            modifier = Modifier
                .padding(5.dp)

        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = person.firstName + " " + person.lastName,
                    softWrap = false,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                )


                Text(
                    text = "33m",
                    softWrap = false,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(horizontal = 35.dp)
                )


                Icon(
                    modifier = Modifier
                        .align(Alignment.TopEnd),
                    tint = Color.Black,
                    painter = IconResource.fromDrawableResource(R.drawable.dots)
                        .asPainterResource(),
                    contentDescription = null
                )


            }

            Text(
                text = person.post,
                modifier = Modifier
                    .weight(1f, false)
                    .padding(0.dp),
                style = MaterialTheme.typography.bodyLarge,
            )

            if (person.postpic != 0) {

                val shape = RectangleShape
                Image(
                    painter = painterResource(id = person.postpic),
                    contentDescription = stringResource(id = R.string.pfp),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .background(Color.White, shape)
                        .heightIn(250.dp)
                        .widthIn(338.dp)
                )
            }

            Row() {
                FavoriteButton(

                )

                IconToggleButton(
                    checked = true,
                    modifier = Modifier,
                    onCheckedChange = { true }
                ) {
                    Icon(
                        tint = Color.Black,
                        modifier = Modifier
                            .graphicsLayer {
                                scaleX = 1.2f
                                scaleY = 1.2f
                            },
                        painter = IconResource.fromDrawableResource(R.drawable.comment)
                            .asPainterResource(),
                        contentDescription = null
                    )
                }

                IconToggleButton(
                    checked = true,
                    onCheckedChange = { true }
                ) {
                    Icon(
                        tint = Color.Black,
                        modifier = Modifier
                            .graphicsLayer {
                                scaleX = 1.1f
                                scaleY = 1.1f
                            },
                        painter = IconResource.fromDrawableResource(R.drawable.repost)
                            .asPainterResource(),
                        contentDescription = null
                    )
                }

                IconToggleButton(
                    checked = true,
                    onCheckedChange = { true }
                ) {
                    Icon(
                        tint = Color.Black,
                        modifier = Modifier
                            .graphicsLayer {
                                scaleX = 1.2f
                                scaleY = 1.2f
                            },
                        painter = IconResource.fromDrawableResource(R.drawable.send)
                            .asPainterResource(),
                        contentDescription = null
                    )
                }
            }
        }
    }
}


@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
) {

    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        modifier = modifier,
        onCheckedChange = {
            isFavorite = !isFavorite
        },

        ) {
        Icon(
            tint =
            if (!isFavorite) Color.Black
            else Color.Red,

            modifier = modifier
                .graphicsLayer {
                    scaleX = 1f
                    scaleY = 1f
                },
            painter =
            if (isFavorite) {
                IconResource.fromDrawableResource(R.drawable.filled_like_button).asPainterResource()
            } else {
                IconResource.fromDrawableResource(R.drawable.like_button).asPainterResource()
            },
            contentDescription = null
        )
    }

}


@Composable
@Preview
fun feedItemPreview() {
    ThreadsAppTheme {
        feedItem(
            person = Person(
                R.drawable.avatar,
                stringResource(R.string.name_example),
                stringResource(R.string.lastname_example),
                stringResource(R.string.post_example),
                R.drawable.postpic
            )
        )
    }
}