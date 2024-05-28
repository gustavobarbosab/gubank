package com.github.gustavobarbosab.androidcourse.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.ui.common.theme.AndroidCourseTheme
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigatorImpl
import com.github.gustavobarbosab.androidcourse.ui.screen.home.navigation.homeGraph
import com.github.gustavobarbosab.androidcourse.ui.screen.login.navigation.LoginRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.login.navigation.loginGraph
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.registerGraph

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
                    homeGraph(parentNavigator)
                    loginGraph(parentNavigator)
                    registerGraph(parentNavigator)
                }
            }
        }
    }
}
