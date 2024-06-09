package com.github.gustavobarbosab.androidcourse.ui.navigation.navigator

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route

interface FlowNavigator {
    val navController: NavHostController
    val parentNavigator: FlowNavigator?
    fun navigate(
        destination: Route,
        navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null
    )

    fun navigateUp()

    fun backStackEntry(route: String): NavBackStackEntry
}