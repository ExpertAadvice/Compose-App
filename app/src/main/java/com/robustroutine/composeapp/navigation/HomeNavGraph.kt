package com.robustroutine.composeapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.robustroutine.common.graph.Graphs
import com.robustroutine.composeapp.home_screen.HomeScreen
import com.robustroutine.composeapp.utils.TopicList

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        route = Graphs.HOME,
        startDestination = Screens.HomeScreen.route
    )
    {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(
                onClick = {
                    val list = TopicList.getList()
                    when (it) {
                        list[0] -> {
                            navController.navigate(Graphs.AUTHENTICATION)
                        }
                        list[1] -> {
                            navController.navigate(Graphs.BASIC)
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
    object SplashScreen : Screens("SPLASH")
    object HomeScreen : Screens("HOME")
}

