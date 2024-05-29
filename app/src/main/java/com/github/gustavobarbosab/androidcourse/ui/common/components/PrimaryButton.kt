package com.github.gustavobarbosab.androidcourse.ui.common.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        content = content,
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.outlinedButtonColors()
    )
}

@Preview
@Composable
fun previewButton() {
    PrimaryButton(onClick = {}) {
        Text(text = "Clique aqui")
    }
}