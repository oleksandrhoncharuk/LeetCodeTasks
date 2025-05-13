package linked_list

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null || k == 0) return head

    var current = head
    var tailNode: ListNode? = null
    var length = 0

    while (current != null) {
        if (current.next == null) {
            tailNode = current
        }
        current = current.next
        length++
    }

    // Real number of rotation. For example list with length 5, and k = 7
    // no need to rotate 7 times, because after 5 rotation we will get back to the start
    // that's mean we need only 2 rotation to get the correct answer
    // So, 5 % 7 = 2 - exact number of rotation that we need
    val realK = k % length

    if (realK == 0) return head

    tailNode?.next = head

    current = head
    val stepsToNewTail = length - realK
    repeat(stepsToNewTail - 1) {
        current = current!!.next
    }

    val newHead = current!!.next
    current!!.next = null

    return newHead
}
