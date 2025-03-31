package array_string

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

fun majorityElement(nums: IntArray): Int {
    var k = 0
    var s = 0
    var i = 0

    nums.sort()

    while (i < nums.size) {
        if (s >= nums.size / 2) {
            k = nums[i]
            break
        }
        if (nums[i] == nums[i + 1]) s++
        i++
    }

    return k
}

fun main(args: Array<String>) {
//    val nums = intArrayOf(2,2,1,1,1,2,2)
    val nums = intArrayOf(3,2,3)


    println(majorityElement(nums))
}