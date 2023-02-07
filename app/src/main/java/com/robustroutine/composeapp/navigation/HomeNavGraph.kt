package com.robustroutine.composeapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.robustroutine.composeapp.home_screen.HomeScreen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        route = Graphs.HOME,
        startDestination = Screens.HomeScreen.route
    )
    {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(
                onClick = {
                    when (it) {
                        "2" -> {
                            navController.popBackStack()
                            navController.navigate(Graphs.AUTHENTICATION)
                        }
                        else -> {

                        }
                    }

                }
            )
        }
    }
}

sealed class Screens(val route: String) {
    object HomeScreen : Screens("HOME")
}

