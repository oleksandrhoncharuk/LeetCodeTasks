package divide_and_conquer

import linked_list.ListNode

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */

fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var left = head
    var right: ListNode? = getMid(head)
    val tmp = right!!.next
    right.next = null
    right = tmp

    left = sortList(left)
    right = sortList(right)

    return merge(left, right)
}

private fun getMid(head: ListNode): ListNode {
    var slowPointer = head
    var fastPointer = head.next
    while (fastPointer?.next != null) {
        slowPointer = slowPointer.next!!
        fastPointer = fastPointer.next!!.next
    }

    return slowPointer
}

private fun merge(left: ListNode?, right: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy

    var currentLeft = left
    var currentRight = right

    while (currentRight != null && currentLeft != null) {
        if (currentLeft.`val` < currentRight.`val`) {
            tail.next = currentLeft
            currentLeft = currentLeft.next
        } else {
            tail.next = currentRight
            currentRight = currentRight.next
        }
        tail = tail.next!!
    }

    if (currentLeft != null) {
        tail.next = currentLeft
    } else if (currentRight != null) {
        tail.next = currentRight
    }

    return dummy.next
}