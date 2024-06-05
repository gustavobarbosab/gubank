package com.github.gustavobarbosab.androidcourse.ui.screen.register.common.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.github.gustavobarbosab.androidcourse.ui.common.components.ToolbarIcon
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterFlowViewModel

@Composable
fun RegisterFlowViewModel.setupToolbar(
    title: String,
    icon: ToolbarIcon
) {
    LaunchedEffect(Unit) {
        this@setupToolbar.setupToolbar(title, icon)
    }
}