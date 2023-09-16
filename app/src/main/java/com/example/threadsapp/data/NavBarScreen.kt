package com.example.threadsapp.data


import com.example.threadsapp.R

sealed class NavBarScreen(
    val route: String,
    val title: String,
    val icon_outlined: IconResource,
    val icon_filled: IconResource

) {

    object LoginScreen : NavBarScreen(
        route = "login",
        title = "Login",
        icon_outlined = IconResource.fromDrawableResource(R.drawable.feed),
        icon_filled = IconResource.fromDrawableResource(R.drawable.feed_filled)
    )

    object SignupScreen : NavBarScreen(
        route = "Signup",
        title = "Signup",
        icon_outlined = IconResource.fromDrawableResource(R.drawable.feed),
        icon_filled = IconResource.fromDrawableResource(R.drawable.feed_filled)
    )
    object Home : NavBarScreen(
        route = "home",
        title = "Home",
        icon_outlined = IconResource.fromDrawableResource(R.drawable.feed),
        icon_filled = IconResource.fromDrawableResource(R.drawable.feed_filled)
    )

    object Explore : NavBarScreen(
        route = "explore",
        title = "Explore",
        icon_outlined = IconResource.fromDrawableResource(R.drawable.explore),
        icon_filled = IconResource.fromDrawableResource(R.drawable.explore_filled)
    )

    object Write : NavBarScreen(
        route = "write",
        title = "Write",
        icon_outlined = IconResource.fromDrawableResource(R.drawable.write),
        icon_filled = IconResource.fromDrawableResource(R.drawable.write_filled)
    )

    object Activity : NavBarScreen(
        route = "activity",
        title = "Activity",
        icon_outlined = IconResource.fromDrawableResource(R.drawable.activity),
        icon_filled = IconResource.fromDrawableResource(R.drawable.activity_filled)
    )

    object Profile : NavBarScreen(
        route = "profile",
        title = "Profile",
        icon_outlined = IconResource.fromDrawableResource(R.drawable.account),
        icon_filled = IconResource.fromDrawableResource(R.drawable.account_filled)
    )

}
