package binary_tree_general

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return root

    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        val left = node.left
        node.left = node.right
        node.right = left
        if (node.left != null) {
            queue.add(node.left!!)
        }
        if (node.right != null) {
            queue.add(node.right!!)
        }
    }

    return root
    // recursive solution
//    val left = root.left
//    root.left = invertTree(root.right)
//    root.right = invertTree(left)
//
//    return root
}

fun main() {
    val root = TreeNode(3)
    val left = TreeNode(9)
    val right = TreeNode(20)
    right.right = TreeNode(7)
    right.left = TreeNode(15)
    root.left = left
    root.right = right

    val invert = invertTree(root)
}