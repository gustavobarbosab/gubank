package com.github.gustavobarbosab.androidcourse.ui.navigation.navigator

import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route

class FlowNavigatorImpl(
    override val navController: NavHostController,
    override var parentNavigator: FlowNavigator? = null
) : FlowNavigator {

    override fun navigate(
        destination: Route,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ) {
        navController.navigate(
            destination.name,
            navOptions,
            navigatorExtras
        )
    }

    override fun navigateUp() {
        val navigatedUp = navController.navigateUp()
        if (!navigatedUp) parentNavigator?.navigateUp()
    }

    override fun backStackEntry(route: String) = navController.getBackStackEntry(route)
}
