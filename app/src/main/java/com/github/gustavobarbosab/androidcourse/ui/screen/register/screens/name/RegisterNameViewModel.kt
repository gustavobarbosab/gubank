package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name

import androidx.lifecycle.ViewModel
import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterInputState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.model.RegisterNameFeedback.InvalidName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterNameViewModel : ViewModel() {

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

    fun onClickToContinue(whenTheFieldsAreValid: (String) -> Unit) {
        val usernameValue = _userName.value.value
        if (usernameValue.isBlank()) {
            _userName.update {
                it.copy(
                    validation = InputValidationState.InvalidField(InvalidName.stringRes)
                )
            }
            return
        }

        whenTheFieldsAreValid(usernameValue)
    }
}