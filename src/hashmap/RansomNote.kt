package hashmap

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val ransomMap = HashMap<Char, Int>()

    ransomNote.forEach { char ->
        if (ransomMap.contains(char)) {
            ransomMap[char] = ransomMap[char]!! + 1
        } else {
            ransomMap[char] = 1
        }
    }

    magazine.forEach { char ->
        if (ransomMap.contains(char)) {
            ransomMap[char] = ransomMap[char]!! - 1
            if (ransomMap[char] == 0) ransomMap.remove(char)
        }
    }

    return ransomMap.isEmpty()
}

fun main() {
    // ransomNote = "a", magazine = "b"
    val ransom = "a"
    val magazine = "b"

    println(canConstruct(ransom, magazine))
    println(canConstruct("aa", "ab"))
    println(canConstruct("aa", "aab"))
    println(canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"))
}