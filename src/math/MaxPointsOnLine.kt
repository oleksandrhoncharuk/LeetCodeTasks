package math

import kotlin.math.abs

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * Example 2:
 *
 *
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * All the points are unique.
 */

fun maxPoints(points: Array<IntArray>): Int {
    if (points.size <= 2) return points.size

    var maxPoints = 0

    for (i in points.indices) {
        val slopes = mutableMapOf<Pair<Int, Int>, Int>()
        var duplicates = 1

        for (j in i + 1 until points.size) {
            var dx = points[j][0] - points[i][0]
            var dy = points[j][1] - points[i][1]

            if (dx == 0 && dy == 0) {
                duplicates++
                continue
            }

            val gcd = gcd(dy, dx)
            dx /= gcd
            dy /= gcd

            // Normalize direction (ensure dx is always positive)
            if (dx < 0) {
                dx = -dx
                dy = -dy
            } else if (dx == 0) {
                // vertical line → ensure dy is always positive
                dy = abs(dy)
            }

            val slope = Pair(dy, dx)
            slopes[slope] = slopes.getOrDefault(slope, 0) + 1
        }

        val localMax = slopes.values.maxOrNull() ?: 0
        maxPoints = maxOf(maxPoints, localMax + duplicates)
    }

    return maxPoints
}

fun gcd(a: Int, b: Int): Int {
    var x = abs(a)
    var y = abs(b)
    while (y != 0) {
        val temp = x % y
        x = y
        y = temp
    }
    return x
}