package com.github.gustavobarbosab.androidcourse.ui.screen.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.login.LoginScreen

fun NavGraphBuilder.loginGraph(parentNavigator: FlowNavigator) {
    composable(LoginRoute.name) {
        LoginScreen(parentNavigator)
    }
}