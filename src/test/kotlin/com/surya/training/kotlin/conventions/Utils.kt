package com.surya.training.kotlin.conventions

import java.util.Calendar

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

    val s: String get() = "($year-$month-$dayOfMonth)"

    fun addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate = Calendar.getInstance().run {
        set(year, month, dayOfMonth)
        add(
            when (timeInterval) {
                TimeInterval.DAY -> Calendar.DAY_OF_MONTH
                TimeInterval.WEEK -> Calendar.WEEK_OF_MONTH
                TimeInterval.YEAR -> Calendar.YEAR
            },
            number,
        )
        MyDate(get(Calendar.YEAR), get(Calendar.MONTH), get(Calendar.DATE))
    }

    fun nextDay(): MyDate = addTimeIntervals(TimeInterval.DAY, 1)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR,
}
