package com.surya.training.kotlin.introduction

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * When an object implements a SAM interface (one with a Single Abstract Method), you can pass a lambda instead.
 * Read more about SAM-conversions.
 *
 * In the previous example change an object expression to a lambda.
 */

fun getArrayList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    arrayList.sortWith(compareByDescending { it })
    return arrayList
}

class Eleven : StringSpec({

    "Sort" {
        assertEquals(listOf(5, 2, 1), getArrayList())
    }
})

// ---
