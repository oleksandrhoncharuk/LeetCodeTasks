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
    val sHashMap = HashMap<Char, Int>()
    val tHashMap = HashMap<Char, Int>()
    var counter = 0

    s.forEach { char ->
        sHashMap.setValueFor(char)
    }

    t.forEach { char ->
        tHashMap.setValueFor(char)
    }

    sHashMap.forEach { (key, value) ->
        if (tHashMap.contains(key) && tHashMap.getValue(key) == value) {
            counter++
        }
    }

    return counter == sHashMap.size && counter == tHashMap.size
}

private fun HashMap<Char, Int>.setValueFor(char: Char) {
    if (this.contains(char)) {
        val count = this.getValue(char)
        this[char] = count + 1
    } else {
        this[char] = 1
    }
}

fun main() {
    // "rat", t = "car"
    println(isAnagram("rat", "car")) // false

    // "anagram", t = "nagaram"
    println(isAnagram("anagram", "nagaram")) // true

    // s = "ggii" t = "eekk"
    println(isAnagram("ggii", "eekk")) // false
}