package com.example.threadsapp.Screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.threadsapp.R
import com.example.threadsapp.data.BottomNavGraph
import com.example.threadsapp.data.NavBarScreen
import com.example.threadsapp.items.feedItem
import com.example.threadsapp.model.Person
import com.example.threadsapp.ui.theme.ThreadsAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            bottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraph(navController = navController)

        }
    }

}

private object MyRippleTheme : RippleTheme {

    @Composable
    override fun defaultColor() = Color.White

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}

@Composable
fun bottomNavigationBar(
    navController: NavHostController
) {
    val screens = listOf(
        NavBarScreen.Home,
        NavBarScreen.Explore,
        NavBarScreen.Write,
        NavBarScreen.Activity,
        NavBarScreen.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentdest = navBackStackEntry?.destination

    CompositionLocalProvider(
        LocalRippleTheme provides MyRippleTheme
    ) {
        NavigationBar(

            modifier = Modifier
                .height(56.dp),
            containerColor = Color.White

        ) {
            screens.forEach { screen ->
                addItem(
                    screen = screen,
                    currentDestination = currentdest,
                    navController = navController
                )
            }
        }
    }
}


@Composable
fun RowScope.addItem(
    screen: NavBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val context = LocalContext.current
    NavigationBarItem(
        icon = {
            Icon(
                painter = if (selected) screen.icon_filled.asPainterResource() else screen.icon_outlined.asPainterResource(),
                contentDescription = "Nav icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                Toast.makeText(context, "Click second time to exist app", Toast.LENGTH_SHORT)
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = Color.Gray,
            indicatorColor = Color.White
        )

    )

}


@Composable
@Preview
fun MainScreenPreview() {
    ThreadsAppTheme {
        MainScreen()
    }
}