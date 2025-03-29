package array_string

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */


fun removeDuplicates(nums: IntArray): Int {

//    my first solution
//    var i = 0
//    var duplicate = 0
//
//    while (i < nums.size - 1 - duplicate) {
//        if (nums[i] == nums[i + 1]) {
//            nums.moveEnd(i, nums[i])
//            duplicate++
//        } else {
//            i++
//        }
//    }
//
//    return nums.size - duplicate

    var writeIndex = 0
    var readIndex = 0
    var duplicateCount = 0
    val size = nums.size

    while (readIndex < size) {
        var count = 1
        while (readIndex < size - 1 && nums[readIndex] == nums[readIndex + 1]) {
            readIndex++
            count++
        }

        nums[writeIndex] = nums[readIndex]
        writeIndex++
        readIndex++

        duplicateCount += count - 1
    }

    return size - duplicateCount
}

fun IntArray.moveEnd(index: Int, value: Int) {
    if (index < 0 || index >= this.size) throw IndexOutOfBoundsException("Invalid index")

    // Shift elements to the left
    for (i in index until this.size - 1) {
        this[i] = this[i + 1]
    }

    // Insert the new value
    this[this.size - 1] = value
}

//fun main(args: Array<String>) {
////    [0,0,1,1,1,2,2,3,3,4]
//    val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
//
//    val k = removeDuplicates(nums)
//    println(k)
//    println("__________")
//    nums.forEach {
//        println(it)
//    }
//}