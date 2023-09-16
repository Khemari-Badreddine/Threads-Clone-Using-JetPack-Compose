package com.example.threadsapp.Navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object SignupScreen : Screen("singup_screen")

    object HomeScreen : Screen("home_screen")
    object ExploreScreen : Screen("explore_screen")
    object ActivityScreen : Screen("activity_screen")

    object ProfileScreen : Screen("profile_screen")

}