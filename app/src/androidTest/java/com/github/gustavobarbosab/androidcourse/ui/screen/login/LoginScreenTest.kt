package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.github.gustavobarbosab.androidcourse.ui.common.theme.AndroidCourseTheme
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.LoginScreen
import com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.LoginViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.model.LoginTestTags
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val navController = mockk<FlowNavigator>(relaxed = true)
    private val viewModel = spyk(LoginViewModel())

    @Test
    fun testingStartScreenWithInvalidInputs() {
        composeTestRule.setContent {
            AndroidCourseTheme {
                LoginScreen(
                    navController,
                    viewModel
                )
            }
        }

        with(composeTestRule) {
            onNodeWithTag(LoginTestTags.USERNAME_FIELD)
                .performTextInput("")

            onNodeWithTag(LoginTestTags.PASSWORD_FIELD)
                .performTextInput("")

            onNodeWithTag(LoginTestTags.LOGIN_BUTTON)
                .performClick()

            onNodeWithTag(LoginTestTags.USERNAME_FIELD)
                .assertTextContains("Nome de usuário inválido")

            onNodeWithTag(LoginTestTags.PASSWORD_FIELD)
                .assertTextContains("Senha inválida")
        }


        verify {
            viewModel.usernameState
            viewModel.passwordState
            viewModel.feedbackState
            viewModel.destinationState
            viewModel.onClickToLogin()
        }
    }

    @Test
    fun testingStartScreenWithValidInputs() {
        composeTestRule.setContent {
            AndroidCourseTheme {
                LoginScreen(
                    navController,
                    viewModel
                )
            }
        }

        with(composeTestRule) {
            onNodeWithTag(LoginTestTags.USERNAME_FIELD)
                .performTextInput("gustavo@aa.com")

            onNodeWithTag(LoginTestTags.PASSWORD_FIELD)
                .performTextInput("12123")

            onNodeWithTag(LoginTestTags.LOGIN_BUTTON)
                .performClick()

            onNodeWithText("Login feito com sucesso")
                .assertIsDisplayed()
        }


        verify {
            viewModel.usernameState
            viewModel.passwordState
            viewModel.feedbackState
            viewModel.destinationState
            viewModel.onClickToLogin()
        }
    }
}