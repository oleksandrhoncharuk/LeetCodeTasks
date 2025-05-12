package linked_list


/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */

fun deleteDuplicates(head: ListNode?): ListNode? {
    val list = mutableListOf<Int>()
    var current = head

    while (current != null) {
        list.add(current.`val`)
        current = current.next
    }

    val duplicateList = list.retainOnlyDuplicates()

    val dummy = ListNode(0)
    dummy.next = head
    current = dummy

    while (current?.next != null) {
        val value = current.next!!.`val`

        if (duplicateList.contains(value)) {
            while (current.next != null && current.next!!.`val` == value) {
                current.next = current.next!!.next
            }
        } else {
            current = current.next
        }
    }

    return dummy.next
}

fun List<Int>.retainOnlyDuplicates(): Set<Int> {
    val freqMap = mutableMapOf<Int, Int>()

    for (num in this) {
        freqMap[num] = freqMap.getOrDefault(num, 0) + 1
    }

    return freqMap.filter { it.value > 1 }.keys.toSet()
}

fun main() {
    // [1,1,1,2,3]
    val list = listOf(1,1,2,3)
    val head = ListNode(1)

    var cur: ListNode? = head
    for (num in list) {
        cur!!.next = ListNode(num)
        cur = cur.next!!
    }

    deleteDuplicates(head)

    cur = head
    while (cur != null) {
        println(cur.`val`)
        cur = cur.next!!
    }

}
