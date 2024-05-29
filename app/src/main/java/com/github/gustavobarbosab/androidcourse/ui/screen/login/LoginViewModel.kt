package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.lifecycle.ViewModel
import com.github.gustavobarbosab.androidcourse.ui.common.widgets.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.common.widgets.InputValidationState.InvalidField
import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.FieldValidator
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.LoginFeedbackResource
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.TextInputState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.RegisterParentFlowRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private var _usernameState = MutableStateFlow(TextInputState.initialState())
    val usernameState
        get() = _usernameState.asStateFlow()

    private var _passwordState = MutableStateFlow(TextInputState.initialState())
    val passwordState
        get() = _passwordState.asStateFlow()

    private var _feedbackState = MutableStateFlow<LoginFeedbackResource?>(null)
    val feedbackState
        get() = _feedbackState.asStateFlow()

    private var _navigationState = MutableStateFlow<NavigationRoute?>(null)
    val navigationState
        get() = _navigationState.asStateFlow()

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
        this._usernameState.update {
            TextInputState(
                value = value,
                validation = InputValidationState.ValidField
            )
        }
    }

    fun passwordChanged(value: String) {
        this._passwordState.update {
            TextInputState(
                value = value,
                validation = InputValidationState.ValidField
            )
        }
    }

    fun onClickToLogin() {
        val usernameState = usernameValidator.fieldState(_usernameState.value.value)
        val passwordState = passwordValidator.fieldState(_passwordState.value.value)

        this._usernameState.update { it.copy(validation = usernameState) }
        this._passwordState.update { it.copy(validation = passwordState) }

        if (usernameState is InvalidField || passwordState is InvalidField) {
            return
        }

        _feedbackState.value = LoginFeedbackResource.LoginSuccessful
    }

    fun onClickToSignUp() {
        _feedbackState.value = LoginFeedbackResource.SignUp
        _navigationState.value = RegisterParentFlowRoute
    }

    fun snackBarShown() {
        _feedbackState.value = null
    }

    fun navigationDone() {
        _navigationState.value = null
    }
}