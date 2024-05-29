package com.github.gustavobarbosab.androidcourse.ui.screen.home

import androidx.compose.runtime.Composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Destination
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator

data object HomeDestination : Destination {
    override val route: String = "HOME"
}

@Composable
fun HomeRoute(parentNavigator: FlowNavigator) {
    HomeScreen(parentNavigator = parentNavigator)
}