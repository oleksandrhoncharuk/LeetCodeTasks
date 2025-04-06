package array_string

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal
 *
 * consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 104
 *     s consists of only English letters and spaces ' '.
 *     There will be at least one word in s.
 *
 */

fun lengthOfLastWord(s: String): Int {
    var isWordStart = false
    var symbolCounter = 0

    for (i in s.length - 1 downTo 0) {
        val currentSymbol = s.elementAt(i)

        if (isWordStart && currentSymbol == ' ') break
        if (currentSymbol == ' ') continue
        else {
            isWordStart = true
            symbolCounter++
        }
    }

    return symbolCounter
}

fun main() {
//    val s = "luffy is still joyboy"
    val s = "   fly me   to   the moon  "

    println(lengthOfLastWord(s))
}