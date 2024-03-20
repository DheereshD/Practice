package com.surya.training.kotlin.builders

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * The previous examples can be rewritten using the library function apply (see examples below).
 * Write your own implementation of this function named 'myApply'.
 */

fun <T> T.myApply(f: T.() -> Unit): T { TODO() }

fun createString(): String {
    return StringBuilder().myApply {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun createMap(): Map<Int, String> {
    return hashMapOf<Int, String>().myApply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

class Three : StringSpec({

    "Build string" {
        val expected = StringBuilder().apply {
            append("Numbers: ")
            for (i in 1..10) {
                append(i)
            }
        }.toString()
        val actual = createString()
        assertEquals(expected, actual, "String should be built:")
    }

    "Build map" {
        val expected = HashMap<Int, String>().apply {
            put(0, "0")
            for (i in 1..10) {
                put(i, "$i")
            }
        }
        val actual = createMap()
        assertEquals(expected, actual, "Map should be filled with the right values")
    }
})
