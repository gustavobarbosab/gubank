package com.github.gustavobarbosab.androidcourse.ui.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute

fun NavGraphBuilder.homeGraph(navController: NavController) {
    composable(NavigationRoute.Home.name) {
        HomeScreen(navController)
    }
}