package com.github.gustavobarbosab.androidcourse.ui.screen.login

data class LoginUiState(
    var username: String,
    val usernameError: String?,
    var password: String,
    val passwordError: String?
) {
    val hasUsernameError
        get() = usernameError?.isNotBlank() == true

    val hasPasswordError
        get() = passwordError?.isNotBlank() == true

    companion object {
        fun initialState() = LoginUiState(
            username = "",
            usernameError = null,
            password = "",
            passwordError = null
        )
    }
}