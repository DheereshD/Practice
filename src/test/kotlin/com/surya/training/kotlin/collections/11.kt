package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Implement Customer.getMostExpensiveDeliveredProduct() and Shop.getNumberOfTimesProductWasOrdered() using functions from the Kotlin standard library.
 */

// Return the most expensive product among all delivered products
// (use the Order.isDelivered flag)
fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    TODO()
}

// Return how many times the given product was ordered.
// Note: a customer may order the same product for several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    TODO()
}

/* TODO */

class Eleven : StringSpec({

    "Most expensive delivered product" {
        val testShop = shop(
            "test shop for 'most expensive delivered product'",
            customer(
                lucas,
                Canberra,
                order(idea, isDelivered = false),
                order(reSharper),
            ),
        )
        assertEquals(reSharper, testShop.customers[0].getMostExpensiveDeliveredProduct())
    }

    "Number of times each product was ordered" {
        assertEquals(4, shop.getNumberOfTimesProductWasOrdered(idea))
    }

    "Number of times each product was ordered for repeated product" {
        assertEquals(3, shop.getNumberOfTimesProductWasOrdered(reSharper), "A customer may order a product for several times")
    }

    "Number of times each product was ordered for repeated in order product" {
        assertEquals(3, shop.getNumberOfTimesProductWasOrdered(phpStorm), "An order may contain a particular product more than once")
    }
})
