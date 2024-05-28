package com.github.gustavobarbosab.androidcourse.ui.navigation.navigator

import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute

class FlowNavigatorImpl(
    private val navController: NavHostController,
    override var parentNavigator: FlowNavigator? = null
) : FlowNavigator {

    override fun navigate(
        route: NavigationRoute,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ) {
        navController.navigate(
            route.name,
            navOptions,
            navigatorExtras
        )
    }

    override fun navigateUp() {
        navController.navigateUp()
    }
}