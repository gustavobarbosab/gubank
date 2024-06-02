package com.github.gustavobarbosab.androidcourse.ui.screen.login.screen.model

import androidx.annotation.StringRes
import com.github.gustavobarbosab.androidcourse.R

sealed class LoginFeedbackResource(@StringRes val stringRes: Int) {
    data object LoginSuccessful : LoginFeedbackResource(R.string.login_successful_logged)
    data object SignUp : LoginFeedbackResource(R.string.login_sign_up)
    data object InvalidPassword : LoginFeedbackResource(R.string.login_invalid_password)
    data object InvalidUsername : LoginFeedbackResource(R.string.login_invalid_username)
}