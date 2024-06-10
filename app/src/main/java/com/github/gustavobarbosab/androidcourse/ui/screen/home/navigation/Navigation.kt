package com.github.gustavobarbosab.androidcourse.ui.screen.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator

data object HomeEntryPointRoute : Route {
    override val name: String = "HomeEntryPointRoute"
}

fun NavGraphBuilder.homeGraph(flowNavigator: FlowNavigator) {
    navigation(
        route = HomeEntryPointRoute.name,
        startDestination = HomeRoute.name
    ) {
        composable(HomeRoute.name) {
            HomeDestination(flowNavigator = flowNavigator)
        }
    }
}