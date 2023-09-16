package com.example.threadsapp.Navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.threadsapp.R
import com.example.threadsapp.Screens.ActivityScreen
import com.example.threadsapp.Screens.ExploreScreen
import com.example.threadsapp.Screens.LoginScreen
import com.example.threadsapp.Screens.MainScreen
import com.example.threadsapp.Screens.ProfileScreen
import com.example.threadsapp.Screens.SignupScreen
import com.example.threadsapp.data.MainViewModel
import com.example.threadsapp.data.NavBarScreen
import com.example.threadsapp.model.profileUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThreadsApp(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavBarScreen.LoginScreen.route
    ) {
        composable(NavBarScreen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(NavBarScreen.SignupScreen.route) {
            SignupScreen(navController = navController)
        }
        composable(NavBarScreen.Home.route) {
            MainScreen(viewModel, navController = navController)
        }
        composable(NavBarScreen.Explore.route) {
            ExploreScreen(navController = navController)
        }
        composable(NavBarScreen.Activity.route) {
            ActivityScreen(navController = navController)
        }
        composable(NavBarScreen.Profile.route) {
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
                navController = navController
            )
        }
    }
}
