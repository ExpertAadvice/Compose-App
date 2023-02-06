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
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
}