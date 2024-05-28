package com.github.gustavobarbosab.androidcourse.ui.navigation.navigator

import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute

interface FlowNavigator {
    val navController: NavHostController
    val currentViewModelStoreOwner: ViewModelStoreOwner?
    val lastViewModelStore: ViewModelStoreOwner?

    fun navigate(
        route: NavigationRoute,
        navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null
    )

    fun navigateUp()
}