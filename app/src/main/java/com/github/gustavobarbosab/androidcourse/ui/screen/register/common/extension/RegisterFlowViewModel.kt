package com.github.gustavobarbosab.androidcourse.ui.screen.register.common.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.github.gustavobarbosab.androidcourse.ui.common.components.ToolbarIcon
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModel

@Composable
fun RegisterFlowViewModel.registerToolbarSetup(
    title: String,
    icon: ToolbarIcon
) {
    LaunchedEffect(Unit) {
        this@registerToolbarSetup.setupToolbar(title, icon)
    }
}