package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterBirthdateDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterBirthdateRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterDocumentDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterDocumentRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterEntryPointRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterNameDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterNameRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterParentDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterParentRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterResumeDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterResumeRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModel

fun NavGraphBuilder.registerGraph(flowNavigator: FlowNavigator) {
    navigation(
        route = RegisterEntryPointRoute.name,
        startDestination = RegisterParentRoute.name
    ) {
        composable(RegisterParentRoute.name) {
            RegisterParentDestination(navigator = flowNavigator)
        }
    }
}

fun NavGraphBuilder.registerSubGraph(
    flowNavigator: FlowNavigator,
    sharedViewModel: RegisterFlowViewModel,
    repository: RegisterFlowRepository,
) {
    composable(RegisterNameRoute.name) {
        RegisterNameDestination(
            repository,
            flowNavigator,
            sharedViewModel
        )
    }
    composable(RegisterBirthdateRoute.name) {
        RegisterBirthdateDestination(
            repository,
            flowNavigator,
            sharedViewModel
        )
    }
    composable(RegisterDocumentRoute.name) {
        RegisterDocumentDestination(
            repository,
            flowNavigator,
            sharedViewModel
        )
    }
    composable(RegisterResumeRoute.name) {
        RegisterResumeDestination(
            repository,
            flowNavigator,
            sharedViewModel
        )
    }
}