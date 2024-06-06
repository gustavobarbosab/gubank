package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document.model

import androidx.annotation.StringRes
import com.github.gustavobarbosab.androidcourse.R

sealed class RegisterDocumentFeedback(
    @StringRes val stringRes: Int
) {
    data object InvalidName : RegisterDocumentFeedback(R.string.register_document_invalid_document)
}