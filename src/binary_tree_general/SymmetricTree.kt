package binary_tree_general

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 *
 */

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return true
    return isSymmetricRecursive(root.left, root.right)
}

private fun isSymmetricRecursive(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null)
        return true
    if (left == null || right == null)
        return false
    return if (left.`val` == right.`val`) {
        isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right, right.left)
    } else {
        false
    }
}

fun main() {

}