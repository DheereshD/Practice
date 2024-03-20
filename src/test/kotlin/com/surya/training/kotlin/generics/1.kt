package com.surya.training.kotlin.generics

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Make the following code compile by implementing a partitionTo function that splits a collection into two collections according to the predicate.
 *
 * There is a partition() function in the standard library that always returns two newly created lists.
 * You should write a function that splits the collection into two collections given as arguments.
 * The signature of the toCollection() function from the standard library may help you.
 */

fun <T, C : MutableCollection<T>> Collection<T>.partitionTo(first: C, second: C, predicate: (T) -> Boolean): Pair<C, C> = TODO()

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    val (words, lines) = partitionTo(first = ArrayList(), second = ArrayList()) { s -> !s.contains(" ") }
    return words to lines
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    val (letters, other) = partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    return letters to other
}

class One : StringSpec({

    "Partition words and lines" {
        val (words, lines) = listOf("a", "a b", "c", "d e").partitionWordsAndLines()
        assertEquals(listOf("a", "c"), words)
        assertEquals(listOf("a b", "d e"), lines)
    }

    "Partition Letters and other symbols" {
        val (letters, other) = setOf('a', '%', 'r', '}').partitionLettersAndOtherSymbols()
        assertEquals(setOf('a', 'r'), letters)
        assertEquals(setOf('%', '}'), other)
    }
})
