package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute

fun NavGraphBuilder.loginGraph(navController: NavController) {
    composable(NavigationRoute.Login.name) {
        LoginScreen(navController)
    }
}