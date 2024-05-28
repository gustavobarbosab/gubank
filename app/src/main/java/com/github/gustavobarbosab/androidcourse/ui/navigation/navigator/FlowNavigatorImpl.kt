package com.github.gustavobarbosab.androidcourse.ui.navigation.navigator

import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute

class FlowNavigatorImpl(
    override val navController: NavHostController,
    var parentNavigator: FlowNavigator? = null
) : FlowNavigator {

    override val currentViewModelStoreOwner: ViewModelStoreOwner? =
        navController.currentBackStackEntry

    override val lastViewModelStore: ViewModelStoreOwner? = navController.currentBackStackEntry

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