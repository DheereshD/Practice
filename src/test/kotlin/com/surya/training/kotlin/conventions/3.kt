package com.surya.training.kotlin.conventions

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Implement the function MyDate.rangeTo(). This allows you to create a range of dates using the following syntax:
 *
 * MyDate(2015, 5, 11)..MyDate(2015, 5, 12)
 *
 * Note that now the class DateRange implements the standard ClosedRange interface and inherits contains method implementation.
 */

class Three : StringSpec({

    class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>

    operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

    fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
        return date in first..last
    }

    fun doTest(date: MyDate, first: MyDate, last: MyDate, shouldBeInRange: Boolean) {
        val message = "The date ${date.s} should${if (shouldBeInRange) "" else "n't"} be in range: ${first.s}..${last.s}"
        assertEquals(shouldBeInRange, checkInRange(date, first, last), message)
    }

    "In Range" {
        doTest(MyDate(2014, 3, 22), MyDate(2014, 1, 1), MyDate(2015, 1, 1), shouldBeInRange = true)
    }

    "Before" {
        doTest(MyDate(2013, 3, 22), MyDate(2014, 1, 1), MyDate(2015, 1, 1), shouldBeInRange = false)
    }

    "After" {
        doTest(MyDate(2015, 3, 22), MyDate(2014, 1, 1), MyDate(2015, 1, 1), shouldBeInRange = false)
    }
})
