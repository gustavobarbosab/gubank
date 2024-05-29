package com.github.gustavobarbosab.androidcourse.ui.common.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable

@Composable
fun TexFieldContainer(content: @Composable ColumnScope.() -> Unit) {
    Column {
        content(this)
    }
}