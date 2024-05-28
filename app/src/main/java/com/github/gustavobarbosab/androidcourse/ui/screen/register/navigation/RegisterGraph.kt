package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.RegisterFlow

fun NavGraphBuilder.registerGraph(
    appNavigator: FlowNavigator
) {
    composable(RegisterRoute.name) {
        RegisterFlow(appNavigator)
    }
}