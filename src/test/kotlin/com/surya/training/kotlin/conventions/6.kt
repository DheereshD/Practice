package com.surya.training.kotlin.conventions

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Read about destructuring declarations and make the following code compile by adding one word.
 */

class Six : StringSpec({

    data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

    fun isLeapDay(date: MyDate): Boolean {
        val (year, month, dayOfMonth) = date
        // 29 February of a leap year
        return year % 4 == 0 && month == 2 && dayOfMonth == 29
    }

    "Is Leap Day" {
        assertTrue(isLeapDay(MyDate(2016, 2, 29)))
        assertFalse(isLeapDay(MyDate(2015, 1, 29)))
    }
})
