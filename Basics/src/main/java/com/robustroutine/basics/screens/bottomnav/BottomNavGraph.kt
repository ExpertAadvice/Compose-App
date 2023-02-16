package com.robustroutine.basics.screens.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.robustroutine.basics.R

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = "BOTTOM_NAV",
        startDestination = BottomBarScreens.Home.route
    ) {
        composable(route = BottomBarScreens.Profile.route) {
            ScreenA(
                onClick = { }
            )
        }
        composable(route = BottomBarScreens.Home.route) {
            ScreenB(
                onClick = { }
            )
        }
        composable(route = BottomBarScreens.Completed.route) {
            ScreenC(
                onClick = { }
            )
        }
    }
}

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Profile : BottomBarScreens(
        route = "PROFILE",
        title = "",
        icon = Icons.Filled.Phone
    )

    object Home : BottomBarScreens(
        route = "HOME",
        title = "",
        icon = Icons.Filled.Home
    )

    object Completed : BottomBarScreens(
        route = "BUILD",
        title = "",
        icon = Icons.Filled.Build
    )
}

