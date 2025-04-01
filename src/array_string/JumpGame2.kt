package array_string

import kotlin.math.max

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */

fun jump(nums: IntArray): Int {
    var farthestReach = 0    // Tracks the farthest index we can jump to
    var jumps = 0            // Number of jumps needed
    var currentEndRange = 0  // The end of the current jump range

    for (i in 0 until nums.size - 1) {
        // Update the farthest point we can reach
        farthestReach = max(farthestReach, nums[i] + i)

        // If we have reached the end of the current range, increment the jump count
        if (i == currentEndRange) {
            jumps++
            currentEndRange = farthestReach

            // If we've reached or surpassed the last index, break early
            if (currentEndRange >= nums.size - 1) break
        }
    }

    return jumps
}

fun main(args: Array<String>) {
//    val nums1 = intArrayOf(2,3,1,1,4) //2
//    val nums2 = intArrayOf(2,3,0,1,4) //2
    val nums3 = intArrayOf(0) //0
//    val nums4 = intArrayOf(1,2,3) //2
//    val nums5 = intArrayOf(1,2,1,1,1) //3
//    val nums6 = intArrayOf(1, 1, 1, 1, 1, 1)
    val nums7 = intArrayOf(1)

//    println(jump(nums1))
//    println(jump(nums2))
    println(jump(nums3))
//    println(jump(nums4))
//    println(jump(nums5))
//    println(jump(nums6))
    println(jump(nums7))
}