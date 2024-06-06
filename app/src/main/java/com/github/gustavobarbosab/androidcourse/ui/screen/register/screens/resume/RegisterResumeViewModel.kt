package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume

import androidx.lifecycle.ViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume.model.ResumeDynamicFieldsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.Locale

class RegisterResumeViewModel(
    private val repository: RegisterFlowRepository
) : ViewModel() {

    private var _resumeDynamicFields = MutableStateFlow(ResumeDynamicFieldsState.initialState())
    val resumeDynamicFields
        get() = _resumeDynamicFields.asStateFlow()

    init {
        val birthdate = repository.birthdate
        val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val birthdateFormattedValue = dateFormatter.format(birthdate.time)

        _resumeDynamicFields.value = ResumeDynamicFieldsState(
            repository.name,
            birthdateFormattedValue,
            repository.document
        )
    }
}
