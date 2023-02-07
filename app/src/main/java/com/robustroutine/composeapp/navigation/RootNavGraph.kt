package com.robustroutine.composeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.robustroutine.authui.navigation.authNavGraph
import com.robustroutine.basics.navigation.basicNavGraph
import com.robustroutine.common.graph.Graphs

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graphs.ROOT,
        startDestination = Graphs.HOME
    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
        basicNavGraph(navController = navController)
    }
}