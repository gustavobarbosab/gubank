package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModelFactory.provideFactory
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document.RegisterDocumentScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document.RegisterDocumentViewModel

object RegisterDocumentRoute : Route {
    override val name: String = "RegisterDocumentRoute"
}

@Composable
fun RegisterDocumentDestination(
    repository: RegisterFlowRepository,
    flowNavigator: FlowNavigator,
    sharedViewModel: RegisterFlowViewModel,
    backStackEntry: NavBackStackEntry
) {
    val viewModel: RegisterDocumentViewModel = viewModel(
        factory = provideFactory(repository),
        viewModelStoreOwner = backStackEntry
    )

    RegisterDocumentScreen(
        viewModel = viewModel,
        sharedViewModel = sharedViewModel,
        navigateToResumeScreen = {
            flowNavigator.navigate(RegisterResumeRoute)
        }
    )
}