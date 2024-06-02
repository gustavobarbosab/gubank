package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.gustavobarbosab.androidcourse.ui.common.ScopedViewModelStoreOwner
import com.github.gustavobarbosab.androidcourse.ui.common.components.AppToolbar
import com.github.gustavobarbosab.androidcourse.ui.common.components.ErrorTextField
import com.github.gustavobarbosab.androidcourse.ui.common.components.IsolationColumn
import com.github.gustavobarbosab.androidcourse.ui.common.components.PrimaryButton
import com.github.gustavobarbosab.androidcourse.ui.common.size.fontSizeMedium
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingSmall
import com.github.gustavobarbosab.androidcourse.ui.common.theme.AndroidCourseTheme
import com.github.gustavobarbosab.androidcourse.ui.common.theme.secondaryLight
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterScreenState

@Composable
fun RegisterNameScreen(
    parentViewModel: RegisterFlowViewModel,
    viewModel: RegisterNameViewModel,
    screenState: RegisterScreenState,
    onBackButtonClicked: () -> Unit,
    goToBirthdayScreen: () -> Unit
) {
    val inputState by viewModel.userName.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onValueChanged(parentViewModel.username)
    }

    Column {
        AppToolbar(
            title = "Novo Cadastro",
            onBackButtonClicked = onBackButtonClicked,
            icon = Icons.Outlined.Close
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
                        viewModel.onClickToContinue(
                            whenTheFieldsAreValid = { username ->
                                parentViewModel.username = username
                                goToBirthdayScreen()
                            }
                        )
                    }
                ) {
                    Text(text = "Continuar")
                }
            }
        }

    }
}


@Preview(device = "id:Nexus 4")
@Composable
private fun RegisterNamePreview() {
    val scopedViewModelStore = remember { ScopedViewModelStoreOwner() }
    val parentViewModel = viewModel<RegisterFlowViewModel>(scopedViewModelStore)
    val viewModel = viewModel<RegisterNameViewModel>()
    val screenState = remember {
        RegisterScreenState(
            "Novo cadastro",
            "Informe seu nome completo para prosseguirmos com seu cadastro.",
            "Nome completo"
        )
    }

    AndroidCourseTheme {
        RegisterNameScreen(
            parentViewModel,
            viewModel,
            screenState,
            {},
            {}
        )
    }
}