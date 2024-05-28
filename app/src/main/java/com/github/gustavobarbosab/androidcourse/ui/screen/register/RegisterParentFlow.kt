package com.github.gustavobarbosab.androidcourse.ui.screen.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.ui.common.ScopedViewModelStoreOwner
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigatorImpl
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.RegisterNestedRoutes
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.address.RegisterAddressScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthday.RegisterBirthdayScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document.RegisterDocumentScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.RegisterNameScreen

@Composable
fun RegisterParentFlow(parentNavigator: FlowNavigator) {

    val navControllerRegisterFlow = rememberNavController()
    val registerFlowNavigator: FlowNavigator = FlowNavigatorImpl(
        navControllerRegisterFlow,
        parentNavigator
    )
    val scopedViewModelStore = remember { ScopedViewModelStoreOwner() }

    NavHost(
        navController = navControllerRegisterFlow,
        startDestination = RegisterNestedRoutes.registerNameRoute.name,
    ) {
        composable(RegisterNestedRoutes.registerNameRoute.name) {
            RegisterNameScreen(registerFlowNavigator, viewModel(scopedViewModelStore))
        }
        composable(RegisterNestedRoutes.registerBirthdayRoute.name) {
            RegisterBirthdayScreen(registerFlowNavigator, viewModel(scopedViewModelStore))
        }
        composable(RegisterNestedRoutes.registerDocumentRoute.name) {
            RegisterDocumentScreen(registerFlowNavigator, viewModel(scopedViewModelStore))
        }
        composable(RegisterNestedRoutes.registerAddressRoute.name) {
            RegisterAddressScreen(registerFlowNavigator, viewModel(scopedViewModelStore))
        }
    }
}