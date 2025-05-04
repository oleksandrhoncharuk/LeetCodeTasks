package bfs

import binary_tree_general.TreeNode

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
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
 * -100 <= Node.val <= 100
 */

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    var reverse = false

    if (root == null) return result

    val deque = ArrayDeque<TreeNode>()
    deque.add(root)

    while (deque.isNotEmpty()) {
        val list = deque.map { treeNode -> treeNode.`val` }.toMutableList()
        if (reverse){
            list.reverse()
        }
        result.add(list)
        reverse = !reverse

        for (i in 0 until deque.size) {
            val node = deque.removeFirst()

            node.left?.let { deque.add(it) }
            node.right?.let { deque.add(it) }
        }
    }

    return result
}