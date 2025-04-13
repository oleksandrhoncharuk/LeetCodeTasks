package matrix

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 *
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 *
 *
 * Follow up:
 *
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

fun setZeroes(matrix: Array<IntArray>) {
    val zeroSet = HashSet<Pair<Int, Int>>()

    for (vertical in 0 until matrix.size) {
        for (horizontal in 0 until matrix[vertical].size) {
            if (matrix[vertical][horizontal] == 0) {
                zeroSet.add(vertical to horizontal)
            }
        }
    }

    zeroSet.forEach { pair ->
        matrix.setRowAndColToZero(pair.first, pair.second)
    }
}

fun Array<IntArray>.setRowAndColToZero(vertical: Int, horizontal: Int) {
    for (rowIndex in 0 until this[vertical].size) {
        this[vertical][rowIndex] = 0
    }

    for (colIndex in 0 until this.size) {
        this[colIndex][horizontal] = 0
    }
}

fun main() {
    // Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    // Output: [[1,0,1],[0,0,0],[1,0,1]]
    val matrix1 = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1),
    )

    setZeroes(matrix1)

    for (i in 0 until matrix1.size) {
        for (j in 0 until matrix1[i].size) {
            print(" ${matrix1[i][j]}")
        }
    }
}