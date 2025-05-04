package bfs

import binary_tree_general.TreeNode

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val result = ArrayList<List<Int>>()
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        result.add(queue.map { treeNode -> treeNode.`val` }.toList())

        for (i in 0 until queue.size) {
            val node = queue.removeFirst()

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
    }

    return result
}

fun main() {

}