package com.github.gustavobarbosab.androidcourse.ui.screen.login.model

import com.github.gustavobarbosab.androidcourse.ui.common.widgets.InputValidationState

data class TextInputState(
    var value: String,
    var validation: InputValidationState = InputValidationState.ValidField
) {
    val isStateInvalid: Boolean
        get() = validation is InputValidationState.InvalidField

    companion object {
        fun initialState() = TextInputState(value = "", validation = InputValidationState.ValidField)
    }
}