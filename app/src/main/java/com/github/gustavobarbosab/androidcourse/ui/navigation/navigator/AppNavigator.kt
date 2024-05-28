package com.github.gustavobarbosab.androidcourse.ui.navigation.navigator

import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute

interface AppNavigator {
    fun navigate(
        route: NavigationRoute,
        navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null
    )

    fun navigateUp()
}