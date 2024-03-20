package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Implement extension functions Shop.getCitiesCustomersAreFrom() and Shop.getCustomersFrom() using functions map and filter.
 *
 * ```
 *      val numbers = listOf(1, -1, 2)
 *      numbers.filter { it > 0 } == listOf(1, 2)
 *      numbers.map { it * it } == listOf(1, 1, 4)
 * ```
 */

// Return the set of cities the customers are from
fun Shop.getCitiesCustomersAreFrom(): Set<City> = customers.map { it.city }.toSet()

// Return a list of the customers who live in the given city
fun Shop.getCustomersFrom(city: City): List<Customer> = customers.filter { it.city == city }

class Two : StringSpec({

    "Cities customers are from" {
        assertEquals(setOf(Canberra, Vancouver, Budapest, Ankara, Tokyo), shop.getCitiesCustomersAreFrom())
    }

    "Customers from city" {
        assertEquals(listOf(customers[lucas], customers[cooper]), shop.getCustomersFrom(Canberra))
    }
})
