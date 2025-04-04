package array_string

/**
 * Seven different symbols represent Roman numerals with the following values:
 *
 * Symbol	Value
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 * Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:
 *
 * If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
 * If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
 * Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
 * Given an integer, convert it to a Roman numeral.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 3749
 *
 * Output: "MMMDCCXLIX"
 *
 * Explanation:
 *
 * 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 *  700 = DCC as 500 (D) + 100 (C) + 100 (C)
 *   40 = XL as 10 (X) less of 50 (L)
 *    9 = IX as 1 (I) less of 10 (X)
 * Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
 * Example 2:
 *
 * Input: num = 58
 *
 * Output: "LVIII"
 *
 * Explanation:
 *
 * 50 = L
 *  8 = VIII
 * Example 3:
 *
 * Input: num = 1994
 *
 * Output: "MCMXCIV"
 *
 * Explanation:
 *
 * 1000 = M
 *  900 = CM
 *   90 = XC
 *    4 = IV
 *
 *
 * Constraints:
 *
 * 1 <= num <= 3999
 */

fun intToRoman(num: Int): String {
    var mNumber = num
    var result = ""

    var index = 0

    while (index < romanMap.entries.size) {
        val entry = romanMap.entries.elementAt(index)

        if (mNumber / entry.key == 0) {
            index++
        } else {
            val counterForSign = mNumber / entry.key
            for (i in 0 until counterForSign) {
                result = result.plus(entry.value)
            }
            mNumber %= entry.key
            index++
        }
    }

    return result
}

private val romanMap = mapOf(
    1000 to "M",
    900 to "CM",
    500 to "D",
    400 to "CD",
    100 to "C",
    90 to "XC",
    50 to "L",
    40 to "XL",
    10 to "X",
    9 to "IX",
    5 to "V",
    4 to "IV",
    1 to "I"
)

fun romanToInt(s: String): Int {
    val entries = romanMap.entries
    val stringArray = s.split("")

    var result = 0

    for (i in stringArray.indices) {
        for (j in 0 until romanMap.entries.size) {
            val romanMapElement = entries.elementAt(j)

            if (romanMapElement.value == stringArray[i]) {
                if (stringArray[i + 1].biggerThan(romanMapElement.value)) {
                    result -= romanMapElement.key
                } else {
                    result += romanMapElement.key
                }
                break
            }
        }
    }

    return result
}

private fun String.biggerThan(s: String): Boolean {
    if (!romanMap.containsValue(s) or !romanMap.containsValue(this)) return false
    val thisKey = romanMap.entries.find { it.value == this }?.key
    val sKey = romanMap.entries.find { it.value == s }?.key

    return thisKey?.let { key1 ->
        sKey?.let { key2 ->
            key1 > key2
        }
    } ?: false
}

fun main() {
    println(intToRoman(3749)) //MMMDCCXLIX
    println(intToRoman(58)) //LVIII
    println(intToRoman(1994)) //MCMXCIV
    println(intToRoman(3549)) //MMMDXLIX

//    println(romanToInt("MMMDCCXLIX"))
//    println(romanToInt("LVIII"))
//    println(romanToInt("MCMXCIV"))
//    println(romanToInt("MMMDXLIX"))
}