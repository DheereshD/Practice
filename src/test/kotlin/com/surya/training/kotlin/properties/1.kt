package com.surya.training.kotlin.properties

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Read about properties in Kotlin.
 *
 * Add a custom setter to PropertyExample.propertyWithCounter so that the counter property is incremented every time propertyWithCounter is assigned to.
 */

class PropertyExample {
    var counter: Int = 0
    var propertyWithCounter: Int? = null
}

class One : StringSpec({

    "Property with counter" {
        val q = PropertyExample()
        q.propertyWithCounter = 14
        q.propertyWithCounter = 21
        q.propertyWithCounter = 32
        assertEquals(3, q.counter, "The property q.counter should contain the number of assignments to q.propertyWithCounter:")
        // Here we have to use !! due to false smart cast impossible
        assertEquals(32, q.propertyWithCounter!!, "The property q.propertyWithCounter should be set:")
    }
})
