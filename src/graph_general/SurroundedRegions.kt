package graph_general

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 *
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 *
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 *
 * Explanation:
 *
 *
 * In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
 *
 * Example 2:
 *
 * Input: board = [["X"]]
 *
 * Output: [["X"]]
 *
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 */

fun solve(board: Array<CharArray>) {
    if (board.isNotEmpty()) {
        val rows = board.size
        val columns = board[0].size
        val visited = HashSet<Pair<Int, Int>>()
        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        fun bfs(searchRow: Int, searchColumn: Int) {
            val deque = ArrayDeque<Pair<Int, Int>>()
            val pair = searchRow to searchColumn
            visited.add(pair)
            deque.add(pair)

            while (deque.isNotEmpty()) {
                val (row, column) = deque.removeFirst()

                for ((dr, dc) in directions) {
                    val (r, c) = row + dr to column + dc
                    val pr = r to c
                    if (r in 1 until rows - 1 &&
                        c in 1 until columns - 1 &&
                        board[r][c] == 'O' &&
                        !visited.contains(pr)
                    ) {
                        deque.add(pr)
                        visited.add(pr)
                    }
                }
            }
        }

        for (r in listOf(0, rows - 1)) {
            for (c in 0 until columns) {
                if (board[r][c] == 'O' && (r to c) !in visited) {
                    bfs(r, c)
                }
            }
        }

        for (c in listOf(0, columns - 1)) {
            for (r in 0 until rows) {
                if (board[r][c] == 'O' && (r to c) !in visited) {
                    bfs(r, c)
                }
            }
        }

        for (r in 0 until rows) {
            for (c in 0 until columns) {
                if (board[r][c] == 'O' && (r to c) !in visited) {
                    board[r][c] = 'X'
                }
            }
        }
    }
}

fun solveOpt(board: Array<CharArray>) {
    if (board.isEmpty() || board[0].isEmpty()) return

    val rows = board.size
    val cols = board[0].size
    val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    fun bfs(startRow: Int, startCol: Int) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(startRow to startCol)
        board[startRow][startCol] = 'S'

        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()
            for ((dr, dc) in directions) {
                val newR = r + dr
                val newC = c + dc
                if (newR in 0 until rows &&
                    newC in 0 until cols &&
                    board[newR][newC] == 'O'
                ) {
                    queue.add(newR to newC)
                    board[newR][newC] = 'S'
                }
            }
        }
    }

    for (c in 0 until cols) {
        if (board[0][c] == 'O') bfs(0, c)
        if (board[rows - 1][c] == 'O') bfs(rows - 1, c)
    }
    for (r in 0 until rows) {
        if (board[r][0] == 'O') bfs(r, 0)
        if (board[r][cols - 1] == 'O') bfs(r, cols - 1)
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            when (board[r][c]) {
                'O' -> board[r][c] = 'X'
                'S' -> board[r][c] = 'O'
            }
        }
    }
}