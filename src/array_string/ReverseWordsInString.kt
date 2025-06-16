package array_string

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 *
 *
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */

fun reverseWords(s: String): String {
    return s.trim()
        .split("\\s+".toRegex())
        .reversed()
        .joinToString(" ")
}

fun reverseWordsInPlace(s: String): String {
    val chars = s.toCharArray()
    val n = chars.size

    // Step 1: Clean spaces (in-place compaction)
    val length = cleanSpaces(chars, n)

    // Step 2: Reverse whole string
    reverse(chars, 0, length - 1)

    // Step 3: Reverse each word
    var start = 0
    for (i in 0..length) {
        if (i == length || chars[i] == ' ') {
            reverse(chars, start, i - 1)
            start = i + 1
        }
    }

    return String(chars, 0, length)
}

// Remove extra spaces and compact string
fun cleanSpaces(chars: CharArray, n: Int): Int {
    var i = 0
    var j = 0

    // Skip leading spaces
    while (j < n && chars[j] == ' ') j++

    while (j < n) {
        // Copy non-space characters
        if (chars[j] != ' ') {
            chars[i++] = chars[j++]
        }
        // For space: only copy if last char wasn't a space
        else {
            // Write one space, skip rest
            chars[i++] = ' '
            while (j < n && chars[j] == ' ') j++
        }
    }

    // Remove trailing space
    return if (i > 0 && chars[i - 1] == ' ') i - 1 else i
}

// Reverse helper
fun reverse(chars: CharArray, left: Int, right: Int) {
    var l = left
    var r = right
    while (l < r) {
        val temp = chars[l]
        chars[l] = chars[r]
        chars[r] = temp
        l++
        r--
    }
}

fun main() {
    println(reverseWords("the sky is blue"))
    println(reverseWordsInPlace("the sky is blue"))
}