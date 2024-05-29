package com.github.gustavobarbosab.androidcourse.ui.screen.login.model

import com.github.gustavobarbosab.androidcourse.ui.common.widgets.InputValidationState

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