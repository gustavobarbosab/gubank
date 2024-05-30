package com.github.gustavobarbosab.androidcourse.ui.navigation.viewmodel

import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Destination
import kotlinx.coroutines.flow.StateFlow

interface NavigationState {
    val destinationState: StateFlow<Destination?>
    fun onNavigationDone()
}