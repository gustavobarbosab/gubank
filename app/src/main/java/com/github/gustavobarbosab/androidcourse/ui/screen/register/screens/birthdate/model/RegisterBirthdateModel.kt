package com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthdate.model

import com.github.gustavobarbosab.androidcourse.ui.common.extension.CalendarMonth
import com.github.gustavobarbosab.androidcourse.ui.common.extension.addYear
import com.github.gustavobarbosab.androidcourse.ui.common.extension.setDayOfMonth
import com.github.gustavobarbosab.androidcourse.ui.common.extension.setMonth
import java.util.Calendar

class RegisterBirthdateModel {

    val maxDateCalendar by lazy {
        Calendar.getInstance().addYear(MINUS_MIN_AGE)
    }

    val minDateCalendar by lazy {
        Calendar.getInstance()
            .addYear(MINUS_MAX_AGE)
            .setMonth(CalendarMonth.JANUARY)
            .setDayOfMonth(FIRST)
    }

    val preSelectedDate: Long by lazy {
        val maxDateClone = maxDateCalendar.clone() as Calendar
        maxDateClone
            .addYear(MINUS_TWO)
            .setMonth(CalendarMonth.JULY)
            .setDayOfMonth(FIRST)
            .timeInMillis
    }

    private companion object {
        const val FIRST = 1
        const val MINUS_TWO = -2
        const val MINUS_MIN_AGE = -18
        const val MINUS_MAX_AGE = -120
    }
}