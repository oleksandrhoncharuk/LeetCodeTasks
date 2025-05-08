package linked_list

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var first = list1
    var second = list2
    val list = ArrayList<Int>()

    while(first != null || second != null) {
        if (first == null) {
            list.add(second!!.`val`)
            second = second.next
        } else if (second == null) {
            list.add(first.`val`)
            first = first.next
        } else if (first.`val` > second.`val`) {
            list.add(second.`val`)
            second = second.next
        } else if (second.`val` > first.`val`) {
            list.add(first.`val`)
            first = first.next
        } else if (first.`val` == second.`val`) {
            list.add(first.`val`)
            list.add(second.`val`)
            first = first.next
            second = second.next
        } else {
            break
        }
    }

    if (list.isEmpty()) return null

    val result = ListNode(list[0])
    var temp: ListNode? = result

    for (i in 1 until list.size) {
        temp!!.next = ListNode(list[i])
        temp = temp.next
    }

    return result
}

fun main() {
    // list1 =
    //[1,2,4]
    //list2 =
    //[1,3,4]

    val first = ListNode(1)
    val firstNext = ListNode(2)
    firstNext.next = ListNode(4)
    first.next = firstNext

    val second = ListNode(1)
    val secondNext = ListNode(3)
    secondNext.next = ListNode(4)
    second.next = secondNext

    val result = mergeTwoLists(first, second)

    print(result?.`val`)
    var cur1 = result
    while (cur1?.next != null) {
        print(cur1.next!!.`val`)
        cur1 = cur1.next
    }
}
