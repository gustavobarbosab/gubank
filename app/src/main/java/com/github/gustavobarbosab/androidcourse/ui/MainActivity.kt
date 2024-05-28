package com.github.gustavobarbosab.androidcourse.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute
import com.github.gustavobarbosab.androidcourse.ui.common.theme.AndroidCourseTheme
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.AppNavigator
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.AppNavigatorImpl
import com.github.gustavobarbosab.androidcourse.ui.screen.home.homeGraph
import com.github.gustavobarbosab.androidcourse.ui.screen.login.loginGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseTheme {
                val navController = rememberNavController()
                val appNavigator = remember<AppNavigator> { AppNavigatorImpl(navController) }
                NavHost(
                    navController = navController,
                    startDestination = NavigationRoute.Login.name
                ) {
                    homeGraph(appNavigator)
                    loginGraph(appNavigator)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidCourseTheme {
        Greeting("Android")
    }
}