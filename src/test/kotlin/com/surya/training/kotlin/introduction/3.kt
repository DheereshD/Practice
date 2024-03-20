package com.surya.training.kotlin.introduction

import io.kotest.core.spec.style.StringSpec
import java.util.Locale
import kotlin.test.assertEquals

// Below are 4 overloads of function `upperCaseConverter`. Re-write them to not have any overloads, using default arguments.
// Note that the behavior of all the overloads should not change.

// fun upperCaseConverter(name: String, number: Int, toUpperCase: Boolean): String =
//    (if (toUpperCase) name.uppercase(Locale.getDefault()) else name) + number
// fun upperCaseConverter(name: String, number: Int): String = upperCaseConverter(name, number, false)
// fun upperCaseConverter(name: String, toUpperCase: Boolean): String = upperCaseConverter(name, 42, toUpperCase)
// fun upperCaseConverter(name: String): String = upperCaseConverter(name, 42, false)

fun upperCaseConverter(name: String, number: Int = 42, toUpperCase: Boolean = false): String =
    (if (toUpperCase) name.uppercase(Locale.getDefault()) else name) + number

class Three : StringSpec({

    "specify all arguments" {
        assertEquals("A1", upperCaseConverter("a", 1, true))
        assertEquals("a1", upperCaseConverter("a", 1, false))
    }

    "specify name and number" {
        assertEquals("a1", upperCaseConverter("a", number = 1))
    }

    "specify name and toUpperCase" {
        assertEquals("A42", upperCaseConverter("a", toUpperCase = true))
    }

    "specify only name" {
        assertEquals("a42", upperCaseConverter("a"))
    }
})
