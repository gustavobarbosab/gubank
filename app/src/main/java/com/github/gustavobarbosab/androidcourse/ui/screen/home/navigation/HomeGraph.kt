package com.github.gustavobarbosab.androidcourse.ui.screen.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.home.HomeScreen

fun NavGraphBuilder.homeGraph(navigator: FlowNavigator) {
    composable(HomeRoute.name) {
        HomeScreen(navigator)
    }
}