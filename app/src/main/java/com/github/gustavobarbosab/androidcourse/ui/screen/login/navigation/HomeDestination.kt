package com.github.gustavobarbosab.androidcourse.ui.screen.login.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.LoginScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.LoginViewModel

object LoginRoute : Route {
    override val name: String = "LoginRoute"
}

@Composable
fun HomeDestination(flowNavigator: FlowNavigator) {
    val viewModel = viewModel<LoginViewModel>()
    LoginScreen(
        parentNavigator = flowNavigator,
        viewModel
    )
}