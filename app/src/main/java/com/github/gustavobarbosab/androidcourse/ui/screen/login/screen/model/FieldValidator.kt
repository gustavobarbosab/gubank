package com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.model

import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState

class FieldValidator(
    private val invalidFeedbackResource: LoginFeedbackResource,
    val isFieldValidRule: (String?) -> Boolean,
) {
    fun fieldState(value: String?) = if (isFieldValidRule(value)) {
        InputValidationState.ValidField
    } else {
        InputValidationState.InvalidField(invalidFeedbackResource.stringRes)
    }
}