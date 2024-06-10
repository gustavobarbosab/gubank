package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModelFactory.provideFactory
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume.RegisterResumeScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume.RegisterResumeViewModel

object RegisterResumeRoute : Route {
    override val name: String = "RegisterResumeRoute"
}

@Composable
fun RegisterResumeDestination(
    repository: RegisterFlowRepository,
    flowNavigator: FlowNavigator,
    sharedViewModel: RegisterFlowViewModel,
    backStackEntry: NavBackStackEntry
) {
    val viewModel: RegisterResumeViewModel = viewModel(
        factory = provideFactory(repository),
        viewModelStoreOwner = backStackEntry
    )

    RegisterResumeScreen(
        viewModel = viewModel,
        sharedViewModel = sharedViewModel,
        onFinishRegistration = {
            flowNavigator.navigateUp()
        }
    )
}