package com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model

import androidx.compose.runtime.Immutable

@Immutable
data class RegisterScreenState(
    val toolbarTitle: String,
    val headerTitle: String,
    val textFieldLabel: String
)
