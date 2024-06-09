package com.github.gustavobarbosab.androidcourse.ui.screen.home

import androidx.compose.runtime.Composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.home.screen.HomeScreen

data object HomeRoute : Route {
    override val name: String = "HOME"
}

@Composable
fun HomeRoute(parentNavigator: FlowNavigator) {
    HomeScreen(parentNavigator = parentNavigator)
}