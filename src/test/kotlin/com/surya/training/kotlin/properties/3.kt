package com.surya.training.kotlin.properties

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Read about delegated properties and make the property lazy by using delegates.
 */

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
    val lazyValue: Int = 0 // TODO()
}

class Three : StringSpec({

    "Lazy" {
        var initialized = false
        val lazyProperty = LazyPropertyUsingDelegates { initialized = true; 42 }
        assertFalse(initialized, "Property shouldn't be initialized before access")
        val result: Int = lazyProperty.lazyValue
        assertTrue(initialized, "Property should be initialized after access")
        assertEquals(42, result)
    }

    "Initialized once" {
        var initialized = 0
        val lazyProperty = LazyPropertyUsingDelegates { initialized++; 42 }
        lazyProperty.lazyValue
        lazyProperty.lazyValue
        assertEquals(1, initialized, "Lazy property should be initialized once")
    }
})
