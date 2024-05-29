package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthday

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.github.gustavobarbosab.androidcourse.ui.common.components.PrimaryButton
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterFlowViewModel

@Composable
fun RegisterBirthdayScreen(
    registerFlowViewModel: RegisterFlowViewModel,
    navigateToDocumentScreen: () -> Unit
) {
    val textState = registerFlowViewModel.myTextState.collectAsState()
    LaunchedEffect(Unit) {
        registerFlowViewModel.updateShared("Aniversário")
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = textState.value)
        PrimaryButton(onClick = navigateToDocumentScreen) {
            Text(text = "Continuar")
        }
    }
}

@Preview(device = "id:Nexus 4")
@Composable
private fun RegisterBirthdayScreenPreview() {
//    val navController = rememberNavController()
//    val scopedViewModelStoreOwner = scopedViewModelStoreOwner()
//    AndroidCourseTheme {
//        RegisterBirthdayScreen(
//            appNavigator = AppNavigatorImpl(navController),
//            registerFlowViewModel = RegisterFlowViewModel.getInstance(scopedViewModelStoreOwner)
//        )
//    }
}