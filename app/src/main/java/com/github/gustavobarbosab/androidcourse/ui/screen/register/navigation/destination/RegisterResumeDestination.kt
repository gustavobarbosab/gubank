package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepositoryImpl
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
    sharedViewModel: RegisterFlowViewModel
) {
    val viewModel: RegisterResumeViewModel = viewModel(factory = provideFactory(repository))

    RegisterResumeScreen(
        viewModel = viewModel,
        sharedViewModel = sharedViewModel,
        onFinishRegistration = {
            flowNavigator.navigateUp()
        }
    )
}