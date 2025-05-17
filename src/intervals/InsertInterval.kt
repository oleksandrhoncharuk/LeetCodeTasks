package intervals

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    val size = intervals.size
    var i = 0

    while (i < size && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i])
        i++
    }

    var mergedStart = newInterval[0]
    var mergedEnd = newInterval[1]

    while (i < size && intervals[i][0] <= mergedEnd) {
        mergedStart = minOf(mergedStart, intervals[i][0])
        mergedEnd = maxOf(mergedEnd, intervals[i][1])
        i++
    }
    result.add(intArrayOf(mergedStart, mergedEnd))

    while (i < size) {
        result.add(intervals[i])
        i++
    }

    return result.toTypedArray()
}

fun main() {
    // [[1,3],[6,9]], newInterval = [2,5]
    // * Output: [[1,5],[6,9]]

    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(6, 9)
    )

    insert(intervals, intArrayOf(2, 5)).forEach {
        println("${it[0]}, ${it[1]}")
    }

    // intervals =
    //[[1,2],[3,5],[6,7],[8,10],[12,16]]
    //newInterval =
    //[4,8]

    val intervals1 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 5),
        intArrayOf(6, 7),
        intArrayOf(8, 10),
        intArrayOf(12, 16),
    )

    insert(intervals1, intArrayOf(4, 8)).forEach {
        println("${it[0]}, ${it[1]}")
    }
}