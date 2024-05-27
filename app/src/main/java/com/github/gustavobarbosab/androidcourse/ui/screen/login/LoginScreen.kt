package com.github.gustavobarbosab.androidcourse.ui.screen.login

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.gustavobarbosab.androidcourse.R
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingBig
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingMedium
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingSmall
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingTiny
import com.github.gustavobarbosab.androidcourse.ui.common.theme.errorLight
import com.github.gustavobarbosab.androidcourse.ui.common.theme.primaryLight
import com.github.gustavobarbosab.androidcourse.ui.common.widgets.PrimaryButton
import com.github.gustavobarbosab.androidcourse.ui.common.widgets.RoundedCard
import com.github.gustavobarbosab.androidcourse.ui.common.widgets.SecondaryButton
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
        Column(
            modifier = Modifier
                .padding(it)
                .background(primaryLight)
                .fillMaxHeight()
        ) {
            Row(Modifier.fillMaxHeight()) {
                Column(
                    Modifier
                        .wrapContentHeight()
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        contentDescription = "Logo",
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.ic_logo),
                        tint = Color.White
                    )
                    RoundedCard(
                        margin = paddingMedium,
                        paddingHorizontal = paddingTiny,
                        paddingVertical = paddingBig,
                    ) {
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
                        PrimaryButton(
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
                        SecondaryButton(
                            onClick = viewModel::onClickToSignUp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = paddingSmall)
                        ) {
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
                                        append(stringResource(R.string.login_sign_up_button_1))
                                    }
                                    append(" ")
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(R.string.login_sign_up_button_2))
                                    }
                                },
                            )
                        }
                    }
                }
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
                color = errorLight
            )
        }

        InputValidationState.ValidField -> Unit
    }
}

@Preview(
    device = "spec:id=reference_phone,shape=Normal,width=411,height=891,unit=dp,dpi=420",
    uiMode = Configuration.UI_MODE_NIGHT_YES, backgroundColor = 0xFF282235
)
@Composable
fun PreviewLogin() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}
