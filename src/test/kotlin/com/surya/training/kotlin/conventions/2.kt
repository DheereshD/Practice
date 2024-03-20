package com.surya.training.kotlin.conventions

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * In Kotlin in checks are translated to the corresponding contains calls:
 *
 * val list = listOf("a", "b")
 * "a" in list  // list.contains("a")
 * "a" !in list // !list.contains("a")
 *
 * Read about ranges. Add a method fun contains(d: MyDate) to the class DateRange to allow in checks with a range of dates.
 */

class Two : StringSpec({

    class DateRange(val start: MyDate, val endInclusive: MyDate) {
        operator fun contains(item: MyDate): Boolean = item in start.rangeTo(endInclusive)
    }

    fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
        return date in DateRange(first, last)
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

    "Equals to Begin" {
        doTest(MyDate(2014, 3, 22), MyDate(2014, 3, 22), MyDate(2015, 1, 1), shouldBeInRange = true)
    }

    "Equals to End" {
        doTest(MyDate(2015, 1, 1), MyDate(2014, 3, 22), MyDate(2015, 1, 1), shouldBeInRange = true)
    }

    "One Day Range" {
        doTest(MyDate(2015, 1, 1), MyDate(2015, 1, 1), MyDate(2015, 1, 1), shouldBeInRange = true)
    }

    "Invalid Range" {
        doTest(MyDate(2014, 2, 1), MyDate(2015, 1, 1), MyDate(2014, 1, 1), shouldBeInRange = false)
    }

    "Invalid Range Equals to Begin" {
        doTest(MyDate(2015, 1, 1), MyDate(2015, 1, 1), MyDate(2014, 1, 1), shouldBeInRange = false)
    }

    "Invalid Range Equals to End" {
        doTest(MyDate(2014, 1, 1), MyDate(2015, 1, 1), MyDate(2014, 1, 1), shouldBeInRange = false)
    }
})
change