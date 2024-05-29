package com.github.gustavobarbosab.androidcourse.ui.navigation.navigator

import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Destination

interface FlowNavigator {
    val parentNavigator: FlowNavigator?

    fun navigate(
        destination: Destination,
        navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null
    )

    fun navigateUp()
}