package hashmap

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 *
 * Output: true
 *
 * Explanation:
 *
 * The strings s and t can be made identical by:
 *
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 *
 * Output: false
 *
 * Explanation:
 *
 * The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */

fun isIsomorphic(s: String, t: String): Boolean {
    val replacedS = s.toCharArray()

    val charMap = buildMap<Char, Char> {
        s.forEachIndexed { index, char ->
            if (!this.contains(char) && !this.containsValue(t[index])) {
                this[char] = t[index]
            }
        }
    }

    s.forEachIndexed { index, char ->
        if (charMap.contains(char)) {
            val replacement = charMap[char]
            replacedS[index] = replacement!!
        } else {
            return false
        }
    }

    return String(replacedS) == t
}

fun main() {
//    // "egg", t = "add"
//    println(isIsomorphic("egg", "add")) // true
//
//    // "foo", t = "bar"
//    println(isIsomorphic("foo", "bar")) // false

//    println(isIsomorphic("bbbaaaba", "aaabbbba"))

    println(isIsomorphic("badc", "baba"))
}