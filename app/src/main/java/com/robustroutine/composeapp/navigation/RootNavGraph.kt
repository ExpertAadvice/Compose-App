package com.robustroutine.composeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.robustroutine.authui.navigation.authNavGraph
import com.robustroutine.basics.navigation.basicNavGraph
import com.robustroutine.common.graph.Graphs
import com.robustroutine.composeapp.splash_screen.SplashScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graphs.ROOT,
        startDestination = Screens.SplashScreen.route
    ) {
        composable(route = Screens.SplashScreen.route){
            SplashScreen(
                onTimeOut = {
                    navController.popBackStack()
                    navController.navigate(Graphs.HOME)
                }
            )
        }
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
        basicNavGraph(navController = navController)
    }
}