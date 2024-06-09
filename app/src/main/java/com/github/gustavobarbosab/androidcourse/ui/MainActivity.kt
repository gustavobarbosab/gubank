package com.github.gustavobarbosab.androidcourse.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.ui.common.theme.AndroidCourseTheme
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigatorImpl
import com.github.gustavobarbosab.androidcourse.ui.screen.home.HomeRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.login.LoginRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.registerGraph
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterParentScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseTheme {
                val navController = rememberNavController()
                val parentNavigator = remember<FlowNavigator> { FlowNavigatorImpl(navController) }

                NavHost(
                    navController = navController,
                    startDestination = LoginRoute.name
                ) {
                    composable(HomeRoute.name) {
                        HomeRoute(parentNavigator)
                    }
                    composable(LoginRoute.name) {
                        LoginRoute(parentNavigator)
                    }
                    registerGraph(parentNavigator)
                }
            }
        }
    }
}
