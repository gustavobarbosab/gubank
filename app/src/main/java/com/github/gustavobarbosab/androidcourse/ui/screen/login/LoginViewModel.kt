package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.lifecycle.ViewModel
import com.github.gustavobarbosab.androidcourse.R
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.FieldValidator
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.InputValidationState.InvalidField
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(LoginUiState.initialState())
    val uiState
        get() = _uiState.asStateFlow()

    private var _snackbarState = MutableStateFlow<String?>(null)
    val snackbarState
        get() = _snackbarState.asStateFlow()

    private val usernameValidator =
        FieldValidator(invalidMessageResource = R.string.login_invalid_username) { username ->
            username?.isNotBlank() == true
        }

    private val passwordValidator =
        FieldValidator(invalidMessageResource = R.string.login_invalid_password) { password ->
            password?.isNotBlank() == true
        }

    fun usernameChanged(value: String) {
        this._uiState.update {
            it.copy(
                username = value,
                usernameValidation = InputValidationState.ValidField
            )
        }
    }

    fun passwordChanged(value: String) {
        this._uiState.update {
            it.copy(
                password = value,
                passwordValidation = InputValidationState.ValidField
            )
        }
    }

    fun onClickToLogin() {
        val currentState = _uiState.value
        val usernameState = usernameValidator.fieldState(currentState.username)
        val passwordState = passwordValidator.fieldState(currentState.password)

        _uiState.update {
            it.copy(
                usernameValidation = usernameState,
                passwordValidation = passwordState
            )
        }

        if (usernameState is InvalidField || passwordState is InvalidField) {
            return
        }

        _snackbarState.value = "Login feito com sucesso"
    }

    fun onClickToSignUp() {
        _snackbarState.value = "Efetuar Sign up"
    }

    fun snackBarShown() {
        _snackbarState.value = null
    }
}