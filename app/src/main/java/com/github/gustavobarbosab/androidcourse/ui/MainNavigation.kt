package com.github.gustavobarbosab.androidcourse.ui

import androidx.navigation.NavGraphBuilder
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.home.navigation.homeGraph
import com.github.gustavobarbosab.androidcourse.ui.screen.login.navigation.loginGraph
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.registerGraph

fun NavGraphBuilder.mainGraph(flowNavigator: FlowNavigator) {
    homeGraph(flowNavigator)
    loginGraph(flowNavigator)
    registerGraph(flowNavigator)
}