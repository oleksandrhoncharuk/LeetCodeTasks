package array_string

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */

fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty() || prices.size == 1) return 0

    var min = Int.MAX_VALUE
    var minIndex = 0
    var maxIndex = 0
    var max = 0

    var result = 0

//    for (i in 0 until prices.size) {
//        for (j in i until prices.size) {
//            val profit = prices[j] - prices[i]
//            if (profit > result) {
//                result = profit
//            }
//        }
//    }

    for (i in 0 until prices.size - 1) {
        val priceMin = prices[i]
        val priceMax = prices[i]

        if (priceMin < min && priceMin != 0) {
            min = priceMin
            minIndex = i
        }

        if (priceMax > max && i > minIndex) {
            max = priceMax
            maxIndex = i
        }
    }

//    var result = max - min
//    if (result < 0) result = 0

    return max - min
}

fun main(args: Array<String>) {
//    val prices = intArrayOf(1,6,4,3,1)
//    val prices = intArrayOf(2,4,1)
//    val prices = intArrayOf(2,1,2,1,0,0,1)
    val prices = intArrayOf(7,6,4,3,1)
//    val prices = intArrayOf(3,2,6,5,0,3)
//    val prices = intArrayOf(1)
//    val prices = intArrayOf(1,2)

    println(maxProfit(prices))
}