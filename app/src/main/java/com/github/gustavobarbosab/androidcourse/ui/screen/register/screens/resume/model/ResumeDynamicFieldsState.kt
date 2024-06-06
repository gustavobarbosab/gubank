package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume.model

data class ResumeDynamicFieldsState(
    val name: String,
    val birthdate: String,
    val document: String,
) {
    companion object {
        fun initialState() = ResumeDynamicFieldsState(
            "",
            "",
            ""
        )
    }
}