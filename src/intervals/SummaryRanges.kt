package intervals

import java.util.Collections

/**
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is
 * no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 *
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 */

fun summaryRanges(nums: IntArray): List<String> {
    if (nums.isEmpty()) return emptyList()
    val result = mutableListOf<String>()

    var start = nums[0]
    var end = nums[0]

    for (i in 0 until nums.size) {
        val next = if (i + 1 <= nums.lastIndex) nums[i + 1] else end
        if (next - end == 1) {
            end = next
        } else {
            if (start == end) {
                result.add(start.toString())
            } else {
                result.add("$start->$end")
            }
            start = next
            end = next
        }
    }

    return result
}

fun main() {
    // Input: nums = [0,2,3,4,6,8,9]
    // * Output: ["0","2->4","6","8->9"]
    val nums = intArrayOf(0,2,3,4,6,8,9)
    summaryRanges(nums).forEach {
        print("$it ")
    }

    // Input: nums = [0,1,2,4,5,7]
    // Output: ["0->2","4->5","7"]
    val nums1 = intArrayOf()
}