package com.github.gustavobarbosab.androidcourse.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.ui.navigation.NavigationRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.home.HomeScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.login.LoginScreen
import com.github.gustavobarbosab.androidcourse.ui.common.theme.AndroidCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = NavigationRoute.Login.route ) {
                    composable(NavigationRoute.Login.route) {
                        LoginScreen(navController)
                    }
                    composable(NavigationRoute.Home.route) {
                        HomeScreen(navController)
                    }
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