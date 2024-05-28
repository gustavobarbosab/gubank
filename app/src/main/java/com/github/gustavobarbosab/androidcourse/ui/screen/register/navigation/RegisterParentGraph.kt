package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterParentFlow
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.RegisterParentFlowRoute

fun NavGraphBuilder.registerParentGraph(
    parentNavigator: FlowNavigator
) {
    composable(RegisterParentFlowRoute.name) {
        RegisterParentFlow(parentNavigator)
    }
}