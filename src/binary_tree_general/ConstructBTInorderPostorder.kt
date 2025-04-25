package binary_tree_general

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */

var rootIndexPostorder: Int = 0

fun buildTreePostorder(inorder: IntArray, postorder: IntArray): TreeNode? {
    return buildTreePostorder(inorder, 0, inorder.size, postorder, 0, postorder.size)
}

fun buildTreePostorder(
    inorder: IntArray,
    inorderStart: Int,
    inorderEnd: Int,
    postorder: IntArray,
    postStart: Int,
    postEnd: Int
): TreeNode? {
    if (inorderStart == inorderEnd) return null
    val rootVal = postorder[postEnd - 1]
    val root = TreeNode(rootVal)

    var rIdx = -1
    for (i in inorderStart until inorderEnd) {
        if (inorder[i] == rootVal) {
            rIdx = i
            break
        }
    }
    val leftCount = rIdx - inorderStart

    root.left = buildTreePostorder(
        inorder,
        inorderStart,
        rIdx,
        postorder,
        postStart,
        postStart + leftCount
    )
    root.right = buildTreePostorder(
        inorder,
        rIdx + 1,
        inorderEnd,
        postorder,
        postStart + leftCount,
        postEnd - 1
    )
    return root
}

fun main() {
    val tree = buildTreePostorder(intArrayOf(9,3,15,20,7), intArrayOf(9,15,7,20,3))
    tree.print()
}

fun TreeNode?.print() {
    if (this == null) {
        return
    }

    print("${this.`val`}, ")
    this.right.print()
    this.left.print()
}