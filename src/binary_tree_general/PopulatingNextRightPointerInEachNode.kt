package binary_tree_general

/**
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 6000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow-up:
 *
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */

fun connect(root: Node?): Node? {
    if (root == null) return null

    val queue = ArrayDeque<Node>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        queue.forEachIndexed { index, node ->
            if (index + 1 < queue.size) {
                node.next = queue[index + 1]
            }
        }

        for (i in 0 until queue.size) {
            val node = queue.removeFirst()

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
    }

    return root
}

fun main() {
    val root = Node(1)
    val left = Node(2)
    left.left = Node(4)
    left.right = Node(5)
    root.left = left
    val right = Node(3)
    right.right = Node(7)
    root.right = right

    connect(root)
    root.print()
}

private fun Node?.print() {
    if (this == null) {
        print("#")
        return
    }
    print(this.`val`)

    this.left.print()
    this.right.print()
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}
