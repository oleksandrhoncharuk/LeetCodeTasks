package binary_tree_general

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
var rootIndex: Int = 0

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val indexMap = mutableMapOf<Int, Int>()
    preorder.forEach { root ->
        indexMap.put(root, inorder.indexOf(root))
    }

    return buildTree(preorder, inorder, 0, inorder.size, indexMap)
}

private fun buildTree(
    preorder: IntArray,
    inorder: IntArray,
    leftEdge: Int,
    rightEdge: Int,
    indexMap: Map<Int, Int>
) :TreeNode? {
    if (leftEdge >= rightEdge) return null
    val root = TreeNode(preorder[rootIndex])
    val inorderIndex = indexMap[preorder[rootIndex++]]!!
    root.left = buildTree(preorder, inorder, leftEdge, inorderIndex, indexMap)
    root.right = buildTree(preorder, inorder, inorderIndex + 1, rightEdge, indexMap)
    return root
}

fun main() {

}