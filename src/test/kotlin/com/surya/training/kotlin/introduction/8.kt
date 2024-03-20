package com.surya.training.kotlin.introduction

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Rewrite the following Java code using smart casts and when expression:
 * ```
 * public int eval(Expr expr) {
 *     if (expr instanceof Num) {
 *         return ((Num) expr).getValue();
 *     }
 *     if (expr instanceof Sum) {
 *         Sum sum = (Sum) expr;
 *         return eval(sum.getLeft()) + eval(sum.getRight());
 *     }
 *     throw new IllegalArgumentException("Unknown expression");
 * }
 * ```
 */
fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> {
            val sum = expr
            eval(sum.left) + eval(sum.right)
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

class Eight : StringSpec({

    "Num" {
        assertEquals(2, eval(Num(2)), "'eval' on Num should work:")
    }

    "Sum" {
        assertEquals(3, eval(Sum(Num(2), Num(1))), "'eval' on Sum should work:")
    }

    "Recursion" {
        assertEquals(6, eval(Sum(Sum(Num(1), Num(2)), Num(3))), "'eval' should work recursively:")
    }
})
