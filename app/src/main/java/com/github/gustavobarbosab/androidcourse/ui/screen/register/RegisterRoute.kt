package com.github.gustavobarbosab.androidcourse.ui.screen.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.ui.common.viewmodel.ScopedViewModelStoreOwner
import com.github.gustavobarbosab.androidcourse.ui.common.components.AppToolbar
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Destination
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigatorImpl
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterDestination.NestedDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterFlowViewModelFactory.provideFactory
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepositoryImpl
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume.RegisterResumeScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthdate.RegisterBirthdateScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document.RegisterDocumentScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.RegisterNameScreen

data object RegisterDestination : Destination {

    override val route: String = "REGISTER"

    object NestedDestination {
        val registerNameRoute = object : Destination {
            override val route: String = "REGISTER_NAME"
        }

        val registerBirthdateRoute = object : Destination {
            override val route: String = "REGISTER_BIRTHDATE"
        }

        val registerDocumentRoute = object : Destination {
            override val route: String = "REGISTER_DOCUMENT"
        }

        val registerResumeRoute = object : Destination {
            override val route: String = "REGISTER_ADDRESS"
        }
    }
}

@Composable
fun RegisterRoute(parentNavigator: FlowNavigator) {
    val registerFlowNavController = rememberNavController()
    val registerFlowNavigator = remember<FlowNavigator> {
        FlowNavigatorImpl(
            registerFlowNavController,
            parentNavigator
        )
    }
    val scopedViewModelStore = remember { ScopedViewModelStoreOwner() }
    val repository: RegisterFlowRepository = remember {
        RegisterFlowRepositoryImpl()
    }
    val sharedViewModel = viewModel<RegisterFlowViewModel>(
        viewModelStoreOwner = scopedViewModelStore,
        factory = RegisterFlowViewModel.provideFactory(repository)
    )

    val toolbarState by sharedViewModel.toolbarState.collectAsState()

    Column {
        AppToolbar(
            title = toolbarState.title,
            onBackButtonClicked = registerFlowNavigator::navigateUp,
            icon = toolbarState.icon
        )
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = registerFlowNavController,
            startDestination = NestedDestination.registerNameRoute.route,
        ) {
            createRegisterNavGraph(
                parentNavigator,
                registerFlowNavigator,
                sharedViewModel,
                repository
            )
        }
    }

}

private fun NavGraphBuilder.createRegisterNavGraph(
    parentNavigator: FlowNavigator,
    registerFlowNavigator: FlowNavigator,
    sharedViewModel: RegisterFlowViewModel,
    repository: RegisterFlowRepository,
) {
    composable(NestedDestination.registerNameRoute.route) {
        RegisterNameScreen(
            viewModel = viewModel(factory = provideFactory(repository)),
            sharedViewModel = sharedViewModel,
            navigateToBirthdayScreen = {
                registerFlowNavigator.navigate(NestedDestination.registerBirthdateRoute)
            }
        )
    }
    composable(NestedDestination.registerBirthdateRoute.route) {
        RegisterBirthdateScreen(
            viewModel = viewModel(factory = provideFactory(repository)),
            sharedViewModel = sharedViewModel,
            navigateToDocumentScreen = {
                registerFlowNavigator.navigate(NestedDestination.registerDocumentRoute)
            }
        )
    }
    composable(NestedDestination.registerDocumentRoute.route) {
        RegisterDocumentScreen(
            sharedViewModel = sharedViewModel,
            viewModel = viewModel(factory = provideFactory(repository)),
            navigateToResumeScreen = {
                registerFlowNavigator.navigate(NestedDestination.registerResumeRoute)
            }
        )
    }
    composable(NestedDestination.registerResumeRoute.route) {
        RegisterResumeScreen(
            sharedViewModel = sharedViewModel,
            viewModel = viewModel(factory = provideFactory(repository)),
            onFinishRegistration = {
                parentNavigator.navigateUp()
            }
        )
    }
}
