package com.github.gustavobarbosab.androidcourse.ui.screen.login.model

class FieldValidator(
    private val invalidFeedbackResource: LoginFeedbackResource,
    val isFieldValidRule: (String?) -> Boolean,
) {
    fun fieldState(value: String?) = if (isFieldValidRule(value)) {
        InputValidationState.ValidField
    } else {
        InputValidationState.InvalidField(invalidFeedbackResource)
    }
}