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
    val list = ArrayList<Int>()
    var first = l1
    var second = l2
    var carry = 0

    while (first != null || second != null) {
        val sum = carry + (first?.`val` ?: 0) + (second?.`val` ?: 0)
        carry = sum / 10
        list.add(sum % 10)

        if (first != null) {
            first = first.next
        }
        if (second != null) {
            second = second.next
        }
    }

    if (carry != 0) {
        list.add(carry)
    }

    val result = ListNode(list[0])
    var mResult: ListNode? = result

    for (i in 1 until list.size) {
        mResult!!.next = ListNode(list[i])
        mResult = mResult.next
    }

    return result
}

fun main() {
    // l1 =
    //[2,4,3]
    //l2 =
//    //[5,6,4]
//    val first = ListNode(2)
//    val firstNext = ListNode(4)
//    firstNext.next = ListNode(3)
//    first.next = firstNext
//
//    val second = ListNode(5)
//    val secondNext = ListNode(6)
//    secondNext.next = ListNode(4)
//    second.next = secondNext
//
//    val result = addTwoNumbers(first, second)
//
//    print(result?.`val`)
//    var cur = result
//    while (cur?.next != null) {
//        print(cur.next!!.`val`)
//        cur = cur.next
//    }

    // [2,4,9]
    //l2 =
    //[5,6,4,9]
    //
    //Use Testcase
    //Output
    //[8,9,8,5]
    //Expected
    //[7,0,4,0,1]

    //[9,9,9,9,9,9,9]
    //l2 =
    //[9,9,9,9]
    val first1 = ListNode(9)
    val firstNext1 = ListNode(9)
    val firstNext2 = ListNode(9)
    val firstNext3 = ListNode(9)
    val firstNext4 = ListNode(9)
    firstNext3.next = firstNext4
    firstNext2.next = firstNext3
    firstNext1.next = firstNext2
    first1.next = firstNext1

    val second1 = ListNode(9)
    val secondNext1 = ListNode(9)
    secondNext1.next = ListNode(9)
    second1.next = secondNext1

    val result1 = addTwoNumbers(first1, second1)

    print(result1?.`val`)
    var cur1 = result1
    while (cur1?.next != null) {
        print(cur1.next!!.`val`)
        cur1 = cur1.next
    }
}