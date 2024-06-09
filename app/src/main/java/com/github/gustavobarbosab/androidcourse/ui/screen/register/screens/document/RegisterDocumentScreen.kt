package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.gustavobarbosab.androidcourse.R
import com.github.gustavobarbosab.androidcourse.ui.common.components.ErrorTextField
import com.github.gustavobarbosab.androidcourse.ui.common.components.IsolationColumn
import com.github.gustavobarbosab.androidcourse.ui.common.components.PrimaryButton
import com.github.gustavobarbosab.androidcourse.ui.common.components.ToolbarIcon
import com.github.gustavobarbosab.androidcourse.ui.common.size.fontSizeMedium
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingSmall
import com.github.gustavobarbosab.androidcourse.ui.common.theme.secondaryLight
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.extension.registerToolbarSetup
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterScreenState

@Composable
fun RegisterDocumentScreen(
    screenState: RegisterScreenState = RegisterScreenState(
        stringResource(R.string.register_toolbar_name),
        stringResource(R.string.register_document_header),
        stringResource(R.string.register_resume_document_label)
    ),
    sharedViewModel: RegisterFlowViewModel,
    viewModel: RegisterDocumentViewModel,
    navigateToResumeScreen: () -> Unit
) {
    val inputState by viewModel.document.collectAsState()

    sharedViewModel.registerToolbarSetup(
        screenState.toolbarTitle,
        ToolbarIcon.Back
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(paddingSmall)
            .background(Color.White)
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
                    viewModel.onClickToContinue(goToResumeScreen = navigateToResumeScreen)
                }
            ) {
                Text(text = stringResource(id = R.string.register_continue_button))
            }
        }
    }
}

@Preview(device = "id:Nexus 4")
@Composable
private fun RegisterDocumentScreenPreview() {
//    val navController = rememberNavController()
//    val scopedViewModelStoreOwner = scopedViewModelStoreOwner()
//    AndroidCourseTheme {
//        RegisterDocumentScreen(
//            appNavigator = AppNavigatorImpl(navController),
//            registerFlowViewModel = RegisterFlowViewModel.getInstance(scopedViewModelStoreOwner)
//        )
//    }
}