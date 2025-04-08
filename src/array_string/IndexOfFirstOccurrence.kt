package array_string

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */

fun strStr(haystack: String, needle: String): Int {
    val haystackSize = haystack.length
    val needleSize = needle.length

    for (i in 0 until haystackSize - needleSize + 1) {
        if (needle == haystack.subSequence(i, i + needleSize)) {
            return i
        }
    }

    return -1
}

fun main() {
//    haystack = "sadbutsad", needle = "sad"
    println(strStr("sodbutsad", "sad"))

//    "leetcode", needle = "leeto"
    println(strStr("leetcode", "leeto"))
}