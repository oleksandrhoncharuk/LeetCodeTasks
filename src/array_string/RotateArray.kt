package array_string

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * Follow up:
 *
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */

/*
[1, 2, 3, 4, 5, 6, 7]
[1, 2, 7, 4, 5, 6, 3]
[1, 6, 7, 4, 5, 2, 3]
[5, 6, 7, 4, 1, 2, 3]
[5, 6, 7, 1, 4, 2, 3]
[5, 6, 7, 1, 2, 4, 3]
[5, 6, 7, 1, 2, 3, 4]
 */

fun rotate(nums: IntArray, k: Int) {
    var startPointer = k - 1
    var last = nums.size - 1

    for (i in 0 until k) {
        val startElement = nums[startPointer]
        nums[startPointer] = nums[last]
        nums[last] = startElement

        last--
        startPointer--
    }

    if (nums.size % k != 0) {
        reverse(nums, k + 1, nums.size - 1)
        reverse(nums, k, nums.size - 1)
    }
}

fun rotate2(nums: IntArray, k: Int) {
    var mutableK = k
    val n = nums.size
    mutableK %= n
    reverse(nums, 0, n - 1)
    reverse(nums, 0, mutableK - 1)
    reverse(nums, mutableK, n - 1)
}

private fun reverse(nums: IntArray, start: Int, end: Int) {
    var start = start
    var end = end
    while (start < end) {
        val temp = nums[start]
        nums[start] = nums[end]
        nums[end] = temp
        start++
        end--
    }
}

fun main(args: Array<String>) {
//    nums = [1,2,3,4,5,6,7], k = 3
//    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
//    val k = 3

//    -1,-100,3,99
//    val nums = intArrayOf(-1,-100,3,99, 8, 6)
//    val k = 3

    val nums = IntArray(100000) { it }
    val k = 54944

    rotate(nums, k)

    nums.forEach {
        print("$it, ")
    }
}