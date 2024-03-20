package com.surya.training.kotlin.builders

import io.kotest.core.spec.style.StringSpec
import java.util.HashMap
import kotlin.test.assertEquals

/**
 * Extension function literals are very useful for creating builders, e.g.:
 *
 * ```
 *      fun buildString(build: StringBuilder.() -> Unit): String {
 *          val stringBuilder = StringBuilder()
 *          stringBuilder.build()
 *          return stringBuilder.toString()
 *      }
 *
 *      val s = buildString {
 *          this.append("Numbers: ")
 *          for (i in 1..3) {
 *              // 'this' can be omitted
 *              append(i)
 *          }
 *      }
 *
 *      s == "Numbers: 123"
 * ```
 *
 * Add and implement the function 'buildMap' with one parameter (of type extension function) creating a new HashMap, building it and returning it as a result.
 * The usage of this function is shown below.
 */

/* TODO */

fun usage(): Map<Int, String> {
    TODO("Uncomment below code")
//    return buildMap {
//        put(0, "0")
//        for (i in 1..10) {
//            put(i, "$i")
//        }
//    }
}

class Two : StringSpec({

    "Build map" {
        val map = usage()
        val expected = HashMap<Int, String>()
        for (i in 0..10) {
            expected[i] = "$i"
        }
        assertEquals(expected, map, "Map should be filled with the right values")
    }
})
