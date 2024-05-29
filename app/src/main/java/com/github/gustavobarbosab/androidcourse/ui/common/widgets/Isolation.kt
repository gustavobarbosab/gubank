package com.github.gustavobarbosab.androidcourse.ui.common.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

@Composable
fun IsolationColumn(content: @Composable ColumnScope.() -> Unit) {
    Column {
        this.content()
    }
}

@Composable
fun IsolationRow(content: @Composable RowScope.() -> Unit) {
    Row {
        this.content()
    }
}
