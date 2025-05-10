package linked_list

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 */

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 1) return head

    val dummy = ListNode(0)
    dummy.next = head
    var prev = dummy
    var curr: ListNode? = head

    // Count the number of nodes in the list
    var count = 0
    while (curr != null) {
        count++
        curr = curr.next
    }

    // Reverse k nodes at a time
    while (count >= k) {
        curr = prev.next!!
        reverse(prev, curr, k)

        prev = curr
        count -= k
    }

    return dummy.next
}

private fun reverse(previous: ListNode, current: ListNode, k: Int) {
    var next = current.next

    // Reverse k nodes
    for (i in 1 until k) {
        current.next = next!!.next
        next.next = previous.next
        previous.next = next
        next = current.next
    }
}
