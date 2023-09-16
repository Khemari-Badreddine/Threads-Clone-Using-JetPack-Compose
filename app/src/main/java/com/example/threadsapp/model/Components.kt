package com.example.threadsapp.model

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.threadsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(
    labelValue: String,
    modifier: Modifier,
    keyboardOptions: KeyboardOptions,
    onTextChanged: (String) -> Unit,
    errorStatus: Boolean
) {

    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        label = {
            Text(
                text = labelValue,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.SansSerif

            )
        },
        modifier = modifier,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextChanged(it)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            focusedLabelColor = Color.Gray,
            containerColor = colorResource(R.color.whiteish).copy(alpha = .2f),
            cursorColor = Color.Black
        ),
        keyboardOptions = keyboardOptions,
        isError = !errorStatus

    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    placeholderText: String = "Placeholder",
) {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Characters,
            autoCorrect = false,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.None
        ),
        shape = CircleShape,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        placeholder = { Text(placeholderText) },
        maxLines = 1,
        singleLine = true
    )
}

@Composable
fun customButton(
    text: String,
    modifier: Modifier,
    onButtonClicked: () -> Unit,
    isEnabled: Boolean = false,
) {
    val cornerRadius = 10.dp
    var selected by remember { mutableStateOf(false) }

    OutlinedButton(
        onClick = {
            onButtonClicked.invoke()

            // navController.navigate(route)

        },
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
                containerColor = Color.Black,
                contentColor = Color.White
            )
        } else {
            ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        },
        elevation = ButtonDefaults.buttonElevation(3.dp),
        enabled = isEnabled

    ) {
        Text(
            text = text,
        )
    }
}

@Composable
fun divider() {

    Divider(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .width(1.dp)
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchView(
    search: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {

    Box(
        modifier = modifier
            .padding(5.dp)
            .clip(CircleShape)
            .background(Color(0XFF101921))

    ) {
        var text by rememberSaveable { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = { text = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFEFEFF0).copy(alpha = 1f),
                focusedIndicatorColor = Color.Transparent, cursorColor = Color(0XFF070E14),
                disabledTextColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            placeholder = { Text(text = "Search") },
            modifier=Modifier
                .fillMaxWidth()
                .height(55.dp)
        )
    }

}
