package com.github.gustavobarbosab.androidcourse.ui.navigation.route

sealed class NavigationRoute(val name: String) {
    data object Login: NavigationRoute("LOGIN")
    data object Home: NavigationRoute("HOME")
}