package com.surya.training.kotlin.introduction

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Read about object expressions that play the same role in Kotlin as anonymous classes in Java.
 *
 * Add an object expression that provides a comparator to sort a list in a descending order using java.util.Collections class.
 * In Kotlin you use Kotlin library extensions instead of java.util.Collections,
 * but this example is still a good demonstration of mixing Kotlin and Java code.
 *
 */

fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)

    arrayList.sortWith(compareBy { -it })
    return arrayList
}

class Ten : StringSpec({

    "Sort" {
        assertEquals(listOf(5, 2, 1), getList())
    }
})
