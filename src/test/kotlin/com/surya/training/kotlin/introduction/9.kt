package com.surya.training.kotlin.introduction

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Read about extension functions.
 * Then implement extension functions Int.r() and Pair.r() and make them convert Int and Pair to RationalNumber.
 */
fun Int.r() = RationalNumber(this, 1)
fun Pair<Int, Int>.r() = RationalNumber(this.first, this.second)

data class RationalNumber(val numerator: Int, val denominator: Int)

class Nine : StringSpec({

    "Int Extension" {
        assertEquals(RationalNumber(4, 1), 4.r(), "Rational number creation error: ")
    }

    "Pair Extension" {
        assertEquals(RationalNumber(2, 3), (2 to 3).r(), "Rational number creation error: ")
    }
})
