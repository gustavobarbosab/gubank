package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModelFactory.provideFactory
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthdate.RegisterBirthdateScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthdate.RegisterBirthdateViewModel

object RegisterBirthdateRoute : Route {
    override val name: String = "RegisterBirthdateRoute"
}

@Composable
fun RegisterBirthdateDestination(
    repository: RegisterFlowRepository,
    flowNavigator: FlowNavigator,
    sharedViewModel: RegisterFlowViewModel
) {
    val viewModel: RegisterBirthdateViewModel = viewModel(factory = provideFactory(repository))

    RegisterBirthdateScreen(
        viewModel = viewModel,
        sharedViewModel = sharedViewModel,
        navigateToDocumentScreen = {
            flowNavigator.navigate(RegisterDocumentRoute)
        }
    )
}