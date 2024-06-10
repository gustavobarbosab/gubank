package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigatorImpl
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepositoryImpl
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModelFactory
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterParentScreen

object RegisterEntryPointRoute : Route {
    override val name: String = "RegisterEntryPointRoute"
}

object RegisterParentRoute : Route {
    override val name: String = "RegisterParentRoute"
}

@Composable
fun RegisterParentDestination(
    viewModelStoreOwner: ViewModelStoreOwner,
    navigator: FlowNavigator
) {
    val registerFlowNavController = rememberNavController()
    val registerFlowNavigator = remember<FlowNavigator> {
        FlowNavigatorImpl(registerFlowNavController, navigator)
    }
    val repository: RegisterFlowRepository = remember {
        RegisterFlowRepositoryImpl()
    }
    val sharedViewModel = viewModel<RegisterFlowViewModel>(
        viewModelStoreOwner = viewModelStoreOwner,
        factory = RegisterFlowViewModelFactory.provideFactory(repository)
    )

    RegisterParentScreen(
        flowNavigator = registerFlowNavigator,
        sharedViewModel = sharedViewModel,
        repository = repository,
    )
}