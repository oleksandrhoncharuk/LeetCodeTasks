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
    val magazineMap = HashMap<Char, Int>()
    var counter = 0

    magazine.forEach { char ->
        if (magazineMap.contains(char)) {
            magazineMap[char] = magazineMap[char]!! + 1
        } else {
            magazineMap[char] = 1
        }
    }

    ransomNote.forEach { char ->
        if (ransomMap.contains(char)) {
            ransomMap[char] = ransomMap[char]!! + 1
        } else {
            ransomMap[char] = 1
        }
    }

    magazineMap.forEach { (key, value) ->
        if (ransomMap.contains(key) && ransomMap.getValue(key) <= value) {
            counter++
        }
    }

    return counter == ransomMap.size
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