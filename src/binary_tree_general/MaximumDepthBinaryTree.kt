package binary_tree_general

import kotlin.math.max

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */


fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    var level = 0
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        for (i in 0 until queue.size) {
            val node = queue.removeFirst()
            if (node.left != null) {
                queue.add(node.left!!)
            }

            if (node.right != null) {
                queue.add(node.right!!)
            }
        }
        level++
    }

// recursion solution
//    val left = root.left
//    val right = root.right
//
//
//    return 1 + max(maxDepth(left), maxDepth(right))
    return level
}

fun main() {
    val root = TreeNode(3)
    val left = TreeNode(9)
    val right = TreeNode(20)
    right.right = TreeNode(7)
    right.left = TreeNode(15)
    root.left = left
    root.right = right

    println(maxDepth(root))
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}