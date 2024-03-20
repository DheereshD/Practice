package com.surya.training.kotlin.introduction

import io.kotest.core.spec.style.StringSpec

/**
 * Default and named arguments help to minimize the number of overloads and improve the readability of the function invocation.
 * The library function [joinToString] has declared with default values for some parameters.
 * Specifying only two arguments make the function joinOptions() return the list in a format like this: "[a, b, c]".
 * Look up the documentation of [joinToString] and implement joinOptions().
 */
fun joinOptions(options: Collection<String>): String = options.joinToString(prefix = "[", postfix = "]", separator = ", ")

class Two : StringSpec({

    "join options on two strings" {
        assert("[a, b]" == joinOptions(listOf("a", "b")))
    }

    "join options on three strings" {
        assert("[a, b, c]" == joinOptions(listOf("a", "b", "c")))
    }

    "join options on one string" {
        assert("[a]" == joinOptions(listOf("a")))
    }

    "join options on no strings" {
        assert("[]" == joinOptions(listOf()))
    }
})
