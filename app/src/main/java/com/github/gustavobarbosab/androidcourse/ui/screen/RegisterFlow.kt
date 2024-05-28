package com.github.gustavobarbosab.androidcourse.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.ui.common.ScopedViewModelStoreOwner
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigatorImpl
import com.github.gustavobarbosab.androidcourse.ui.screen.register.address.RegisterAddressScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.birthday.RegisterBirthdayScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.document.RegisterDocumentScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.name.RegisterNameScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.RegisterRoute.NestedRoutes

@Composable
fun RegisterFlow(parentNavigator: FlowNavigator) {

    val navControllerBottomBar = rememberNavController()
    val flowNavigator: FlowNavigator = FlowNavigatorImpl(navControllerBottomBar, parentNavigator)
    val scopedViewModelStore = remember { ScopedViewModelStoreOwner() }

    NavHost(
        navController = flowNavigator.navController,
        startDestination = NestedRoutes.registerNameRoute.name,
    ) {
        composable(NestedRoutes.registerNameRoute.name) {
            RegisterNameScreen(
                flowNavigator,
                viewModel(scopedViewModelStore)
            )
        }
        composable(NestedRoutes.registerBirthdayRoute.name) {
            RegisterBirthdayScreen(
                flowNavigator,
                viewModel(scopedViewModelStore)
            )
        }
        composable(NestedRoutes.registerDocumentRoute.name) {
            RegisterDocumentScreen(
                flowNavigator,
                viewModel(scopedViewModelStore)
            )
        }
        composable(NestedRoutes.registerAddressRoute.name) {
            RegisterAddressScreen(
                flowNavigator,
                viewModel(scopedViewModelStore)
            )
        }
    }
}