package sliding_window

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

fun minWindow(s: String, t: String): String {
    if (t.length > s.length) return ""

    val need = mutableMapOf<Char, Int>()
    for (c in t) {
        need[c] = need.getOrDefault(c, 0) + 1
    }

    val window = mutableMapOf<Char, Int>()
    var have = 0
    val needSize = need.size
    var left = 0
    var minLen = Int.MAX_VALUE
    var result = ""

    for (right in s.indices) {
        val c = s[right]
        window[c] = window.getOrDefault(c, 0) + 1

        if (c in need && window[c] == need[c]) {
            have++
        }

        // Try to shrink the window
        while (have == needSize) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1
                result = s.substring(left, right + 1)
            }

            // Remove the left character from the window
            val leftChar = s[left]
            window[leftChar] = window[leftChar]!! - 1

            if (leftChar in need && window[leftChar]!! < need[leftChar]!!) {
                have--
            }

            left++
        }
    }

    return result
}

fun main() {
    // s = "ADOBECODEBANC", t = "ABC"
    println(minWindow("ADOBECODEBANC", "ABC"))
}