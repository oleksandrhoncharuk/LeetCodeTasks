package hashmap

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return emptyList()

    val map = mutableMapOf<String, MutableList<String>>()

    for (word in strs) {
        val key = word.toCharArray().sorted().joinToString("")
        map.computeIfAbsent(key) { mutableListOf() }.add(word)
    }

    return map.values.toList()
}

fun main() {
    groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")).forEach {
        println("anagrams")
        it.forEach { str ->
            println(str)
        }
    }
}