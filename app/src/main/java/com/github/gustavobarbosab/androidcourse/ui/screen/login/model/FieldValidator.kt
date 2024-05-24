package com.github.gustavobarbosab.androidcourse.ui.screen.login.model

import androidx.annotation.StringRes

class FieldValidator(
    @StringRes private val invalidMessageResource: Int,
    val isFieldValidRule: (String?) -> Boolean,
) {
    fun fieldState(value: String?) = if (isFieldValidRule(value)) {
        InputValidationState.ValidField
    } else {
        InputValidationState.InvalidField(invalidMessageResource)
    }
}