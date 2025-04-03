package array_string

/**
 *
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 *
 *
 * Example 1:
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 *
 * Constraints:
 *
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 *
 */

fun candy(ratings: IntArray): Int {
    val candies = IntArray(ratings.size) { 1 }

    for (i in 1 until ratings.size) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1
        }
    }

    for (i in ratings.size - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
            candies[i] = candies[i + 1] + 1
        }
    }

    return candies.sum()
}

fun main() {
    val ratings = intArrayOf(1,0,2) //5
    val ratings2 = intArrayOf(1,2,2) //4
    val ratings3 = intArrayOf(1,2,87,87,87,2,1) //13
    val ratings4 = intArrayOf(1,3,2,2,1)
    val ratings5 = intArrayOf(5,4,3,5,6,2) //12

    println(candy(ratings))
    println(candy(ratings2))
    println(candy(ratings3))
    println(candy(ratings4))
    println(candy(ratings5))

}