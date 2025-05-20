package sliding_window

import kotlin.math.max

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

fun lengthOfLongestSubstring(s: String): Int {
    val charSet = mutableSetOf<Char>()

    var maxLength = 0
    var left = 0

    for (right in 0 until s.length) {
        while (charSet.contains(s[right])) {
            charSet.remove(s[left])
            left++
        }
        charSet.add(s[right])
        maxLength = max(maxLength, right - left + 1)
    }

    return maxLength
}

fun main() {
    // "abcabcbb"
    println(lengthOfLongestSubstring("abcabcbb")) // 3
    // "bbbbb"
    println(lengthOfLongestSubstring("bbbbb")) // 1
    // "pwwkew"
    println(lengthOfLongestSubstring("pwwkew")) // 3
    //"dvdf"
    println(lengthOfLongestSubstring("dvdf")) // 3

}