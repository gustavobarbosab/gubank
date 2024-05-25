package com.github.gustavobarbosab.androidcourse.ui.screen.login.model

sealed class InputValidationState {
    data object ValidField : InputValidationState()
    class InvalidField(val feedbackResource: LoginFeedbackResource) : InputValidationState()
}