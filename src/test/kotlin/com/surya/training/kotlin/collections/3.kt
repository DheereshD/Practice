package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Implement all the functions below using all, any, count, find.
 *
 * ```
 *      val numbers = listOf(-1, 0, 2)
 *      val isZero: (Int) -> Boolean = { it == 0 }
 *      numbers.any(isZero) == true
 *      numbers.all(isZero) == false
 *      numbers.count(isZero) == 1
 *      numbers.find { it > 0 } == 2
 * ```
 */

// Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean {
    return customers.all { it.city == city }
}

// Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City): Boolean = customers.any { it.city == city }

// Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City): Int = customers.count { it.city == city }

// Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City): Customer? = customers.find { it.city == city }

class Three : StringSpec({

    "All customers are from city" {
        assertFalse(shop.checkAllCustomersAreFrom(Canberra))
    }

    "Any customer is from city" {
        assertTrue(shop.hasCustomerFrom(Canberra))
    }

    "Count customers from city" {
        assertEquals(2, shop.countCustomersFrom(Canberra))
    }

    "Any customer from city" {
        assertEquals(customers[lucas], shop.findAnyCustomerFrom(Canberra))
        assertEquals(null, shop.findAnyCustomerFrom(City("Chicago")))
    }
})
