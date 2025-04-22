package binary_tree_general

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 *
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 */

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null)
        return true
    if (p == null || q == null)
        return false

    // recursive solution
//    return if (p.`val` == q.`val`) {
//        isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
//    } else {
//        false
//    }

    if (p.`val` != q.`val`)
        return false

    val pDeq = ArrayDeque<TreeNode>()
    pDeq.add(p)

    val qDeq = ArrayDeque<TreeNode>()
    qDeq.add(q)

    while (pDeq.isNotEmpty() || qDeq.isNotEmpty()) {
        if (pDeq.size != qDeq.size)
            return false

        for (i in 0 until pDeq.size) {
            val pNode = pDeq.removeFirst()
            val qNode = qDeq.removeFirst()

            if (pNode.`val` != qNode.`val`) {
                return false
            }

            if (pNode.left != null && qNode.left != null) {
                if (pNode.left!!.`val` != qNode.left!!.`val`) {
                    return false
                }
                pDeq.add(pNode.left!!)
                qDeq.add(qNode.left!!)
            }

            if (pNode.right != null && qNode.right != null) {
                if (pNode.right!!.`val` != qNode.right!!.`val`) {
                    return false
                }
                pDeq.add(pNode.right!!)
                qDeq.add(qNode.right!!)
            }
        }
    }

    return true
}

fun main() {
    val root = TreeNode(3)
    val left = TreeNode(9)
    val right = TreeNode(20)
    right.right = TreeNode(7)
    right.left = TreeNode(15)
    root.left = left
    root.right = right

    val root1 = TreeNode(3)
    val left1 = TreeNode(9)
    val right1 = TreeNode(20)
    right1.right = TreeNode(7)
    right1.left = TreeNode(15)
    root1.left = left1
    root1.right = right1

    println(isSameTree(root, root1))

//    p = [1,2]
//    q = [1,null,2]
    val p = TreeNode(1)
    val pLeft = TreeNode(2)
    p.left = pLeft
    val q = TreeNode(1)
    val qRight = TreeNode(2)
    q.right = qRight

    println(isSameTree(p, q))
}