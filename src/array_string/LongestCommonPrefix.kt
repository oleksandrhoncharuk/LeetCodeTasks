package array_string

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 */

fun longestCommonPrefix(strs: Array<String>): String {
    var commonPrefix = ""
    var minLength = strs.minBy { it.length }

    for ((index, char) in minLength.withIndex()) {
        var counter = 0
        for (i in 0 until strs.size) {
            if (index < strs[i].length && char == strs[i][index]) {
                counter++
            } else {
                break
            }
        }
        if (counter == strs.size) {
            commonPrefix = commonPrefix.plus(char)
        } else {
            break
        }
    }

    return commonPrefix
}

fun main() {
    val ar = arrayOf("reflower","flow","flight")

    println(longestCommonPrefix(ar))
}