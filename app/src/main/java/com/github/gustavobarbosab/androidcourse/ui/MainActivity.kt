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
import com.github.gustavobarbosab.androidcourse.ui.screen.home.HomeDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.home.HomeRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.login.LoginDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.login.LoginRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterDestination
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseTheme {
                val navController = rememberNavController()
                val parentNavigator = remember<FlowNavigator> { FlowNavigatorImpl(navController) }

                NavHost(
                    navController = navController,
                    startDestination = LoginDestination.route
                ) {
                    composable(HomeDestination.route) {
                        HomeRoute(parentNavigator)
                    }
                    composable(LoginDestination.route) {
                        LoginRoute(parentNavigator)
                    }
                    composable(RegisterDestination.route) {
                        RegisterRoute(parentNavigator)
                    }
                }
            }
        }
    }
}
