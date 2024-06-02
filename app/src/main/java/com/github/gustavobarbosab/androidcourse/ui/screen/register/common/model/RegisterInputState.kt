package com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model

import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState

data class RegisterInputState(
    var value: String,
    var validation: InputValidationState = InputValidationState.ValidField
) {
    val isStateInvalid: Boolean
        get() = validation is InputValidationState.InvalidField

    companion object {
        fun initialState() = RegisterInputState(
            value = "",
            validation = InputValidationState.ValidField
        )
    }
}