package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.R
import com.github.gustavobarbosab.androidcourse.ui.common.components.PrimaryButton
import com.github.gustavobarbosab.androidcourse.ui.common.components.ToolbarIcon
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingSmall
import com.github.gustavobarbosab.androidcourse.ui.common.theme.AndroidCourseTheme
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.extension.registerToolbarSetup
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterScreenState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume.model.ResumeDynamicFieldsState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume.model.ResumeScreenState

@Composable
fun RegisterResumeScreen(
    screenState: ResumeScreenState = ResumeScreenState(
        toolbarTitle = stringResource(R.string.register_toolbar_resume),
        headerTitle = stringResource(R.string.register_name_header),
        textFieldLabel = stringResource(R.string.register_name_hint),
        labelName = stringResource(R.string.register_resume_name_label),
        labelDocument = stringResource(R.string.register_resume_document_label),
        labelBirthdate = stringResource(R.string.register_resume_birthdate_label)
    ),
    sharedViewModel: RegisterFlowViewModel,
    viewModel: RegisterResumeViewModel,
    onFinishRegistration: () -> Unit
) {
    sharedViewModel.registerToolbarSetup(
        title = screenState.toolbarTitle,
        icon = ToolbarIcon.Back
    )

    val dynamicFieldsState by viewModel.resumeDynamicFields.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .padding(paddingSmall)
            .background(Color.White)
    ) {
        InformativeLabel(
            title = screenState.labelName,
            subTitle = dynamicFieldsState.name,
        )
        InformativeLabel(
            title = screenState.labelBirthdate,
            subTitle = dynamicFieldsState.birthdate,
        )
        InformativeLabel(
            title = screenState.labelDocument,
            subTitle = dynamicFieldsState.document,
        )
        Row(Modifier.fillMaxHeight()) {
            PrimaryButton(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.Bottom),
                onClick = {
                }
            ) {
                Text(text = stringResource(id = R.string.register_finish_button))
            }
        }
    }
}

@Composable
fun InformativeLabel(
    title: String,
    subTitle: String
) {
    Column {
        Text(text = title)
        Text(text = subTitle)
    }
}

@Preview(device = "id:Nexus 4")
@Composable
private fun InformativeLabelPreview() {
    AndroidCourseTheme {
        InformativeLabel(
            "Meu titulo:",
            "Gustavo Barbosa Barreto"
        )
    }
}


@Preview(device = "id:Nexus 4")
@Composable
private fun RegisterAddressScreenPreview() {
    AndroidCourseTheme {
        RegisterResumeScreen(
            sharedViewModel = viewModel(),
            viewModel = viewModel(),
            onFinishRegistration = {}
        )
    }
}