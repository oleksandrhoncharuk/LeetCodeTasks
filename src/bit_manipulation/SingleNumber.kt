package bit_manipulation

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 *
 * Output: 4
 *
 * Example 3:
 *
 * Input: nums = [1]
 *
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */

fun singleNumber(nums: IntArray): Int {
    var result = nums[0]

    for (i in 1 until nums.size) {
        result = result xor nums[i]
    }

    return result
}

fun main() {
    println(singleNumber(intArrayOf(2,2,1)))
}