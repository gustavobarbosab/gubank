package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterParentFlow

fun NavGraphBuilder.registerGraph(
    parentNavigator: FlowNavigator
) {
    composable(RegisterRoute.name) {
        RegisterParentFlow(parentNavigator)
    }
}