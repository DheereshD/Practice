package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Implement Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered() using partition.
 *
 * ```
 *      val numbers = listOf(1, 3, -4, 2, -11)
 *      val (positive, negative) = numbers.partition { it > 0 }
 *      positive == listOf(1, 3, 2)
 *      negative == listOf(-4, -11)
 * ```
 *
 *  Note that destructuring declaration syntax is used in this example.
 */

// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> = TODO()

class Nine : StringSpec({

    "Get customers who have more undelivered orders than delivered" {
        assertEquals(setOf(customers[reka]), shop.getCustomersWithMoreUndeliveredOrdersThanDelivered())
    }
})
