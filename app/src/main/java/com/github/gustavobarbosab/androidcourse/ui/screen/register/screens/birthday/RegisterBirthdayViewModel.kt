package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthday

import androidx.lifecycle.ViewModel
import com.github.gustavobarbosab.androidcourse.R
import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.common.extension.year
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthday.model.RegisterBirthdayModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Calendar

class RegisterBirthdayViewModel(
    private val repository: RegisterFlowRepository
) : ViewModel() {

    private var _dateValidationState =
        MutableStateFlow<InputValidationState>(InputValidationState.ValidField)
    val dateValidationState
        get() = _dateValidationState.asStateFlow()

    private val model = RegisterBirthdayModel()

    val preSelectedDate: Long
        get() = model.preSelectedDate

    fun onClickToContinue(
        selectedDateMillis: Long?,
        goToNextScreen: () -> Unit
    ) {
        if (selectedDateMillis == null || !isDateValid(selectedDateMillis)) {
            setInvalidDate()
            return
        }

        goToNextScreen()
    }

    fun onDateSelected(selectedDateMillis: Long?) {
        if (selectedDateMillis == null) {
            setInvalidDate()
            return
        }
        _dateValidationState.value = InputValidationState.ValidField
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = selectedDateMillis
        repository.birthday = calendar
    }

    fun isSelectableDate(utcTimeMillis: Long): Boolean = isDateValid(utcTimeMillis)


    fun isSelectableYear(year: Int): Boolean =
        year in model.minDateCalendar.year()..model.maxDateCalendar.year()

    private fun setInvalidDate() {
        _dateValidationState.value = InputValidationState.InvalidField(
            R.string.register_birthday_invalid_date
        )
    }

    private fun isDateValid(utcTimeMillis: Long) =
        utcTimeMillis in model.minDateCalendar.timeInMillis..model.maxDateCalendar.timeInMillis

}