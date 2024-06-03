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
        destination: Destination,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ) {
        navController.navigate(
            destination.route,
            navOptions,
            navigatorExtras
        )
    }

    override fun navigateUp() {
        val navigatedUp = navController.navigateUp()
        if (!navigatedUp) parentNavigator?.navigateUp()
    }
}