package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.LoginScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.LoginViewModel

object LoginRoute : Route {
    override val name: String = "LOGIN"
}

@Composable
fun LoginRoute(parentNavigator: FlowNavigator) {
    val viewModel = viewModel<LoginViewModel>()
    LoginScreen(
        parentNavigator = parentNavigator,
        viewModel
    )
}

