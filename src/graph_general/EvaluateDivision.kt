package graph_general

/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */

fun calcEquation(
    equations: List<List<String>>,
    values: DoubleArray,
    queries: List<List<String>>
): DoubleArray {
    // Graph to store adjacency list where each node maps to its neighbors and their weights
    val graph = mutableMapOf<String, MutableMap<String, Double>>()

    // Step 1: Build the graph from input equations and values
    for (i in equations.indices) {
        val (dividend, divisor) = equations[i]
        val value = values[i]

        graph.putIfAbsent(dividend, mutableMapOf())
        graph.putIfAbsent(divisor, mutableMapOf())

        // a / b = value => edge from a to b with weight value
        graph[dividend]!![divisor] = value

        // b / a = 1 / value => reverse edge
        graph[divisor]!![dividend] = 1.0 / value
    }

    // Step 2: Evaluate each query using DFS
    fun dfs(
        current: String,
        target: String,
        visited: MutableSet<String>,
        accumulatedProduct: Double
    ): Double {
        // Base case: if current node is not in the graph
        if (!graph.containsKey(current)) return -1.0
        // If current equals target, we've found the path
        if (current == target) return accumulatedProduct

        visited.add(current)

        // Traverse neighbors
        for ((neighbor, value) in graph[current]!!) {
            if (neighbor !in visited) {
                val result = dfs(neighbor, target, visited, accumulatedProduct * value)
                if (result != -1.0) return result
            }
        }

        return -1.0 // No valid path found
    }

    // Step 3: Process each query and collect results
    return queries.map { (start, end) ->
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            -1.0
        } else {
            dfs(start, end, mutableSetOf(), 1.0)
        }
    }.toDoubleArray()
}