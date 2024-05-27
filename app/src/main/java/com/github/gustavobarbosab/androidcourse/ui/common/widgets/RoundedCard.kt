package com.github.gustavobarbosab.androidcourse.ui.common.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RoundedCard(
    modifier: Modifier = Modifier,
    margin: Dp = 0.dp,
    paddingVertical: Dp = 0.dp,
    paddingHorizontal: Dp = 0.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier
            .padding(margin)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(2)
            )
            .padding(
                vertical = paddingVertical,
                horizontal = paddingHorizontal
            ),
        content = content
    )
}