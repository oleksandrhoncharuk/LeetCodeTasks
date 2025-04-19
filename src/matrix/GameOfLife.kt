package matrix

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.
 *
 * Given the current state of the board, update the board to reflect its next state.
 *
 * Note that you do not need to return anything.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * Example 2:
 *
 *
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 *
 *
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
 */

fun gameOfLife(board: Array<IntArray>) {
    for (row in 0 until board.size) {
        for (column in 0 until board[row].size) {
            val neighbors = board.countNeighborsFor(row, column)

            if (board[row][column] == 1 || board[row][column] == 3) {
                if (neighbors in 2..3) {
                    board[row][column] = 3
                }
            } else if (board[row][column] == 0 || board[row][column] == 2) {
                if (neighbors == 3) {
                    board[row][column] = 2
                }
            }
        }
    }

    for (i in 0 until board.size) {
        for (j in 0 until board[i].size) {
            val state = board[i][j]
            board[i][j] = state.getNewValue()
        }
    }
}

private fun Array<IntArray>.countNeighborsFor(row: Int, column: Int): Int {
    var neighbors = 0
    val rowMax = this.size
    val columnMax = this[0].size

    for (i in row - 1 until row + 2) {
        for (j in column - 1 until column + 2) {
            if ((i == row && j == column) ||
                i < 0 || j < 0 || i >= rowMax
                || j >= columnMax) {
                continue
            } else if (this[i][j] == 1 || this[i][j] == 3) {
                neighbors++
            }
        }
    }

    return neighbors
}

private fun Int.getNewValue() = when(this) {
        0, 1 -> 0
        2, 3 -> 1
        else -> 0
    }

fun main() {
    // Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
    // * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    val board1 = arrayOf(
        intArrayOf(0,1,0),
        intArrayOf(0,0,1),
        intArrayOf(1,1,1),
        intArrayOf(0,0,0),
    )

    gameOfLife(board1)

    board1.forEach { ar ->
        ar.forEach {
            print("$it ")
        }
        println()
    }
}