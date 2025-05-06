package binary_search_tree

import binary_tree_general.TreeNode
import kotlin.math.min

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 *
 *
 * Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */

fun getMinimumDifference(root: TreeNode?): Int {
    var minDistance = Int.MAX_VALUE
    var prev: Int? = null

    fun dfs(node: TreeNode?) {
        if (node == null) return

        dfs(node.left)

        if (prev != null) {
            minDistance = min(minDistance, node.`val` - prev!!)
        }

        prev = node.`val`

        dfs(node.right)
    }

    dfs(root)
    return minDistance
}