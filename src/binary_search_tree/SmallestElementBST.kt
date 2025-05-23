package binary_search_tree

import binary_tree_general.TreeNode

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */

fun kthSmallest(root: TreeNode?, k: Int): Int {
    val stack = ArrayDeque<TreeNode>()
    var current = root
    var count = 0

    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }

        current = stack.removeLast()
        count++

        if (count == k) return current.`val`

        current = current.right
    }

    return -1
}

fun main() {
    //[3,1,4,null,2]
    val root = TreeNode(3)
    val left = TreeNode(1)
    left.right = TreeNode(2)
    root.left = left
    root.right = TreeNode(4)

    println(kthSmallest(root, 1))
}