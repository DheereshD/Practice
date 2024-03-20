package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Implement Customer.getTotalOrderPrice() using sum or sumBy.
 *
 * ```
 *      listOf(1, 5, 3).sum() == 9
 *      listOf("a", "b", "cc").sumBy { it.length() } == 4
 * ```
 */

// Return the sum of prices of all products that a customer has ordered.
// Note: the customer may order the same product for several times.
fun Customer.getTotalOrderPrice(): Double = TODO()

class Seven : StringSpec({

    "Get total order price" {
        assertEquals(148.0, customers.getValue(nathan).getTotalOrderPrice())
    }

    "Total price for repeated products" {
        assertEquals(586.0, customers.getValue(lucas).getTotalOrderPrice())
    }
})
