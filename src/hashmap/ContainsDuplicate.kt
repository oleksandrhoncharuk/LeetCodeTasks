package hashmap

/**
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j]
 * and abs(i - j) <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val window = HashSet<Int>()
    var left = 0

    for (i in nums.indices) {
        if (i - left > k) {
            window.remove(nums[left])
            left++
        }
        if (window.contains(nums[i])) {
            return true
        }
        window.add(nums[i])
    }

    return false
}

fun main() {
    // nums = [1,2,3,1], k = 3
    println(containsNearbyDuplicate(intArrayOf(1,2,3,1), 3))
}