package com.example.threadsapp.data

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.threadsapp.Screens.ActivityScreen
import com.example.threadsapp.Screens.ExploreScreen
import com.example.threadsapp.Screens.HomeScreen
import com.example.threadsapp.Screens.ProfileScreen
import com.example.threadsapp.Screens.WriteScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavBarScreen.Home.route
    ) {
        composable(route = NavBarScreen.Home.route) {
            HomeScreen()
        }

        composable(route = NavBarScreen.Explore.route) {
            ExploreScreen()
        }

        composable(route = NavBarScreen.Write.route) {
            WriteScreen()
        }

        composable(route = NavBarScreen.Activity.route) {
            ActivityScreen()
        }

        composable(route = NavBarScreen.Profile.route) {
            ProfileScreen()
        }

    }
}