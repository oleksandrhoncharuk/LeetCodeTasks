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

    var min = prices[0]
    var result = 0

// dumb solution
//    for (i in 0 until prices.size) {
//        for (j in i until prices.size) {
//            val profit = prices[j] - prices[i]
//            if (profit > result) {
//                result = profit
//            }
//        }
//    }

    for (i in 1 until prices.size) {
        val priceMin = prices[i]
        val priceMax = prices[i]

        if (priceMin < min) {
            min = priceMin
        }

        val profit = priceMax - min
        if (profit > result) result = profit
    }

    return result
}

fun main(args: Array<String>) {
    val prices1 = intArrayOf(1,6,4,3,1) //5
    val prices2 = intArrayOf(2,4,1) //2
    val prices3 = intArrayOf(2,1,2,1,0,0,1) //1
    val prices4 = intArrayOf(2,1,2,1,0,1,2) //2
    val prices5 = intArrayOf(7,6,4,3,1) // 0
    val prices6 = intArrayOf(3,2,6,5,0,3) // 4
    val prices7 = intArrayOf(1) // 0
    val prices8 = intArrayOf(1,2) // 1

    println(maxProfit(prices1))
    println(maxProfit(prices2))
    println(maxProfit(prices3))
    println(maxProfit(prices4))
    println(maxProfit(prices5))
    println(maxProfit(prices6))
    println(maxProfit(prices7))
    println(maxProfit(prices8))
}