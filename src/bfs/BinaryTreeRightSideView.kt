package bfs

import binary_tree_general.TreeNode
import java.util.LinkedList
import java.util.Queue

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5,null,4]
 *
 * Output: [1,3,4]
 *
 * Explanation:
 *
 *
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,null,null,null,5]
 *
 * Output: [1,3,4,5]
 *
 * Explanation:
 *
 *
 *
 * Example 3:
 *
 * Input: root = [1,null,3]
 *
 * Output: [1,3]
 *
 * Example 4:
 *
 * Input: root = []
 *
 * Output: []
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

fun rightSideView(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()

    if (root == null) return list

    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        list.add(queue.last().`val`)

        for (i in 0 until queue.size) {
            val node = queue.removeFirst()
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
    }

    return list
}

fun main() {
    val root = TreeNode(1)
    val left = TreeNode(2)
    val right = TreeNode(3)
    val left2 = TreeNode(4)
    left2.left = TreeNode(5)
    left.left = left2
    root.left = left
    root.right = right

    rightSideView(root).forEach {
        print("$it, ")
    }
}