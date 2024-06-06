package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document

import androidx.lifecycle.ViewModel
import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterInputState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document.model.RegisterDocumentFeedback.InvalidName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterDocumentViewModel(
    private val repository: RegisterFlowRepository
) : ViewModel() {

    private var _document = MutableStateFlow(RegisterInputState.initialState())
    val document
        get() = _document.asStateFlow()

    fun onValueChanged(value: String) {
        _document.update {
            RegisterInputState(
                value = value,
                InputValidationState.ValidField
            )
        }
    }

    fun onClickToContinue(goToResumeScreen: () -> Unit) {
        val documentValue = _document.value.value
        if (documentValue.isBlank() || documentValue.length < 11) {
            _document.update {
                it.copy(
                    validation = InputValidationState.InvalidField(InvalidName.stringRes)
                )
            }
            return
        }

        repository.document = documentValue
        goToResumeScreen()
    }
}