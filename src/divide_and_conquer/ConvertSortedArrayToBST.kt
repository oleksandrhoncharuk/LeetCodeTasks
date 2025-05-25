package divide_and_conquer

import binary_tree_general.TreeNode

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) return null
    return build(nums, 0, nums.size - 1)
}

fun build(nums: IntArray, left: Int, right: Int): TreeNode? {
    if (left > right) return null

    val mid = (left + right) / 2
    val root = TreeNode(nums[mid])
    root.left = build(nums, left, mid - 1)
    root.right = build(nums, mid + 1, right)

    return root
}

fun main() {
    sortedArrayToBST(intArrayOf(-10,-3,0,5,9))
}