package linked_list

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) return null

    var currentL1 = l1
    var currentL2 = l2
    var sum = currentL1!!.`val` + currentL2!!.`val`

    while (currentL1?.next != null && currentL2?.next != null) {

    }

    val l1String = buildString {
        l1?.let {
            append(it.`val`)
            var currentNode = it

            while (currentNode.next != null) {
                append(currentNode.next!!.`val`)
                currentNode = currentNode.next!!
            }
        }
    }


    val l2String = buildString {
        l2?.let {
            append(it.`val`)
            var currentNode = it

            while (currentNode.next != null) {
                append(currentNode.next!!.`val`)
                currentNode = currentNode.next!!
            }
        }
    }

    val list = (l1String.toInt() + l2String.toInt())
        .toString()
        .map { it.digitToInt() }
        .reversed()

    val node = ListNode(list[0])
    var current: ListNode? = node
    for (i in 1 until list.size) {
        current!!.next = ListNode(list[i])
        current = current.next
    }

    return node
}

fun main() {
    // l1 =
    //[2,4,3]
    //l2 =
    //[5,6,4]
    val first = ListNode(2)
    val firstNext = ListNode(4)
    firstNext.next = ListNode(3)
    first.next = firstNext

    val second = ListNode(5)
    val secondNext = ListNode(6)
    secondNext.next = ListNode(4)
    second.next = secondNext

    val result = addTwoNumbers(first, second)

    print(result?.`val`)
    var cur = result
    while (cur?.next != null) {
        print(cur.next!!.`val`)
        cur = cur.next
    }

    // [2,4,9]
    //l2 =
    //[5,6,4,9]
    //
    //Use Testcase
    //Output
    //[8,9,8,5]
    //Expected
    //[7,0,4,0,1]
}