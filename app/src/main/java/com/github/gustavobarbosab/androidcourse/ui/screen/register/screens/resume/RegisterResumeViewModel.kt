package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume

import androidx.lifecycle.ViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume.model.ResumeDynamicFieldsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat

class RegisterResumeViewModel(
    private val repository: RegisterFlowRepository
) : ViewModel() {

    private var _resumeDynamicFields = MutableStateFlow(ResumeDynamicFieldsState.initialState())
    val resumeDynamicFields
        get() = _resumeDynamicFields.asStateFlow()

    init {
        val birthdate = repository.birthdate
        val dateFormatter = SimpleDateFormat()
//        dateFormatter.
//        val birthdateFormattedValue = birthdate.

        _resumeDynamicFields.value = ResumeDynamicFieldsState(
            repository.name,
            repository.birthdate.toString(),
            repository.document
        )
    }
}
