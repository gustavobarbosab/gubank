package com.github.gustavobarbosab.androidcourse.ui.screen.login

import com.github.gustavobarbosab.androidcourse.ui.common.widgets.InputValidationState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.emptyString
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.instanceOf
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    private val viewModel = LoginViewModel()

    @Test
    fun `when the user click to login and the fields are invalid`() = runTest {
        // WHEN
        viewModel.onClickToLogin()

        val usernameState = viewModel.usernameState.first()
        val passwordState = viewModel.passwordState.first()

        // THEN
        assertThat(usernameState.value, emptyString())
        assertThat(
            usernameState.validation,
            instanceOf(InputValidationState.InvalidField::class.java)
        )
        assertThat(passwordState.value, emptyString())
        assertThat(
            passwordState.validation,
            instanceOf(InputValidationState.InvalidField::class.java)
        )
    }

    @Test
    fun `when the user click to login and password is invalid`() = runTest {
        // GIVEN
        viewModel.usernameChanged("teste@aa.com")

        // WHEN
        viewModel.onClickToLogin()

        val usernameState = viewModel.usernameState.first()
        val passwordState = viewModel.passwordState.first()

        // THEN
        assertThat(usernameState.value, equalTo("teste@aa.com"))
        assertThat(passwordState.value, emptyString())
        assertThat(
            usernameState.validation,
            instanceOf(InputValidationState.ValidField::class.java)
        )
        assertThat(
            passwordState.validation,
            instanceOf(InputValidationState.InvalidField::class.java)
        )
    }

    @Test
    fun `when the user click to login and username is invalid`() = runTest {
        // GIVEN
        viewModel.passwordChanged("teste")

        // WHEN
        viewModel.onClickToLogin()

        val usernameState = viewModel.usernameState.first()
        val passwordState = viewModel.passwordState.first()

        // THEN
        assertThat(usernameState.value, emptyString())
        assertThat(passwordState.value, equalTo("teste"))
        assertThat(
            usernameState.validation,
            instanceOf(InputValidationState.InvalidField::class.java)
        )
        assertThat(
            passwordState.validation,
            instanceOf(InputValidationState.ValidField::class.java)
        )
    }

    @Test
    fun `when the user click to login all fields are valid`() = runTest {
        // GIVEN
        viewModel.usernameChanged("teste@aa.com")
        viewModel.passwordChanged("teste")

        // WHEN
        viewModel.onClickToLogin()

        val usernameState = viewModel.usernameState.first()
        val passwordState = viewModel.passwordState.first()

        // THEN
        assertThat(usernameState.value, equalTo("teste@aa.com"))
        assertThat(passwordState.value, equalTo("teste"))
        assertThat(
            usernameState.validation,
            instanceOf(InputValidationState.ValidField::class.java)
        )
        assertThat(
            passwordState.validation,
            instanceOf(InputValidationState.ValidField::class.java)
        )
    }
}