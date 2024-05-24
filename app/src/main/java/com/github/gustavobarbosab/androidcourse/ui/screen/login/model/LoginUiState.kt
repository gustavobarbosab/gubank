package com.github.gustavobarbosab.androidcourse.ui.screen.login.model

import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.InputValidationState.InvalidField
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.InputValidationState.ValidField

data class LoginUiState(
    var username: String,
    var password: String,
    var usernameValidation: InputValidationState = ValidField,
    var passwordValidation: InputValidationState = ValidField
) {
    val isUsernameStateInvalid: Boolean
        get() = usernameValidation is InvalidField

    val isPasswordStateInvalid: Boolean
        get() = passwordValidation is InvalidField

    val isUsernameValid
        get() = username.isBlank()

    val isPasswordValid
        get() = password.isBlank()

    companion object {
        fun initialState() = LoginUiState(
            username = "",
            password = "",
        )
    }
}