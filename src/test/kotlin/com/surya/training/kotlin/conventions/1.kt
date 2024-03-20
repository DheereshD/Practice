package com.surya.training.kotlin.conventions

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertTrue

/**
 * Read about operator overloading to learn how different conventions for operations like ==, <, + work in Kotlin.
 * Add the function compareTo to the class MyDate to make it comparable. After that the code below date1 < date2 will start to compile.
 * In Kotlin when you override a member, the modifier override is mandatory.
 */

class One : StringSpec({

    data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
        override fun compareTo(other: MyDate): Int {
            return when {
                year != other.year -> year - other.year
                month != other.month -> month - other.month
                else -> dayOfMonth - other.dayOfMonth
            }
        }

        val s: String get() = "($year-$month-$dayOfMonth)"
    }

    fun compare(date1: MyDate, date2: MyDate) = date1 < date2

    "Date Comparision" {
        assertTrue(compare(MyDate(2014, 1, 1), MyDate(2014, 1, 2)))
    }

    "Date Before" {
        val first = MyDate(2014, 10, 20)
        val second = MyDate(2014, 7, 11)
        assertTrue(first > second, "The date ${first.s} should be after ${second.s}")
    }

    "Date After" {
        val first = MyDate(2014, 5, 10)
        val second = MyDate(2014, 7, 11)
        assertTrue(first < second, "The date ${first.s} should be before ${second.s}")
    }
})
