package com.surya.training.kotlin.introduction

import io.kotest.core.spec.style.StringSpec

/**
 * Write an implementation for `start` that returns a string "OK"
 */
fun start(): String = "OK"

class One : StringSpec({

    "return OK" {
        assert(start() == "OK")
    }
})

changes