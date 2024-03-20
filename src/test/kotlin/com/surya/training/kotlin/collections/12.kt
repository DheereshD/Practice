package com.surya.training.kotlin.collections

import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

/**
 * Rewrite the following Java function to Kotlin.
 *
 * ```
 *      public Collection<String> doSomethingStrangeWithCollection(
 *          Collection<String> collection
 *      ) {
 *          Map<Integer, List<String>> groupsByLength = Maps.newHashMap();
 *          for (String s : collection) {
 *              List<String> strings = groupsByLength.get(s.length());
 *              if (strings == null) {
 *                  strings = Lists.newArrayList();
 *                  groupsByLength.put(s.length(), strings);
 *              }
 *              strings.add(s);
 *          }
 *
 *          int maximumSizeOfGroup = 0;
 *          for (List<String> group : groupsByLength.values()) {
 *              if (group.size() > maximumSizeOfGroup) {
 *                  maximumSizeOfGroup = group.size();
 *              }
 *          }
 *
 *          for (List<String> group : groupsByLength.values()) {
 *              if (group.size() == maximumSizeOfGroup) {
 *                  return group;
 *              }
 *          }
 *          return null;
 *      }
 * ```
 *
 */

fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { s -> TODO() }

    TODO("Uncomment") // val maximumSizeOfGroup = groupsByLength.values.map { group -> TODO() }.max()

    return groupsByLength.values.firstOrNull { group -> TODO() }
}

class Twelve : StringSpec({

    fun doTest(expected: Collection<String>?, argument: Collection<String>) {
        assertEquals(expected, doSomethingStrangeWithCollection(argument), "The function 'doSomethingStrangeWithCollection' should do at least something with a collection:")
    }

    "Collection of one element" {
        doTest(listOf("a"), listOf("a"))
    }

    "Empty collection" {
        doTest(null, listOf())
    }

    "Simple collection" {
        doTest(listOf("a", "c"), listOf("a", "bb", "c"))
    }

    "Collection with empty strings" {
        doTest(listOf("", "", "", ""), listOf("", "", "", "", "a", "bb", "ccc", "dddd"))
    }

    "Collection with two groups of maximal size" {
        doTest(listOf("a", "c"), listOf("a", "bb", "c", "dd"))
    }
})
