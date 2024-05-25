package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.hasAnyDescendant
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavHostController
import com.github.gustavobarbosab.androidcourse.ui.theme.AndroidCourseTheme
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val navController = mockk<NavHostController>(relaxed = true)
    private val viewModel = spyk(LoginViewModel())

    @Test
    fun testingStartScreenWithInvalidInputs() {
        // Start the app
        composeTestRule.setContent {
            AndroidCourseTheme {
                LoginScreen(
                    navController,
                    viewModel
                )
            }
        }

        with(composeTestRule) {
            onNodeWithTag("USERNAME_INPUT")
                .performTextInput("")

            onNodeWithTag("PASSWORD_INPUT")
                .performTextInput("")

            onNodeWithTag("LOGIN_BUTTON")
                .performClick()

            onNodeWithTag("USERNAME_INPUT")
                .assertTextContains("Nome de usuário inválido")

            onNodeWithTag("PASSWORD_INPUT")
                .assertTextContains("Senha inválida")
        }


        verify {
            viewModel.uiState
            viewModel.feedbackState
            viewModel.onClickToLogin()
        }
    }

    @Test
    fun testingStartScreenWithValidInputs() {
        // Start the app
        composeTestRule.setContent {
            AndroidCourseTheme {
                LoginScreen(
                    navController,
                    viewModel
                )
            }
        }

        with(composeTestRule) {
            onNodeWithTag("USERNAME_INPUT")
                .performTextInput("gustavo@aa.com")

            onNodeWithTag("PASSWORD_INPUT")
                .performTextInput("12123")

            onNodeWithTag("LOGIN_BUTTON")
                .performClick()

            onNodeWithText("Login feito com sucesso")
                .assertIsDisplayed()
        }


        verify {
            viewModel.uiState
            viewModel.feedbackState
            viewModel.onClickToLogin()
        }
    }
}