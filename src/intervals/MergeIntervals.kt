package intervals

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return emptyArray()

    intervals.sortBy { it[0] }

    val result = mutableListOf<IntArray>()
    var currentStart = intervals[0][0]
    var currentEnd = intervals[0][1]

    for (i in 1 until intervals.size) {
        val nextStart = intervals[i][0]
        val nextEnd = intervals[i][1]

        if (nextStart <= currentEnd) {
            currentEnd = maxOf(currentEnd, nextEnd)
        } else {
            result.add(intArrayOf(currentStart, currentEnd))
            currentStart = nextStart
            currentEnd = nextEnd
        }
    }

    result.add(intArrayOf(currentStart, currentEnd))

    return result.toTypedArray()
}

fun main() {
    // intervals = [[1,3],[2,6],[8,10],[15,18]]
    //Output: [[1,6],[8,10],[15,18]]

    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18),
    )

    val result = merge(intervals)

    for (interval in result) {
        println("${interval[0]}, ${interval[1]}")
    }
}
