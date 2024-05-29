package com.github.gustavobarbosab.androidcourse.ui.navigation.navigator

import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Destination

class FlowNavigatorImpl(
    private val navController: NavHostController,
    override var parentNavigator: FlowNavigator? = null
) : FlowNavigator {

    override fun navigate(
        route: Destination,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ) {
        navController.navigate(
            route.route,
            navOptions,
            navigatorExtras
        )
    }

    override fun navigateUp() {
        navController.navigateUp()
    }
}