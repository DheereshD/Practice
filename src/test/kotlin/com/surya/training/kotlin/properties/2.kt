package com.surya.training.kotlin.properties

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Add a custom getter to make the 'lazy' val really lazy. It should be initialized by the invocation of 'initializer()' at the moment of the first access.
 *
 * You can add as many additional properties as you need.
 *
 * Do not use delegated properties!
 */

class LazyProperty(val initializer: () -> Int) {
    /* TODO */
    val lazy: Int
        get() {
            TODO()
        }
}

class Two : StringSpec({

    "Lazy" {
        var initialized = false
        val lazyProperty = LazyProperty { initialized = true; 42 }
        assertFalse(initialized, "Property shouldn't be initialized before access")
        val result: Int = lazyProperty.lazy
        assertTrue(initialized, "Property should be initialized after access")
        assertEquals(42, result)
    }

    "Initialized once" {
        var initialized = 0
        val lazyProperty = LazyProperty { initialized++; 42 }
        lazyProperty.lazy
        lazyProperty.lazy
        assertEquals(1, initialized, "Lazy property should be initialized once")
    }
})
