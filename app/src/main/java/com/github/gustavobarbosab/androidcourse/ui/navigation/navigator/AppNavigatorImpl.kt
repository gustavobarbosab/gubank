package com.github.gustavobarbosab.androidcourse.ui.navigation.navigator

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute

class AppNavigatorImpl(private val navController: NavController) : AppNavigator {

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