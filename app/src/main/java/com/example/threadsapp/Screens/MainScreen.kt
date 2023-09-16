package com.example.threadsapp.Screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.threadsapp.Navigation.Screen
import com.example.threadsapp.R
import com.example.threadsapp.data.IconResource
import com.example.threadsapp.data.MainViewModel
import com.example.threadsapp.data.NavBarScreen
import com.example.threadsapp.model.profileUser
import com.example.threadsapp.ui.theme.ThreadsAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@ExperimentalMaterial3Api
fun MainScreen(viewModel: MainViewModel, navController: NavController) {

    val navItems = DashboardSection.values().toList()

    val sectionState = remember { mutableStateOf(DashboardSection.Home) }

    Scaffold(
        bottomBar = {
            bottomNavigationBar(
                viewModel,
                items = navItems,
                currentSection = sectionState.value,
                onSectionSelected = { sectionState.value = it }

            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            if (viewModel.isDialogShown) {
                CustomDialog(
                    onDismiss = {
                        viewModel.onDismissDialog()
                    }
                )
            }
        }
        val springSpec = SpringSpec<Float>(
            stiffness = 800f,
            dampingRatio = 0.8f
        )
        Crossfade(
            modifier = Modifier.padding(innerPadding),
            targetState = sectionState.value,
            animationSpec = springSpec,
            label = ""
        )
        { section ->
            when (section) {
                DashboardSection.Home -> HomeScreen(navController)
                else -> {}
            }
            when (section) {
                DashboardSection.Explore -> ExploreScreen(navController)
                else -> {}
            }
            when (section) {
                DashboardSection.Activity -> ActivityScreen(navController)
                else -> {}
            }
            when (section) {
                DashboardSection.Profile -> ProfileScreen(
                    profileUser(
                        R.drawable.profilepic,
                        "Jacob",
                        "Jones",
                        stringResource(R.string.jones177_jacob),
                        stringResource(R.string.bio),
                        "21 followers",
                        true
                    ),
                    navController
                )

                else -> {}
            }

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
    viewModel: MainViewModel,
    items: List<DashboardSection>,
    currentSection: DashboardSection,
    onSectionSelected: (DashboardSection) -> Unit,
) {

    CompositionLocalProvider(
        LocalRippleTheme provides MyRippleTheme
    ) {
        NavigationBar(
            modifier = Modifier
                .height(56.dp),
            containerColor = Color.White

        ) {
            items.forEach { section ->

                val selected = section == currentSection
                val iconRes = if (selected) section.selectedIcon else section.icon

                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = "Nav icon"
                        )
                    },
                    selected = selected,
                    onClick = {

                        if (section == DashboardSection.Write) {
                            viewModel.isDialogShown = true
                        }
                        else{
                            onSectionSelected(section)
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color.White
                    )

                )
            }
        }
    }
}


@Composable
fun RowScope.addItem(
    screen: NavBarScreen,
    currentSection: NavBarScreen,
    viewModel: MainViewModel,
    onSectionSelected: (NavBarScreen) -> Unit
) {

    val selected = screen == currentSection
    val context = LocalContext.current
    NavigationBarItem(
        icon = {
            Icon(
                painter = if (selected) screen.icon_filled.asPainterResource() else screen.icon_outlined.asPainterResource(),
                contentDescription = "Nav icon"
            )
        },
        selected = selected,
        onClick = {
            onSectionSelected(screen)

            if (screen.route == "write") {
                viewModel.isDialogShown = true
            } else {


                //  popUpTo(navController.graph.findStartDestination().id)
                //  launchSingleTop = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = Color.Gray,
            indicatorColor = Color.White
        )

    )

}


enum class DashboardSection(
    val icon: Int,
    val selectedIcon: Int,
) {
    Home(R.drawable.feed, R.drawable.feed_filled),
    Explore(R.drawable.explore, R.drawable.explore_filled),
    Write(R.drawable.write, R.drawable.write),
    Activity(R.drawable.activity, R.drawable.activity_filled),
    Profile(R.drawable.account, R.drawable.account_filled)
}


@Preview
@Composable
fun BottomBarPreview() {
    val navController = rememberNavController()
    val navItems = DashboardSection.values().toList()

    ThreadsAppTheme {
        bottomNavigationBar(
            MainViewModel(),
            currentSection = DashboardSection.Home,
            items = DashboardSection.values().toList(),
        ) {}
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainScreenPreview() {
    ThreadsAppTheme {
        MainScreen(
            viewModel =
            MainViewModel(),
            NavController(LocalContext.current)
        )
    }
}