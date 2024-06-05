package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume

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
fun RegisterAddressScreen(
    registerFlowViewModel: RegisterFlowViewModel,
    onFinishRegistration: () -> Unit
) {
    val textState = registerFlowViewModel.myTextState.collectAsState()
    LaunchedEffect(Unit) {
        registerFlowViewModel.updateShared("Endereço")
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = textState.value)
        PrimaryButton(onClick = onFinishRegistration) {
            Text(text = "Concluir")
        }
    }
}

@Preview(device = "id:Nexus 4")
@Composable
private fun RegisterAddressScreenPreview() {
//    val navController = rememberNavController()
//    val scopedViewModelStoreOwner = scopedViewModelStoreOwner()
//    AndroidCourseTheme {
//        RegisterAddressScreen(
//            appNavigator = AppNavigatorImpl(navController),
//            registerFlowViewModel = RegisterFlowViewModel.getInstance(scopedViewModelStoreOwner)
//        )
//    }
}