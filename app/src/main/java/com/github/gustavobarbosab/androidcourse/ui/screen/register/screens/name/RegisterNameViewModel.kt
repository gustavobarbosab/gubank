package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterInputState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.model.RegisterNameFeedback.InvalidName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterNameViewModel(
    private val registerFlowRepository: RegisterFlowRepository
) : ViewModel() {

    private var _userName = MutableStateFlow(RegisterInputState.initialState())
    val userName
        get() = _userName.asStateFlow()

    fun onValueChanged(value: String) {
        _userName.update {
            RegisterInputState(
                value = value,
                InputValidationState.ValidField
            )
        }
    }

    fun onClickToContinue(goToBirthdayScreen: () -> Unit) {
        val usernameValue = _userName.value.value
        if (usernameValue.isBlank()) {
            _userName.update {
                it.copy(
                    validation = InputValidationState.InvalidField(InvalidName.stringRes)
                )
            }
            return
        }

        registerFlowRepository.name = usernameValue
        goToBirthdayScreen()
    }
}