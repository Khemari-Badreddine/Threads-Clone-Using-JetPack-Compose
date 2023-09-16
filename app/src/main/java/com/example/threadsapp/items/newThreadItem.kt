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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.threadsapp.R
import com.example.threadsapp.model.CustomSearchView
import com.example.threadsapp.model.CustomTextField
import com.example.threadsapp.model.newfeedUser
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@Composable
fun newThreadItem(newfeedUser: newfeedUser) {

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
                painter = painterResource(id = R.drawable.profilepic),
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
                    text = "Pedro_gh",
                    softWrap = false,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                )

            }

            var text by remember { mutableStateOf("Start a thread...") }

            CustomTextField(
                modifier = Modifier
                    .offset(x = -12.dp, y = -18.dp)
                    .fillMaxWidth(),
                placeholderText = text
            )

            if (newfeedUser.postpic != 0) {
                val shape = RectangleShape
                Image(
                    painter = painterResource(id = newfeedUser.postpic),
                    contentDescription = stringResource(id = R.string.pfp),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .background(Color.White, shape)
                        .heightIn(250.dp)
                        .widthIn(338.dp)
                )
            } else {

                Image(
                    painter = painterResource(id = R.drawable.import_img),
                    contentDescription = stringResource(id = R.string.pfp),
                    modifier = Modifier
                        .background(Color.White)
                        .offset(y = -20.dp)

                )
            }

        }
    }

}


@Composable
@Preview
fun newfeedItemPreview() {
    ThreadsAppTheme {
        newThreadItem(
            newfeedUser = newfeedUser(
                stringResource(R.string.post_example),
                0,
            )
        )
    }
}