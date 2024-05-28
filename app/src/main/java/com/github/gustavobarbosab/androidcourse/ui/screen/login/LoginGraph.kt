package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.AppNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute

fun NavGraphBuilder.loginGraph(navigator: AppNavigator) {
    composable(NavigationRoute.Login.name) {
        LoginScreen(navigator)
    }
}