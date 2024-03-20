package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Implement Shop.groupCustomersByCity() using groupBy.
 *
 * ```
 *      val result = listOf("a", "b", "ba", "ccc", "ad").groupBy { it.length() }
 *      result == mapOf(1 to listOf("a", "b"), 2 to listOf("ba", "ad"), 3 to listOf("ccc"))
 * ```
 */

// Return a map of the customers living in each city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = TODO()

class Eight : StringSpec({

    "Group customers by city" {
        assertEquals(groupedByCities, shop.groupCustomersByCity())
    }
})
