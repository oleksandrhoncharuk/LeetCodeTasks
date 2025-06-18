package array_string

/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val result = mutableListOf<String>()
    var index = 0

    while (index < words.size) {
        var totalChars = words[index].length
        var last = index + 1

        // Find how many words can fit on the current line
        while (last < words.size) {
            if (totalChars + 1 + words[last].length > maxWidth) break
            totalChars += 1 + words[last].length
            last++
        }

        val line = StringBuilder()
        val numberOfWords = last - index
        val numberOfGaps = numberOfWords - 1

        // Check if it's the last line or only one word
        if (last == words.size || numberOfWords == 1) {
            // Left-justified
            for (i in index until last) {
                line.append(words[i])
                if (i != last - 1) line.append(' ')
            }
            // Fill the rest with spaces
            val remaining = maxWidth - line.length
            repeat(remaining) { line.append(' ') }
        } else {
            // Fully justified
            val totalSpaces = maxWidth - totalChars + numberOfGaps
            val spacePerGap = totalSpaces / numberOfGaps
            val extraSpaces = totalSpaces % numberOfGaps

            for (i in index until last) {
                line.append(words[i])
                if (i != last - 1) {
                    repeat(spacePerGap + if (i - index < extraSpaces) 1 else 0) {
                        line.append(' ')
                    }
                }
            }
        }

        result.add(line.toString())
        index = last
    }

    return result
}

fun main() {
    println(
        fullJustify(
            arrayOf("This", "is", "an", "example", "of", "text", "justification."),
            16
        )
    )
}