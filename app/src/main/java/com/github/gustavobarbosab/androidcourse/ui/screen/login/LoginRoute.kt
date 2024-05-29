package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Destination
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator

object LoginDestination : Destination {
    override val route: String = "LOGIN"
}

@Composable
fun LoginRoute(parentNavigator: FlowNavigator) {
    val viewModel = viewModel<LoginViewModel>()
    LoginScreen(
        parentNavigator = parentNavigator,
        viewModel
    )
}

