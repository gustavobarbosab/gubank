package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.model

import androidx.annotation.StringRes
import com.github.gustavobarbosab.androidcourse.R

sealed class RegisterNameFeedback(
    @StringRes val stringRes: Int
) {
    data object InvalidName : RegisterNameFeedback(R.string.register_name_invalid_name)
}