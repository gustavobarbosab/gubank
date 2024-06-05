package com.github.gustavobarbosab.androidcourse.ui.common.extension

import java.util.Calendar

fun Calendar.addYear(amount: Int) = this.apply {
    add(Calendar.YEAR, amount)
}

fun Calendar.addMonth(amount: Int) = this.apply {
    add(Calendar.MONTH, amount)
}

fun Calendar.addDayOfMonth(amount: Int) = this.apply {
    add(Calendar.DAY_OF_MONTH, amount)
}

fun Calendar.setDayOfMonth(day: Int) = this.apply {
    set(Calendar.DAY_OF_MONTH, day)
}

fun Calendar.setMonth(month: CalendarMonth) = this.apply {
    set(Calendar.MONTH, month.value)
}

fun Calendar.setYear(year: Int) = this.apply {
    set(Calendar.YEAR, year)
}

fun Calendar.year(): Int = get(Calendar.YEAR)

fun Calendar.month(): Int = get(Calendar.MONTH)

fun Calendar.dayOfMonth(): Int = get(Calendar.MONTH)

enum class CalendarMonth(val value: Int) {
    JANUARY(Calendar.JANUARY),
    FEBRUARY(Calendar.FEBRUARY),
    MARCH(Calendar.MARCH),
    APRIL(Calendar.APRIL),
    MAY(Calendar.MAY),
    JUNE(Calendar.JUNE),
    JULY(Calendar.JULY),
    AUGUST(Calendar.AUGUST),
    SEPTEMBER(Calendar.SEPTEMBER),
    NOVEMBER(Calendar.NOVEMBER),
    DECEMBER(Calendar.DECEMBER),
}