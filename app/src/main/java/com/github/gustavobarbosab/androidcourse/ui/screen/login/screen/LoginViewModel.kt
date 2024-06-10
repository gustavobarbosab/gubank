package com.github.gustavobarbosab.androidcourse.ui.screen.login.screen

import androidx.lifecycle.ViewModel
import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState.InvalidField
import com.github.gustavobarbosab.androidcourse.ui.navigation.destination.Route
import com.github.gustavobarbosab.androidcourse.ui.navigation.compose.NavigationStateOwner
import com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.model.FieldValidator
import com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.model.LoginFeedbackResource
import com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.model.TextInputState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.destination.RegisterEntryPointRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel(), NavigationStateOwner {

    private var _usernameState = MutableStateFlow(TextInputState.initialState())
    val usernameState
        get() = _usernameState.asStateFlow()

    private var _passwordState = MutableStateFlow(TextInputState.initialState())
    val passwordState
        get() = _passwordState.asStateFlow()

    private var _feedbackState = MutableStateFlow<LoginFeedbackResource?>(null)
    val feedbackState
        get() = _feedbackState.asStateFlow()

    private var _navigationState = MutableStateFlow<Route?>(null)
    override val destinationState
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
        _navigationState.value = RegisterEntryPointRoute
    }

    fun snackBarShown() {
        _feedbackState.value = null
    }

    override fun onNavigationDone() {
        _navigationState.value = null
    }
}