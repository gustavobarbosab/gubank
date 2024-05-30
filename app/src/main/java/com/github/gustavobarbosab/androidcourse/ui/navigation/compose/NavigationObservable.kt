package com.github.gustavobarbosab.androidcourse.ui.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.viewmodel.NavigationState

@Composable
fun LaunchNavigation(
    navigationState: NavigationState,
    navigator: FlowNavigator,
) {
    val state by navigationState.state.collectAsState()
    LaunchedEffect(state) {
        val destination = state ?: return@LaunchedEffect
        navigator.navigate(destination)
        navigationState.onNavigationDone()
    }
}