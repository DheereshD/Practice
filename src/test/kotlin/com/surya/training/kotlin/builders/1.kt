package com.surya.training.kotlin.builders

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Read about function literals with receiver.
 *
 * You can declare isEven and isOdd as values, that can be called as extension functions. Complete the declarations below.
 */

fun task(): List<Boolean> {
    val isEven: Int.() -> Boolean = TODO()
    val isOdd: Int.() -> Boolean = TODO()

    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}

class One : StringSpec({

    "Is odd and is even" {
        val result = task()
        assertEquals(listOf(false, true, true), result, "The functions 'isOdd' and 'isEven' should be implemented correctly")
    }
})
