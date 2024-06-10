package com.github.gustavobarbosab.androidcourse.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.home.HomeRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.login.navigation.loginGraph
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.registerGraph

fun NavGraphBuilder.mainGraph(flowNavigator: FlowNavigator) {
    composable(HomeRoute.name) {
        HomeRoute(flowNavigator)
    }
    loginGraph(flowNavigator)
    registerGraph(flowNavigator)
}