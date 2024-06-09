package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModelFactory.provideFactory
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.RegisterNameScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.RegisterNameViewModel

object RegisterNameRoute : Route {
    override val name: String = "RegisterNameRoute"
}

@Composable
fun RegisterNameDestination(
    repository: RegisterFlowRepository,
    flowNavigator: FlowNavigator,
    sharedViewModel: RegisterFlowViewModel
) {
    val viewModel: RegisterNameViewModel = viewModel(factory = provideFactory(repository))

    RegisterNameScreen(
        viewModel = viewModel,
        sharedViewModel = sharedViewModel,
        navigateToBirthdayScreen = {
            flowNavigator.navigate(RegisterBirthdateRoute)
        }
    )
}