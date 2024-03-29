package com.robustroutine.basics.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.robustroutine.basics.screens.bottomnav.BottomNavigationScreen
import com.robustroutine.basics.screens.home.BasicScreen
import com.robustroutine.basics.screens.permissionhandling.PermissionScreen
import com.robustroutine.basics.screens.previewcomponents.PreviewScreen
import com.robustroutine.basics.screens.sidenavdrawer.NavigationDrawerScreen
import com.robustroutine.basics.screens.tabviewpager.TableLayoutScreen
import com.robustroutine.basics.utils.CourseList
import com.robustroutine.common.graph.Graphs

fun NavGraphBuilder.basicNavGraph(navController: NavHostController) {
    navigation(
        route = Graphs.BASIC,
        startDestination = BasicScreens.Basic.route
    ) {
        composable(route = BasicScreens.Basic.route) {
            BasicScreen(
                onClickEvent = {
                    val list = CourseList.getList()
                    when (it) {
                        list[0] -> {
                            navController.navigate(BasicScreens.TableLayout.route)
                        }
                        list[1] -> {
                            navController.navigate(BasicScreens.NavigationDrawer.route)
                        }
                        list[2] -> {
                            navController.navigate(BasicScreens.PermissionHandler.route)
                        }
                        list[3] -> {
                            navController.navigate(BasicScreens.Preview.route)
                        }
                        list[4] -> {
                            navController.navigate(BasicScreens.BottomNav.route)
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
        composable(route = BasicScreens.PermissionHandler.route) {
            PermissionScreen(
                onClickEvent = {
                    navController.navigate(BasicScreens.Basic.route)
                }
            )
        }
        composable(route = BasicScreens.Preview.route) {
            PreviewScreen(
                onBackPress = {
                    navController.navigate(BasicScreens.Basic.route)
                }
            )
        }
        composable(route = BasicScreens.BottomNav.route) {
            BottomNavigationScreen(
                onBackPress = {
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
    object PermissionHandler : BasicScreens(route = "PERMISSION")
    object Preview : BasicScreens(route = "PREVIEW")
    object BottomNav : BasicScreens(route = "BOTTOM")
}