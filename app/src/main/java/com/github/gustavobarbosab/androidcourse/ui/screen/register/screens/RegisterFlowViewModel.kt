package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.CreationExtras
import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.common.components.ToolbarIcon
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterInputState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterToolbar
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.RegisterNameViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Calendar

class RegisterFlowViewModel(
    private val repository: RegisterFlowRepository
) : ViewModel() {

    private var _myTextState = MutableStateFlow("")
    val myTextState
        get() = _myTextState.asStateFlow()

    private var _toolbarState = MutableStateFlow(RegisterToolbar.initialInstance())
    val toolbarState
        get() = _toolbarState.asStateFlow()

    private var onBackPressed = {}

    fun updateShared(sharedString: String) {
        _myTextState.update { "$it $sharedString ${repository.name}" }
    }

    fun setupToolbar(
        title: String,
        iconType: ToolbarIcon
    ) {
        _toolbarState.value = RegisterToolbar(title, iconType)
    }

    override fun onCleared() {
        this.onBackPressed = {}
        super.onCleared()
    }
}