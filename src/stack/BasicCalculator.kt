package stack

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 */

fun calculate(s: String): Int {
    var result = 0
    var number: Int
    var sign = 1
    val stack = ArrayDeque<Int>()

    var i = 0
    while (i < s.length) {
        when (s[i]) {
            in '0'..'9' -> {
                number = 0
                while (i < s.length && s[i].isDigit()) {
                    number = number * 10 + (s[i] - '0')
                    i++
                }
                result += number * sign
                i-- // backtrack because outer loop will increment
            }

            '+' -> sign = 1
            '-' -> sign = -1

            '(' -> {
                // Save current state
                stack.addLast(result)
                stack.addLast(sign)
                result = 0
                sign = 1
            }

            ')' -> {
                val prevSign = stack.removeLast()
                val prevResult = stack.removeLast()
                result = prevResult + prevSign * result
            }
        }
        i++
    }

    return result
}

fun main() {
    println(calculate("(1+(4+5+2)-3)+(6+8)")) // 23
}