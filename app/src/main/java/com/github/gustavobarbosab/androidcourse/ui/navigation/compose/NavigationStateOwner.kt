package com.github.gustavobarbosab.androidcourse.ui.navigation.compose

import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import kotlinx.coroutines.flow.StateFlow

interface NavigationStateOwner {
    val destinationState: StateFlow<Route?>
    fun onNavigationDone()
}