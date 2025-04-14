package matrix

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */

fun rotate(matrix: Array<IntArray>) {
    var top = 0
    var left = 0
    var right = matrix[0].size
    var bottom = matrix.size
    var savedItem = matrix[0][0]
    var count = 0

    while (top != bottom - 1 || left != right - 1) {
        for (i in left until right) {
            val temp = matrix[top][i]
            matrix[top][i] = savedItem
            savedItem = temp
        }

        for (i in 1 + left until bottom) {
            val temp = matrix[i][right - 1]
            matrix[i][right - 1] = savedItem
            savedItem = temp
        }

        for (i in right - 2 downTo left) {
            val temp = matrix[bottom - 1][i]
            matrix[bottom - 1][i] = savedItem
            savedItem = temp
        }

        for (i in bottom - 2 downTo top) {
            val temp = matrix[i][left]
            matrix[i][left] = savedItem
            savedItem = temp
        }

        count++
        if (count >= bottom - 1 - top) {
            top++
            left++
            right--
            bottom--
            if (top == bottom || left == right) break
            savedItem = matrix[top][left]
            count = 0
        }
    }
}

fun main() {
    // Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    // Output: [[7,4,1],[8,5,2],[9,6,3]]
    val matrix1 = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9)
    )

    rotate(matrix1)

    for (i in 0 until matrix1.size) {
        for (j in 0 until matrix1[i].size) {
            print("${matrix1[i][j]} ")
        }
        println()
    }

    // Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    // Output:
    // [[15,13,2,5],
    // [14,3,4,1],
    // [12,6,8,9],
    // [16,7,10,11]]
    println()

    val matrix2 = arrayOf(
        intArrayOf(5, 1, 9, 11),
        intArrayOf(2,4,8,10),
        intArrayOf(13,3,6,7),
        intArrayOf(15,14,12,16)
    )

    rotate(matrix2)

    for (i in 0 until matrix2.size) {
        for (j in 0 until matrix2[i].size) {
            print("${matrix2[i][j]} ")
        }
        println()
    }
}