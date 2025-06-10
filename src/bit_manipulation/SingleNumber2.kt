package bit_manipulation

/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 */

fun singleNumber2(nums: IntArray): Int {
    var result = 0

    for (i in 0 until 32) {
        var bitSum = 0
        for (num in nums) {
            bitSum += (num shr i) and 1
        }
        if (bitSum % 3 != 0) {
            result = result or (1 shl i)
        }
    }

    return result
}