package com.github.gustavobarbosab.androidcourse.ui.screen.home.navigation

import androidx.compose.runtime.Composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.home.screen.HomeScreen

data object HomeRoute : Route {
    override val name: String = "HomeRoute"
}

@Composable
fun HomeDestination(flowNavigator: FlowNavigator) {
    HomeScreen(parentNavigator = flowNavigator)
}