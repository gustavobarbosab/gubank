package com.github.gustavobarbosab.androidcourse.ui.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.R
import com.github.gustavobarbosab.androidcourse.ui.common.size.fontSizeBig
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingSmall
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.screen.login.model.LoginTestTags
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val snackBarState by viewModel.feedbackState.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    LaunchedEffect(snackBarState) {
        val snackBarResourceMessage = snackBarState ?: return@LaunchedEffect
        val message = context.getString(snackBarResourceMessage.stringRes)
        scope.launch {
            snackBarHostState.showSnackbar(message)
            viewModel.snackBarShown()
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) {
        Column(modifier = Modifier.padding(it)) {
            Spacer(modifier = Modifier.fillMaxHeight(0.25f))
            Text(
                text = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = paddingSmall),
                textAlign = TextAlign.Center,
                fontSize = fontSizeBig
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = paddingSmall)
                    .testTag(LoginTestTags.USERNAME_FIELD),
                value = state.username,
                onValueChange = viewModel::usernameChanged,
                label = { Text(stringResource(R.string.login_username_hint)) },
                isError = state.isUsernameStateInvalid,
                supportingText = {
                    ErrorTextField(inputValidation = state.usernameValidation)
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = paddingSmall)
                    .testTag(LoginTestTags.PASSWORD_FIELD),
                value = state.password,
                onValueChange = viewModel::passwordChanged,
                label = { Text(stringResource(R.string.login_password_hint)) },
                isError = state.isPasswordStateInvalid,
                supportingText = {
                    ErrorTextField(inputValidation = state.passwordValidation)
                }
            )
            Button(
                onClick = viewModel::onClickToLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = paddingSmall,
                        end = paddingSmall,
                        top = paddingSmall
                    )
                    .testTag(LoginTestTags.LOGIN_BUTTON)
            ) {
                Text(text = stringResource(R.string.login_button))
            }
            OutlinedButton(
                onClick = viewModel::onClickToSignUp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = paddingSmall)
            ) {
                Text(text = stringResource(R.string.login_sign_up_button))
            }
        }
    }
}

@Composable
fun ErrorTextField(
    modifier: Modifier = Modifier,
    inputValidation: InputValidationState,
) {
    when (inputValidation) {
        is InputValidationState.InvalidField -> {
            Text(
                modifier = modifier,
                text = stringResource(id = inputValidation.feedbackResource.stringRes),
                color = Color.Red
            )
        }

        InputValidationState.ValidField -> Unit
    }
}

@Preview(device = "id:pixel_4")
@Composable
fun PreviewLogin() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}
