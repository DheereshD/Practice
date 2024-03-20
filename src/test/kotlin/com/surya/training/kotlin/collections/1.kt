package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 *This part was inspired by GS Collections Kata.
 * Default collections in Kotlin are Java collections, but there are lots of useful extension functions for them.
 * For example, operations that transform a collection to another one, starting with 'to': toSet or toList.
 *
 * Implement an extension function Shop.getSetOfCustomers().
 * The class Shop and all related classes can be found at Shop.kt.
 */

fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()

class One : StringSpec({

    "Set of Customers" {
        assertEquals(customers.values.toSet(), shop.getSetOfCustomers())
    }
})
