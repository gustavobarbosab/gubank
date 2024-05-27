package com.github.gustavobarbosab.androidcourse.ui.common.extension

import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun Modifier.borderTest(): Modifier {
    return this.border(1.dp, Color.Red)
}
