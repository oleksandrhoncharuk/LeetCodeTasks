package hashmap

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

fun isAnagram(s: String, t: String): Boolean {
    val sSum = s.fold(0) { ac , char ->
        ac + char.code
    }

    val tSum = t.fold(0) { ac , char ->
        ac + char.code
    }

    return sSum == tSum
}

fun main() {
//    // "rat", t = "car"
//    println(isAnagram("rat", "car")) // false
//
//    // "anagram", t = "nagaram"
//    println(isAnagram("anagram", "nagaram")) // true

    // s = "ggii" t = "eekk"
    println(isAnagram("ggii", "eekk")) // false
}