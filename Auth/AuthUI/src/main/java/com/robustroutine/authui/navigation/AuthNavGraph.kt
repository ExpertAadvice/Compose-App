package com.robustroutine.authui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.robustroutine.authui.forget_pass.ForgetPasswordScreen
import com.robustroutine.authui.login.LoginScreen
import com.robustroutine.authui.register.RegisterScreen
import com.robustroutine.common.graph.Graphs

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graphs.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {

        composable(route = AuthScreen.Login.route) {
            LoginScreen(
                onLoginClick = {
                    navController.popBackStack()
                    navController.navigate(Graphs.HOME)
                },
                onForgetPassClick = {
                    navController.navigate(AuthScreen.ForgotPass.route)
                },
                onRegisterClick = {
                    navController.navigate(AuthScreen.Register.route)
                }
            )
        }
        composable(route = AuthScreen.Register.route) {
            RegisterScreen(
                onRegisterButtonClicked = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }
        composable(route = AuthScreen.ForgotPass.route) {
            ForgetPasswordScreen(
                onButtonClicked = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object Register : AuthScreen(route = "SIGN_UP")
    object ForgotPass : AuthScreen(route = "FORGOT")
}