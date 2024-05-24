package com.github.gustavobarbosab.androidcourse.ui.screen.login

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val snackBarState by viewModel.snackbarState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(snackBarState) {
        scope.launch {
            val snackBarMessage = snackBarState ?: return@launch
            snackbarHostState.showSnackbar(snackBarMessage)
            viewModel.snackBarShown()
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.25f))
            Text(
                text = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center,
                fontSize = TextUnit(24f, TextUnitType.Sp)
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                value = state.username,
                onValueChange = viewModel::usernameChanged,
                label = { Text("Usuário") },
                isError = state.hasUsernameError,
                supportingText = {
                    ErrorText(
                        state.hasUsernameError,
                        state.usernameError.orEmpty()
                    )
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                value = state.password,
                onValueChange = viewModel::passwordChanged,
                label = { Text("Senha") },
                isError = state.hasPasswordError,
                supportingText = {
                    ErrorText(
                        state.hasPasswordError,
                        state.passwordError.orEmpty()
                    )
                }
            )
            Button(
                onClick = viewModel::onClickToLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {
                Text(text = "Entrar")
            }
            OutlinedButton(
                onClick = viewModel::onClickToSignUp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Criar conta")
            }
        }
    }
}


@Composable
fun ErrorText(hasError: Boolean, message: String) {
    if (!hasError) return
    Text(
        text = message,
        color = Color.Red
    )
}

@Preview(device = "id:pixel_4")
@Composable
fun PreviewLogin() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}
