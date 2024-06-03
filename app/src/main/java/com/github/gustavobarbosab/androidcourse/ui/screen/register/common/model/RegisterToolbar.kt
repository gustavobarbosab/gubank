package com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model

import com.github.gustavobarbosab.androidcourse.ui.common.components.ToolbarIcon

class RegisterToolbar(
    val title: String,
    val icon: ToolbarIcon
) {
    companion object {
        fun initialInstance() = RegisterToolbar("", ToolbarIcon.Back)
    }
}