package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Implement Customer.getOrderedProducts() and Shop.getAllOrderedProducts() using flatMap.
 *
 * ```
 *      val result = listOf("abc", "12").flatMap { it.toCharList() }
 *      result == listOf('a', 'b', 'c', '1', '2')
 * ```
 */

// Return all products this customer has ordered
val Customer.orderedProducts: Set<Product> get() {

    return orders.flatMap { it.products }.toSet()
}

// Return all products that were ordered by at least one customer
val Shop.allOrderedProducts: Set<Product> get() {
    return customers.flatMap { it.orders.flatMap { it.products } }.toSet()
}

class Four : StringSpec({

    "Get ordered product set" {
        assertEquals(setOf(idea), customers.getValue(reka).orderedProducts)
    }

    "Get all ordered product test" {
        assertEquals(orderedProducts, shop.allOrderedProducts)
    }
})
