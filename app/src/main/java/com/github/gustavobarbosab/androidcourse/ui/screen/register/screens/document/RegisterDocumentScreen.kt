package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document

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
import com.github.gustavobarbosab.androidcourse.ui.common.widgets.PrimaryButton
import com.github.gustavobarbosab.androidcourse.ui.navigation.navigator.FlowNavigator
import com.github.gustavobarbosab.androidcourse.ui.screen.register.RegisterFlowViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation.RegisterNestedRoutes

@Composable
fun RegisterDocumentScreen(
    flowNavigator: FlowNavigator,
    registerFlowViewModel: RegisterFlowViewModel
) {
    val textState = registerFlowViewModel.myTextState.collectAsState()
    LaunchedEffect(Unit) {
        registerFlowViewModel.updateShared("Documento")
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = textState.value)
        PrimaryButton(onClick = { flowNavigator.navigate(RegisterNestedRoutes.registerAddressRoute) }) {
            Text(text = "Continuar")
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