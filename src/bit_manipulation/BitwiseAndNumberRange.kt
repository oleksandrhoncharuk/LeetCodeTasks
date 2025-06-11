package bit_manipulation

/**
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
 *
 *
 *
 * Example 1:
 *
 * Input: left = 5, right = 7
 * Output: 4
 * Example 2:
 *
 * Input: left = 0, right = 0
 * Output: 0
 * Example 3:
 *
 * Input: left = 1, right = 2147483647
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= left <= right <= 231 - 1
 */

fun rangeBitwiseAnd(left: Int, right: Int): Int {
    var shift = 0
    var l = left
    var r = right

    while (l < r) {
        l = l shr 1
        r = r shr 1
        shift++
    }

    return l shl shift
}

fun main() {
    println(rangeBitwiseAnd(5, 7)) // 4
}