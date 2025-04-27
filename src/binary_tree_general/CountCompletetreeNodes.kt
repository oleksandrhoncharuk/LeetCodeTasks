package binary_tree_general

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * Example 2:
 *
 * Input: root = []
 * Output: 0
 * Example 3:
 *
 * Input: root = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5 * 104].
 * 0 <= Node.val <= 5 * 104
 * The tree is guaranteed to be complete.
 */

fun countNodes(root: TreeNode?): Int {
    // Recursive solution
//    if (root == null) return 0
//    return 1 + countNodes(root.left) + countNodes(root.right)

    if (root == null) return 0

    var nodes = 1
    val deque = ArrayDeque<TreeNode>()
    deque.add(root)

    while (deque.isNotEmpty()) {
        for (i in 0 until deque.size) {
            val currentRoot = deque.removeFirst()
            if (currentRoot.left != null) {
                deque.add(currentRoot.left!!)
                nodes++
            }

            if (currentRoot.right != null) {
                deque.add(currentRoot.right!!)
                nodes++
            }
        }
    }

    return nodes
}

fun main() {

}