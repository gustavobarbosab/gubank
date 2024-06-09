package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthdate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.github.gustavobarbosab.androidcourse.ui.common.components.PrimaryButton
import com.github.gustavobarbosab.androidcourse.ui.common.components.ToolbarIcon
import com.github.gustavobarbosab.androidcourse.ui.common.size.fontSizeMedium
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingSmall
import com.github.gustavobarbosab.androidcourse.ui.common.theme.AndroidCourseTheme
import com.github.gustavobarbosab.androidcourse.ui.common.theme.secondaryLight
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.RegisterFlowViewModelFactory
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.extension.registerToolbarSetup
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterScreenState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepositoryImpl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterBirthdateScreen(
    screenState: RegisterScreenState = RegisterScreenState(
        stringResource(R.string.register_toolbar_birthday),
        stringResource(R.string.register_birthday_header)
    ),
    viewModel: RegisterBirthdateViewModel,
    sharedViewModel: RegisterFlowViewModel,
    navigateToDocumentScreen: () -> Unit
) {

    sharedViewModel.registerToolbarSetup(
        screenState.toolbarTitle,
        ToolbarIcon.Back
    )

    val dateValidationState by viewModel.dateValidationState.collectAsState()

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = viewModel.preSelectedDate,
        initialDisplayMode = DisplayMode.Picker,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean =
                viewModel.isSelectableDate(utcTimeMillis)

            override fun isSelectableYear(year: Int): Boolean =
                viewModel.isSelectableYear(year)
        }
    )

    LaunchedEffect(datePickerState.selectedDateMillis) {
        viewModel.onDateSelected(datePickerState.selectedDateMillis)
    }

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
        DatePicker(
            state = datePickerState,
            showModeToggle = false,
            title = null,
            headline = null,
        )
        ErrorTextField(inputValidation = dateValidationState)
        Row(Modifier.fillMaxHeight()) {
            PrimaryButton(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.Bottom),
                onClick = {
                    viewModel.onClickToContinue(
                        datePickerState.selectedDateMillis,
                        goToNextScreen = navigateToDocumentScreen
                    )
                }
            ) {
                Text(text = stringResource(id = R.string.register_continue_button))
            }
        }
    }
}

@Preview(device = "id:Nexus 4")
@Composable
private fun RegisterBirthdayScreenPreview() {
    val factory = remember {
        RegisterFlowViewModelFactory.provideFactory(RegisterFlowRepositoryImpl())
    }
    val screenState = remember {
        RegisterScreenState(
            "Novo cadastro - Etapa 2 de 4",
            "Informe sua data de nascimento para prosseguirmos com seu cadastro.",
            "Data de nascimento"
        )
    }
    AndroidCourseTheme {
        RegisterBirthdateScreen(
            screenState,
            viewModel(factory = factory),
            viewModel(factory = factory),
            {}
        )
    }
}