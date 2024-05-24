package com.github.gustavobarbosab.androidcourse.ui.screen.login.model

import androidx.annotation.StringRes

sealed class InputValidationState {
    data object ValidField : InputValidationState()
    class InvalidField(@StringRes val message: Int) : InputValidationState()
}