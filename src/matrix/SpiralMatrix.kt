package matrix

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    var left = 0
    var top = 0
    var right = matrix[0].size
    var bottom = matrix.size

    val resultList = ArrayList<Int>()

    while (left != right || top != bottom) {
        for (i in left until right) {
            resultList.add(matrix[top][i])
        }
        top++
        if (top == bottom) break

        for (i in top until bottom) {
            resultList.add(matrix[i][right - 1])
        }
        right--
        if (right == left) break

        for (i in right - 1 downTo left) {
            resultList.add(matrix[bottom - 1][i])
        }
        bottom--
        if (bottom == top) break

        for (i in bottom - 1 downTo top) {
            resultList.add(matrix[i][left])
        }
        left++
        if (left == right) break
    }

    return resultList
}

fun main() {
// matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    val matrix1 = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12)
    )

    spiralOrder(matrix1).forEach { print("$it ") }

    println()
//    matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    * Output: [1,2,3,6,9,8,7,4,5]
    val matrix2 = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9)
    )

    spiralOrder(matrix2).forEach { print("$it ") }

    println()
//    [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16],[17,18,19,20],[21,22,23,24]]
//    Output = [1,2,3,4,8,12,16,20,24,23,22,21,17,13,9,5,6,7,11,15,19,18,14,10]
    val matrix3 = arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(5,6,7,8),
        intArrayOf(9,10,11,12),
        intArrayOf(13,14,15,16),
        intArrayOf(17,18,19,20),
        intArrayOf(21,22,23,24)
    )

    spiralOrder(matrix3).forEach { print("$it ") }
}