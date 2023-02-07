package com.robustroutine.basics.screens.tabviewpager

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(val title: String, val icons: ImageVector, val screens: ComposableFun) {

    object Home : TabItem(
        title = "Home",
        icons = Icons.Default.Home,
        screens = { ScreenA() })

    object Cart : TabItem(
        title = "Cart",
        icons = Icons.Default.ShoppingCart,
        screens = { ScreenB() })

    object Profile : TabItem(
        title = "Profile",
        icons = Icons.Default.AccountCircle,
        screens = { ScreenC() })

}