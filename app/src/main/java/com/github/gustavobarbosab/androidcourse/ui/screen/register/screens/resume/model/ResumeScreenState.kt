package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume.model

import androidx.compose.runtime.Immutable
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterScreenState

@Immutable
class ResumeScreenState(
    toolbarTitle: String,
    headerTitle: String,
    textFieldLabel: String,
    val labelName: String,
    val labelDocument: String,
    val labelBirthdate: String,
) : RegisterScreenState(
    toolbarTitle,
    headerTitle,
    textFieldLabel
)