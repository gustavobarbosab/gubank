package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.lifecycle.ViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.LoginFeedbackResource
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

    private var _feedbackState = MutableStateFlow<LoginFeedbackResource?>(null)
    val feedbackState
        get() = _feedbackState.asStateFlow()

    private val usernameValidator = FieldValidator(
        invalidFeedbackResource = LoginFeedbackResource.InvalidUsername
    ) { username ->
        username?.isNotBlank() == true
    }

    private val passwordValidator = FieldValidator(
        invalidFeedbackResource = LoginFeedbackResource.InvalidPassword
    ) { password ->
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
        val currentScreenState = _uiState.value
        val usernameState = usernameValidator.fieldState(currentScreenState.username)
        val passwordState = passwordValidator.fieldState(currentScreenState.password)

        _uiState.update {
            it.copy(
                usernameValidation = usernameState,
                passwordValidation = passwordState
            )
        }

        if (usernameState is InvalidField || passwordState is InvalidField) {
            return
        }

        _feedbackState.value = LoginFeedbackResource.LoginSuccessful
    }

    fun onClickToSignUp() {
        _feedbackState.value = LoginFeedbackResource.SignUp
    }

    fun snackBarShown() {
        _feedbackState.value = null
    }
}