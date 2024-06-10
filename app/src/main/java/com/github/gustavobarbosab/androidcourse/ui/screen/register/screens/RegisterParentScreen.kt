package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.github.gustavobarbosab.androidcourse.ui.common.components.AppToolbar
import com.github.gustavobarbosab.androidcourse.ui.common.transition.slideIntoContainerToLeft
import com.github.gustavobarbosab.androidcourse.ui.common.transition.slideIntoContainerToRight
import com.github.gustavobarbosab.androidcourse.ui.common.transition.slideOutOfContainerToLeft
import com.github.gustavobarbosab.androidcourse.ui.common.transition.slideOutOfContainerToRight
import com.github.gustavobarbosab.androidcourse.ui.common.transition.standardSlideIntoContainer
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.subgraph.RegisterNameRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.registerSubGraph

@Composable
fun RegisterParentScreen(
    flowNavigator: FlowNavigator,
    sharedViewModel: RegisterFlowViewModel,
    repository: RegisterFlowRepository
) {
    val toolbarState by sharedViewModel.toolbarState.collectAsState()

    Column {
        AppToolbar(
            title = toolbarState.title,
            onBackButtonClicked = flowNavigator::navigateUp,
            icon = toolbarState.icon
        )
        // TODO -- Add the progress here
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = flowNavigator.navController,
            startDestination = RegisterNameRoute.name,
            enterTransition = { slideIntoContainerToLeft() },
            exitTransition = { slideOutOfContainerToLeft() },
            popEnterTransition = { slideIntoContainerToRight() },
            popExitTransition = { slideOutOfContainerToRight() }

        ) {
            registerSubGraph(
                flowNavigator,
                sharedViewModel,
                repository
            )
        }
    }
}
