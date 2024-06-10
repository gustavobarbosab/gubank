package com.github.gustavobarbosab.androidcourse.ui.screen.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator

object LoginEntryPointRoute : Route {
    override val name: String = "LoginEntryPointRoute"
}

fun NavGraphBuilder.loginGraph(flowNavigator: FlowNavigator) {
    navigation(
        route = LoginEntryPointRoute.name,
        startDestination = LoginRoute.name
    ) {
        composable(LoginRoute.name) {
            HomeDestination(flowNavigator = flowNavigator)
        }
    }
}