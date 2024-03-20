package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Implement Shop.getSetOfProductsOrderedByEveryCustomer() using fold.
 *
 * ```
 *      listOf(1, 2, 3, 4).fold(1, {
 *          partProduct, element ->
 *          element * partProduct
 *      }) == 24
 * ```
 */

// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    TODO()
}

class Ten : StringSpec({

    "Get products ordered by all customers" {
        val testShop = shop(
            "test shop for 'fold'",
            customer(
                lucas,
                Canberra,
                order(idea),
                order(webStorm),
            ),
            customer(
                reka,
                Budapest,
                order(idea),
                order(youTrack),
            ),
        )
        assertEquals(setOf(idea), testShop.getSetOfProductsOrderedByEveryCustomer())
    }
})
