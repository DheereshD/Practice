package com.surya.training.kotlin.conventions

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Objects with invoke() method can be invoked as a function.
 *
 * You can add invoke extension for any class, but it's better not to overuse it:
 *
 * ```
 * fun Int.invoke() { println(this) }
 *
 * 1() //huh?..
 * ```
 *
 * Implement the function Invokable.invoke() so it would count a number of invocations.
 */

class Seven : StringSpec({

    class Invokable {
        var numberOfInvocations: Int = 0
            private set
        operator fun invoke(): Invokable {
            numberOfInvocations++
            return this
        }
    }
    fun invokeTwice(invokable: Invokable) = invokable()()

    "Basic Test" {
        assertEquals(4, invokeTwice(invokeTwice(Invokable())).numberOfInvocations)
    }

    "Number of invocations" {
        val message = "The number of invocations is incorrect"
        fun testInvokable(numberOfInvocations: Int, invokeSeveralTimes: (Invokable) -> Invokable) {
            val invokable = Invokable()
            assertEquals(numberOfInvocations, invokeSeveralTimes(invokable).numberOfInvocations, message)
        }

        testInvokable(1) { it() }
        testInvokable(5) { it()()()()() }
        testInvokable(0) { it }
    }
})
