package com.robustroutine.composeapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.robustroutine.composeapp.screen_a.AScreen
import com.robustroutine.composeapp.screen_b.BScreen


fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        route = Graphs.HOME,
        startDestination = HomeScreens.ScreenA.route
    )
    {
        composable(route = HomeScreens.ScreenA.route) {
            AScreen(
                onClick = {
                    navController.navigate(HomeScreens.ScreenB.route)
                }
            )
        }

        composable(route = HomeScreens.ScreenB.route) {
            BScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graphs.AUTHENTICATION)
                }
            )
        }
    }
}

sealed class HomeScreens(val route: String) {
    object ScreenA : HomeScreens("a_screen")
    object ScreenB : HomeScreens("b_screen")
}

