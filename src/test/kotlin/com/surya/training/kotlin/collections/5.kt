// package com.surya.training.kotlin.collections
//
// import io.kotest.core.spec.style.StringSpec
// import kotlin.test.assertEquals
//
// /**
// * Implement Shop.getCustomerWithMaximumNumberOfOrders() and Customer.getMostExpensiveOrderedProduct() using max, min, maxBy, or minBy.
// *
// * ```
// *      listOf(1, 42, 4).max() == 42
// *      listOf("a", "ab").minBy { it.length } == "a"
// * ```
// */
//
// // Return a customer whose order count is the highest among all customers
// fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
//    return customers.maxBy { it.orders.size }
// }
//
// // Return the most expensive product which has been ordered
// fun Customer.getMostExpensiveOrderedProduct(): Product? {
//    return orders.maxBy { it.products.price }
// }
//
// class Five : StringSpec({
//
//    "Customer with maximum number of orders" {
//        assertEquals(customers[reka], shop.getCustomerWithMaximumNumberOfOrders())
//    }
//
//    "The most expensive ordered product" {
//        assertEquals(rubyMine, customers.getValue(nathan).getMostExpensiveOrderedProduct())
//    }
// })
