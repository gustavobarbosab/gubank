package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.gustavobarbosab.androidcourse.R
import com.github.gustavobarbosab.androidcourse.ui.common.components.ErrorTextField
import com.github.gustavobarbosab.androidcourse.ui.common.components.IsolationColumn
import com.github.gustavobarbosab.androidcourse.ui.common.components.PrimaryButton
import com.github.gustavobarbosab.androidcourse.ui.common.components.ToolbarIcon
import com.github.gustavobarbosab.androidcourse.ui.common.size.fontSizeMedium
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingSmall
import com.github.gustavobarbosab.androidcourse.ui.common.theme.AndroidCourseTheme
import com.github.gustavobarbosab.androidcourse.ui.common.theme.secondaryLight
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.extension.LaunchToolbar
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterScreenState

@Composable
fun RegisterNameScreen(
    screenState: RegisterScreenState = RegisterScreenState(
        stringResource(R.string.register_toolbar),
        stringResource(R.string.register_name_header),
        stringResource(R.string.register_name_hint)
    ),
    sharedViewModel: RegisterFlowViewModel,
    viewModel: RegisterNameViewModel,
    navigateToBirthdayScreen: () -> Unit
) {
    val inputState by viewModel.userName.collectAsState()

    sharedViewModel.LaunchToolbar(
        "Cadastro - Etapa 1 de 4",
        ToolbarIcon.Close
    )

    Column(
        Modifier
            .background(Color.White)
            .padding(paddingSmall)
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = paddingSmall)
                .fillMaxWidth(),
            text = screenState.headerTitle,
            color = secondaryLight,
            fontSize = fontSizeMedium
        )
        IsolationColumn {
            OutlinedTextField(
                value = inputState.value,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = viewModel::onValueChanged,
                label = { Text(screenState.textFieldLabel) },
                isError = inputState.isStateInvalid,
                supportingText = { ErrorTextField(inputValidation = inputState.validation) }
            )
        }
        Row(Modifier.fillMaxHeight()) {
            PrimaryButton(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.Bottom),
                onClick = {
                    viewModel.onClickToContinue(goToBirthdayScreen = navigateToBirthdayScreen)
                }
            ) {
                Text(text = stringResource(id = R.string.register_name_button))
            }
        }
    }
}

@Preview(device = "id:Nexus 4")
@Composable
private fun RegisterNamePreview() {
    val viewModel = viewModel<RegisterNameViewModel>()
    val sharedViewModel = viewModel<RegisterFlowViewModel>()
    val screenState = remember {
        RegisterScreenState(
            "Novo cadastro",
            "Informe seu nome completo para prosseguirmos com seu cadastro.",
            "Nome completo"
        )
    }

    AndroidCourseTheme {
        RegisterNameScreen(
            screenState,
            sharedViewModel,
            viewModel,
            {}
        )
    }
}