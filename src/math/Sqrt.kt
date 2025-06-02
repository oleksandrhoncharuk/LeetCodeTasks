package math

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 *
 * Constraints:
 *
 * 0 <= x <= 231 - 1
 */

fun mySqrt(x: Int): Int {
    return sqrtNewton(x.toDouble()).toInt()
}

fun sqrtNewton(x: Double, precision: Double = 1e-6): Double {
    if (x < 0) throw IllegalArgumentException("Negative input")
    if (x == 0.0 || x == 1.0) return x

    var guess = x
    while (kotlin.math.abs(guess * guess - x) > precision) {
        guess = 0.5 * (guess + x / guess)
    }
    return guess
}

fun binarySqrt(x: Int): Int {
    if (x < 2) return x

    var left = 1
    var right = x / 2
    var result = 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        val square = mid.toLong() * mid

        if (square == x.toLong()) return mid
        if (square < x) {
            result = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return result
}