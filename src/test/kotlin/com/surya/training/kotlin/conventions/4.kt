package com.surya.training.kotlin.conventions

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * Kotlin for loop iterates through anything that provides an iterator.
 * Make the class DateRange implement Iterable<MyDate>, so that it could be iterated over.
 * You can use the function MyDate.nextDay() defined in Util
 */

class Four : StringSpec({

    class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
        override fun iterator(): Iterator<MyDate> {
            return object : Iterator<MyDate> {
                var current: MyDate = start

                override fun hasNext(): Boolean {
                    return current <= end
                }

                override fun next(): MyDate {
                    val next = current
                    current = current.nextDay()
                    return next
                }
            }
        }
    }

    operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

    fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
        for (date in firstDate..secondDate) {
            handler(date)
        }
    }

    "Iterate Over Date Range" {
        val actualDateRange = ArrayList<MyDate>()
        iterateOverDateRange(MyDate(2014, 5, 1), MyDate(2014, 5, 5), actualDateRange::add)
        val expectedDateRange = arrayListOf(
            MyDate(2014, 5, 1),
            MyDate(2014, 5, 2),
            MyDate(2014, 5, 3),
            MyDate(2014, 5, 4),
            MyDate(2014, 5, 5),
        )
        assertEquals(expectedDateRange, actualDateRange, "Incorrect iteration over five nice spring dates")
    }

    "IterateOverEmptyRange" {
        var invoked = false
        iterateOverDateRange(MyDate(2014, 1, 1), MyDate(2013, 1, 1)) { invoked = true }
        assertFalse(invoked, "Handler was invoked on an empty range")
    }

    "IterateOverLeapYearEndOfFebruary" {
        val actualDateRange = ArrayList<MyDate>()
        iterateOverDateRange(MyDate(2016, 1, 26), MyDate(2016, 2, 1), actualDateRange::add)
        val expectedDateRange = arrayListOf(
            MyDate(2016, 1, 26),
            MyDate(2016, 1, 27),
            MyDate(2016, 1, 28),
            MyDate(2016, 1, 29),
            MyDate(2016, 2, 1),
        )
        assertEquals(expectedDateRange, actualDateRange, "Incorrect iteration over nice end of February of Leap-Year")
    }

    "IterateOverTheNewYear" {
        val actualDateRange = ArrayList<MyDate>()
        iterateOverDateRange(MyDate(2016, 11, 31), MyDate(2017, 0, 1), actualDateRange::add)
        val expectedDateRange = arrayListOf(
            MyDate(2016, 11, 31),
            MyDate(2017, 0, 1),
        )
        assertEquals(expectedDateRange, actualDateRange, "Incorrect iteration over the end of the year")
    }
})
