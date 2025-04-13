package matrix

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 *
 */

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val subBox = 3
    var left = 0
    var top = 0
    var right = board[0].size
    var bottom = board.size

    val boxMap = HashMap<Pair<Int, Int>, String>()

    while (left != right && bottom != top) {
        val xNumbers = BooleanArray(10) { false }
        val yNumbers = BooleanArray(10) { false }
        // columns
        for (i in top until board.size) {
            board[i][left]
                .convertToInt()?.let {
                    val key = i / subBox to left / subBox
                    if (boxMap.contains(key)) {
                        boxMap[key] = boxMap[key] + it
                    } else {
                        boxMap[key] = it.toString()
                    }
                    if (yNumbers[it]) {
                        return false
                    }
                    yNumbers[it] = true
                }
        }
        left++

        // rows
        for (j in right - 1 downTo 0) {
            board[bottom - 1][j]
                .convertToInt()?.let {
                    if (xNumbers[it]) {
                        return false
                    }
                    xNumbers[it] = true
                }
        }
        bottom--
    }

    for (value in boxMap.values) {
        if (value.toSet().size != value.length) {
            return false
        }
    }

    return true
}

fun Char.convertToInt(): Int? {
    if (this.isDigit()) {
        return this.digitToInt()
    }

    return null
}

fun main() {
    //    [["5","3",".",".","7",".",".",".","."],
    //    ["6",".",".","1","9","5",".",".","."],
    //    [".","9","8",".",".",".",".","6","."],
    //    ["8",".",".",".","6",".",".",".","3"],
    //    ["4",".",".","8",".","3",".",".","1"],
    //    ["7",".",".",".","2",".",".",".","6"],
    //    [".","6",".",".",".",".","2","8","."],
    //    [".",".",".","4","1","9",".",".","5"],
    //    [".",".",".",".","8",".",".","7","9"]]
    val board = arrayOf(
        charArrayOf('5','3','.','.','7','.','.','.','.'),
        charArrayOf('6','.','.','1','9','5','.','.','.'),
        charArrayOf('.','9','8','.','.','.','.','6','.'),
        charArrayOf('8','.','.','.','6','.','.','.','3'),
        charArrayOf('4','.','.','8','.','3','.','.','1'),
        charArrayOf('7','.','.','.','2','.','.','.','6'),
        charArrayOf('.','6','.','.','.','.','2','8','.'),
        charArrayOf('.','.','.','4','1','9','.','.','5'),
        charArrayOf('.','.','.','.','8','.','.','7','9')
    )
    println(isValidSudoku(board))
}