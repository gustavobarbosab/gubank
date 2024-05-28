package com.github.gustavobarbosab.androidcourse.ui.screen.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.AppNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute

fun NavGraphBuilder.homeGraph(navigator: AppNavigator) {
    composable(NavigationRoute.Home.name) {
        HomeScreen(navigator)
    }
}