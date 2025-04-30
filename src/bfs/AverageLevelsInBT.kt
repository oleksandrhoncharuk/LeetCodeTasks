package bfs

import binary_tree_general.TreeNode
import java.util.LinkedList
import java.util.Queue

/**
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 *
 *
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */

fun averageOfLevels(root: TreeNode?): DoubleArray {
    val list = mutableListOf<Double>()

    if (root == null) {
        return list.toDoubleArray()
    }

    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val levelLength = queue.size
        var levelSum = 0.0

        for (i in 0 until levelLength) {
            val node = queue.poll()
            levelSum += node.`val`

            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }
        levelSum /= levelLength
        list.add(levelSum)
    }

    return list.toDoubleArray()
}

fun main() {
    // [5,2,-3]
    val root = TreeNode(5)
    root.left = TreeNode(2)
    root.right = TreeNode(-3)

    val list = averageOfLevels(root)
    list.forEach {
        print("$it ,")
    }
}
