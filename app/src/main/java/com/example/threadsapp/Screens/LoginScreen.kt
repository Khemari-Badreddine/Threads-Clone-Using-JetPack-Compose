package com.example.threadsapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.threadsapp.R
import com.example.threadsapp.data.IconResource
import com.example.threadsapp.data.NavBarScreen
import com.example.threadsapp.data.signup.SignupUIEvent
import com.example.threadsapp.data.signup.SignupViewModel
import com.example.threadsapp.model.SimpleTextField
import com.example.threadsapp.model.customButton
import com.example.threadsapp.model.divider
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@Composable
fun LoginScreen(navController: NavController,signupViewModel: SignupViewModel = viewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(9.5f)
                .background(Color.White)
                .padding(28.dp)

        ) {
            Icon(
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(60.dp),
                tint = Color.Black,
                painter = IconResource.fromDrawableResource(R.drawable.threads_logo)
                    .asPainterResource(),
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.Login),
                style = MaterialTheme.typography.titleLarge,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.2f),
                textAlign = TextAlign.Center
            )

            SimpleTextField(
                labelValue = stringResource(id = R.string.usernamepass),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally),
                KeyboardOptions.Default,
                onTextChanged = {
                    signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))
                },
                signupViewModel.registrationUIState.value.emailError

            )

            SimpleTextField(
                labelValue = stringResource(id = R.string.password),
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally),
                KeyboardOptions(keyboardType = KeyboardType.Password),
                onTextChanged = {
                    signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
                },
                signupViewModel.registrationUIState.value.passwordError

            )

            customButton(
                text =
                stringResource(
                    id = R.string.Login
                ),
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally),
                onButtonClicked = {
                    signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                    navController.navigate(NavBarScreen.Home.route)
                },
                isEnabled = signupViewModel.allLoginValidationsPassed.value


            )

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(.5f)
                .background(Color.White)
        ) {
            divider()
            Text(
                text = stringResource(id = R.string.donthave),
                style = LocalTextStyle.current.copy(
                    color = Color.Gray,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                ),
                modifier = Modifier
                    .clickable { navController.navigate(NavBarScreen.SignupScreen.route) }
                    .weight(1f)
                    .fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }

    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    ThreadsAppTheme {
        LoginScreen(NavController(LocalContext.current))
    }

}