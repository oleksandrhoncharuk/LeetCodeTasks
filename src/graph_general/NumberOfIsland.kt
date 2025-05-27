package graph_general

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */

fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty()) return 0

    val rows = grid.size
    val columns = grid[0].size
    val visited = HashSet<Pair<Int, Int>>()
    var islandCount = 0

    fun bfs(searchRow: Int, searchColumn: Int) {
        val deque = ArrayDeque<Pair<Int, Int>>()
        val pair = searchRow to searchColumn
        visited.add(pair)
        deque.add(pair)

        while (deque.isNotEmpty()) {
            val (row, column) = deque.removeFirst()
            val directions = arrayOf(
                intArrayOf(1, 0),
                intArrayOf(-1, 0),
                intArrayOf(0, 1),
                intArrayOf(0, -1)
            )

            for ((dr, dc) in directions) {
                val (r, c) = row + dr to column + dc
                val pr = r to c
                if (r in 0 until rows &&
                    c in 0 until columns &&
                    grid[r][c] == '1' &&
                    !visited.contains(pr)) {
                    deque.add(pr)
                    visited.add(pr)
                }
            }
        }
    }

    for (r in 0 until rows) {
        for (c in 0 until columns) {
            if (grid[r][c] == '1' && !visited.contains(r to c)) {
                bfs(r, c)
                islandCount++
            }
        }
    }

    return islandCount
}

fun main() {
    // [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]

    val grid = arrayOf(
        charArrayOf('1','1','1','1','0'),
        charArrayOf('1','1','0','1','0'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','0','0','0','0'),
    )

    println(numIslands(grid)) // 1
}
