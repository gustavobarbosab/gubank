package com.github.gustavobarbosab.androidcourse.ui.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator

@Composable
fun LaunchNavigation(
    navigationStateOwner: NavigationStateOwner,
    navigator: FlowNavigator,
) {
    val state by navigationStateOwner.destinationState.collectAsState()
    LaunchedEffect(state) {
        val destination = state ?: return@LaunchedEffect
        navigator.navigate(destination)
        navigationStateOwner.onNavigationDone()
    }
}