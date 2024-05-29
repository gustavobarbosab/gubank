package com.github.gustavobarbosab.androidcourse.ui.common.components

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.github.gustavobarbosab.androidcourse.ui.common.theme.errorLight

@Composable
fun ErrorTextField(
    modifier: Modifier = Modifier,
    inputValidation: InputValidationState,
) {
    when (inputValidation) {
        is InputValidationState.InvalidField -> {
            Text(
                modifier = modifier,
                text = stringResource(id = inputValidation.feedbackResource),
                color = errorLight
            )
        }

        InputValidationState.ValidField -> Unit
    }
}

sealed class InputValidationState {
    data object ValidField : InputValidationState()
    class InvalidField(@StringRes val feedbackResource: Int) : InputValidationState()
}
