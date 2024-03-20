package com.surya.training.kotlin.introduction

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Read about higher-order functions and function literals, also known as [lambdas](https://kotlinlang.org/docs/reference/lambdas.html).
 * Pass a lambda to the [Collection.any] function to check if the collection contains an even number.
 * The function [Collection.any] gets a predicate as an argument and returns true if there is at least one element satisfying the predicate.
 */
fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }

class Four : StringSpec({

    "even" {
        assertTrue(containsEven(listOf(1, 2, 3)))
    }

    "odd" {
        assertFalse(containsEven(listOf(1)))
    }

    "test empty collection" {
        assertFalse(containsEven(listOf()))
    }
})
