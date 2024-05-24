package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.lifecycle.ViewModel
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

    fun usernameChanged(value: String) {
        this._uiState.update { it.copy(username = value, usernameError = null) }
    }

    fun passwordChanged(value: String) {
        this._uiState.update { it.copy(password = value, passwordError = null) }
    }

    fun onClickToLogin() {
        val state = _uiState.value

        val isUsernameInvalid = state.username.isBlank()
        if (isUsernameInvalid) {
            _uiState.update {
                it.copy(usernameError = "Insira um nome de usuário válido")
            }
        }

        val isPasswordInvalid = state.password.isBlank()
        if (state.password.isBlank()) {
            _uiState.update {
                it.copy(passwordError = "Insira uma senha válido")
            }
        }

        if (isUsernameInvalid || isPasswordInvalid) {
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