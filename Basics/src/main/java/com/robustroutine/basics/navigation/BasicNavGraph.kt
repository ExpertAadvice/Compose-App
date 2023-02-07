package com.robustroutine.basics.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.robustroutine.basics.screens.home.BasicScreen
import com.robustroutine.basics.screens.sidenavdrawer.NavigationDrawerScreen
import com.robustroutine.basics.screens.tabviewpager.TableLayoutScreen
import com.robustroutine.common.graph.Graphs

fun NavGraphBuilder.basicNavGraph(navController: NavHostController) {
    navigation(
        route = Graphs.BASIC,
        startDestination = BasicScreens.Basic.route
    ) {
        composable(route = BasicScreens.Basic.route) {
            BasicScreen(
                onClickEvent = {
                    when (it) {
                        "Tab Layout" -> {
                            navController.navigate(BasicScreens.TableLayout.route)
                        }
                        "Navigation Drawer" -> {
                            navController.navigate(BasicScreens.NavigationDrawer.route)
                        }
                        else -> {
                            navController.popBackStack()
                            navController.navigate(Graphs.HOME)
                        }
                    }
                }
            )
        }
        composable(route = BasicScreens.TableLayout.route) {
            TableLayoutScreen(
                onClickEvent = {
                    navController.navigate(BasicScreens.Basic.route)
                }
            )
        }
        composable(route = BasicScreens.NavigationDrawer.route) {
            NavigationDrawerScreen(
                onClickEvent = {
                    navController.navigate(BasicScreens.Basic.route)
                }
            )
        }
    }
}

sealed class BasicScreens(val route: String) {
    object Basic : BasicScreens(route = "BASIC")
    object TableLayout : BasicScreens(route = "TAB")
    object NavigationDrawer : BasicScreens(route = "DRAWER")
}