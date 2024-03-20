package com.surya.training.kotlin.introduction

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Kotlin code can be easily mixed with Java code. Thus in Kotlin we don't introduce our own collections,
 * but use standard Java ones (slightly improved). Read about read-only and mutable views on Java collections.
 *
 * In Kotlin standard library there are lots of extension functions that make the work with collections more convenient.
 * Rewrite the previous example once more using an extension function sortedDescending.
 */

fun mySortedDescending1(array: List<Int>): List<Int> {
    return array.sortedDescending()
}

fun ArrayList<Int>.mySortedDescending2(): List<Int> {
    return this.sortedDescending()
}

fun getArray(): List<Int> {
    val array1 = mySortedDescending1(arrayListOf(1, 5, 2))
    val array2 = arrayListOf(1, 2, 3).mySortedDescending2()

    return array2
}

class Twelve : StringSpec({

    "Sort" {
        assertEquals(listOf(5, 2, 1), getArray())
    }
})
