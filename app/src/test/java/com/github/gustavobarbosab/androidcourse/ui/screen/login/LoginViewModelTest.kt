package com.github.gustavobarbosab.androidcourse.ui.screen.login

import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.InputValidationState
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
        val state = viewModel.uiState.first()

        // THEN
        assertThat(state.username, emptyString())
        assertThat(state.password, emptyString())
        assertThat(state.usernameValidation, instanceOf(InputValidationState.InvalidField::class.java))
        assertThat(state.passwordValidation, instanceOf(InputValidationState.InvalidField::class.java))
    }

    @Test
    fun `when the user click to login and password is invalid`() = runTest {
        // GIVEN
        viewModel.usernameChanged("teste@aa.com")

        // WHEN
        viewModel.onClickToLogin()
        val state = viewModel.uiState.first()

        // THEN
        assertThat(state.username, equalTo("teste@aa.com"))
        assertThat(state.password, emptyString())
        assertThat(state.usernameValidation, instanceOf(InputValidationState.ValidField::class.java))
        assertThat(state.passwordValidation, instanceOf(InputValidationState.InvalidField::class.java))
    }

    @Test
    fun `when the user click to login and username is invalid`() = runTest {
        // GIVEN
        viewModel.passwordChanged("teste")

        // WHEN
        viewModel.onClickToLogin()
        val state = viewModel.uiState.first()

        // THEN
        assertThat(state.username, emptyString())
        assertThat(state.password, equalTo("teste"))
        assertThat(state.usernameValidation, instanceOf(InputValidationState.InvalidField::class.java))
        assertThat(state.passwordValidation, instanceOf(InputValidationState.ValidField::class.java))
    }

    @Test
    fun `when the user click to login all fields are valid`() = runTest {
        // GIVEN
        viewModel.usernameChanged("teste@aa.com")
        viewModel.passwordChanged("teste")

        // WHEN
        viewModel.onClickToLogin()
        val state = viewModel.uiState.first()

        // THEN
        assertThat(state.username, equalTo("teste@aa.com"))
        assertThat(state.password, equalTo("teste"))
        assertThat(state.usernameValidation, instanceOf(InputValidationState.ValidField::class.java))
        assertThat(state.passwordValidation, instanceOf(InputValidationState.ValidField::class.java))
    }
}