package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph.RegisterBirthdateDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph.RegisterBirthdateRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph.RegisterDocumentDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph.RegisterDocumentRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterEntryPointRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph.RegisterNameDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph.RegisterNameRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterParentDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterParentRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph.RegisterResumeDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph.RegisterResumeRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModel

fun NavGraphBuilder.registerGraph(flowNavigator: FlowNavigator) {
    navigation(
        route = RegisterEntryPointRoute.name,
        startDestination = RegisterParentRoute.name
    ) {
        composable(RegisterParentRoute.name) { backStackEntry ->
            RegisterParentDestination(
                navigator = flowNavigator,
                viewModelStoreOwner = backStackEntry
            )
        }
    }
}

fun NavGraphBuilder.registerSubGraph(
    flowNavigator: FlowNavigator,
    sharedViewModel: RegisterFlowViewModel,
    repository: RegisterFlowRepository,
) {
    composable(RegisterNameRoute.name) { backStackEntry ->
        RegisterNameDestination(
            repository,
            flowNavigator,
            sharedViewModel,
            backStackEntry
        )
    }
    composable(RegisterBirthdateRoute.name) { backStackEntry ->
        RegisterBirthdateDestination(
            repository,
            flowNavigator,
            sharedViewModel,
            backStackEntry
        )
    }
    composable(RegisterDocumentRoute.name) { backStackEntry ->
        RegisterDocumentDestination(
            repository,
            flowNavigator,
            sharedViewModel,
            backStackEntry
        )
    }
    composable(RegisterResumeRoute.name) { backStackEntry ->
        RegisterResumeDestination(
            repository,
            flowNavigator,
            sharedViewModel,
            backStackEntry
        )
    }
}