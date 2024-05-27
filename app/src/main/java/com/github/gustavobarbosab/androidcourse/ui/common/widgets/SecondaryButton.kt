package com.github.gustavobarbosab.androidcourse.ui.common.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.gustavobarbosab.androidcourse.ui.common.theme.onPrimaryLight
import com.github.gustavobarbosab.androidcourse.ui.common.theme.primaryLight

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        content = content,
        colors = ButtonDefaults.outlinedButtonColors()
    )
}

@Preview
@Composable
fun previewSecondaryButton() {
    SecondaryButton(onClick = {}) {
        Text(text = "Clique aqui")
    }
}