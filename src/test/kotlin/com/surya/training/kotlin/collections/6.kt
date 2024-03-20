package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Implement Shop.getCustomersSortedByNumberOfOrders() using sorted or sortedBy.
 *
 * ```
 *      listOf("bbb", "a", "cc").sorted() == listOf("a", "bbb", "cc")
 *      listOf("bbb", "a", "cc").sortedBy { it.length } == listOf("a", "cc", "bbb")
 * ```
 */

// Return a list of customers, sorted by the ascending number of orders they made
fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> {
    return listOf(customers).sortedBy { it.order.product }
}

class Six : StringSpec({

    "Get customers sorted by number of orders" {
        assertEquals(sortedCustomers, shop.getCustomersSortedByNumberOfOrders())
    }
})
