package array_string

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 *
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */



fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    if (nums1.isEmpty() || m == 0) {
        for (i in 0..<n) {
            nums1[i] = nums2[i]
        }
    } else if (nums2.isEmpty() || n == 0) {
        return
    } else {
        var i = 0
        var j = 0

        while(i < nums1.size && j < nums2.size) {
            when {
                nums1[i] == 0 && i >= m + j -> {
                    nums1[i] = nums2[j]
                    i++
                    j++
                }

                nums1[i] < nums2[j] -> i++

                nums1[i] >= nums2[j] -> {
                    nums1.insertAt(i, nums2[j])
                    i++
                    j++
                }

                else -> continue
            }
        }
    }
    nums1.forEach {
        println(it)
    }
}

fun IntArray.insertAt(index: Int, value: Int) {
    if (index < 0 || index >= this.size) throw IndexOutOfBoundsException("Invalid index")

    // Shift elements to the right
    for (i in this.size - 1 downTo index + 1) {
        this[i] = this[i - 1]
    }

    // Insert the new value
    this[index] = value
}


fun main(args: Array<String>) {
//     nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//    val nums1 = intArrayOf(1,2,3,0,0,0)
//    val m = 3
//    val nums2 = intArrayOf(2,5,6)
//    val n = 3

//    nums1 = [1], m = 1, nums2 = [], n = 0
//    val nums1 = intArrayOf(1)
//    val m = 1
//    val nums2 = intArrayOf()
//    val n = 0


//    Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//    val nums1 = intArrayOf()
//    val m = 0
//    val nums2 = intArrayOf(1)
//    val n = 1

//    val nums1 = intArrayOf(2,0)
//    val m = 1
//    val nums2 = intArrayOf(1)
//    val n = 1

    val nums1 = intArrayOf(-1, 0, 0, 3, 3, 3, 0, 0)
    val m = 6
    val nums2 = intArrayOf(1, 2, 3)
    val n = 3

//    val nums1 = intArrayOf(-1,0,0,0,3,0,0,0,0,0,0)
//    val m = 5
//    val nums2 = intArrayOf(-1,-1,0,0,1,2)
//    val n = 6

    merge(nums1, m, nums2, n)
}
