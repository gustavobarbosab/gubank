package com.github.gustavobarbosab.androidcourse.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterFlowViewModel : ViewModel() {

    private var _myTextState = MutableStateFlow<String>("")
    val myTextState
        get() = _myTextState.asStateFlow()

    fun updateShared(sharedString: String) {
        _myTextState.update { "$it $sharedString" }
    }

    companion object {
        fun getInstance(viewModelStore: ViewModelStoreOwner) =
            ViewModelProvider(viewModelStore)[RegisterFlowViewModel::class.java]
    }
}