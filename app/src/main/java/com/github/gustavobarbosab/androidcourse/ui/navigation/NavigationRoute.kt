package com.github.gustavobarbosab.androidcourse.ui.navigation

sealed class NavigationRoute(val route: String) {
    data object Login: NavigationRoute("LOGIN")
    data object Home: NavigationRoute("HOME")
}