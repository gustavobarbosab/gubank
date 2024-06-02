package com.github.gustavobarbosab.androidcourse.ui.screen.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.R
import com.github.gustavobarbosab.androidcourse.ui.common.ScopedViewModelStoreOwner
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Destination
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigatorImpl
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterDestination.NestedDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterScreenState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.address.RegisterAddressScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthday.RegisterBirthdayScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document.RegisterDocumentScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.RegisterNameScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.RegisterNameViewModel

data object RegisterDestination : Destination {

    override val route: String = "REGISTER"

    object NestedDestination {
        val registerNameRoute = object : Destination {
            override val route: String = "REGISTER_NAME"
        }

        val registerBirthdayRoute = object : Destination {
            override val route: String = "REGISTER_BIRTHDAY"
        }

        val registerDocumentRoute = object : Destination {
            override val route: String = "REGISTER_DOCUMENT"
        }

        val registerAddressRoute = object : Destination {
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
    val sharedViewModel = viewModel<RegisterFlowViewModel>(scopedViewModelStore)

    NavHost(
        navController = registerFlowNavController,
        startDestination = NestedDestination.registerNameRoute.route,
    ) {
        composable(NestedDestination.registerNameRoute.route) {
            val viewModel: RegisterNameViewModel = viewModel()

            val toolbar = stringResource(R.string.register_toolbar)
            val header = stringResource(R.string.register_name_header)
            val hint = stringResource(R.string.register_toolbar)
            val screenState = remember { RegisterScreenState(toolbar, header, hint) }

            RegisterNameScreen(
                parentViewModel = sharedViewModel,
                viewModel = viewModel,
                screenState = screenState,
                onBackButtonClicked = parentNavigator::navigateUp,
                goToBirthdayScreen = {
                    registerFlowNavigator.navigate(NestedDestination.registerBirthdayRoute)
                }
            )
        }
        composable(NestedDestination.registerBirthdayRoute.route) {
            RegisterBirthdayScreen(
                registerFlowViewModel = sharedViewModel,
                navigateToDocumentScreen = {
                    registerFlowNavigator.navigate(NestedDestination.registerDocumentRoute)
                }
            )
        }
        composable(NestedDestination.registerDocumentRoute.route) {
            RegisterDocumentScreen(
                registerFlowViewModel = sharedViewModel,
                navigateToAddressScreen = {
                    registerFlowNavigator.navigate(NestedDestination.registerAddressRoute)
                }
            )
        }
        composable(NestedDestination.registerAddressRoute.route) {
            RegisterAddressScreen(
                registerFlowViewModel = sharedViewModel,
                onFinishRegistration = {
                    parentNavigator.navigateUp()
                }
            )
        }
    }
}