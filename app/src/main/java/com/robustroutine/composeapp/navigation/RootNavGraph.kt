package com.robustroutine.composeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.robustroutine.authui.navigation.authNavGraph

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graphs.ROOT,
        startDestination = Graphs.HOME
    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}

object Graphs {
    const val ROOT = "ROOT_GRAPH"
    const val AUTHENTICATION = "AUTH_GRAPH"
    const val HOME = "HOME_GRAPH"
}