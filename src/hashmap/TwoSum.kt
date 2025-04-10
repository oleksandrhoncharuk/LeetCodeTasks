package hashmap

fun twoSum(nums: IntArray, target: Int): IntArray {
    // not efficient solution
//    val hashMap = buildMap {
//        for ((index, number) in nums.withIndex()) {
//            put(index, target - number)
//        }
//    }
//
//    for (i in 0 until nums.size) {
//        for (j in 0 until hashMap.size) {
//            if (j == i) continue
//            if (hashMap[j] == nums[i]) {
//                return intArrayOf(i, j)
//            }
//        }
//    }

    val map = mutableMapOf<Int, Int>()
    var leftPart = 0
    var rightPart = nums.size - 1

    while (leftPart <= rightPart) {
        val leftDiff = target - nums[leftPart]
        if (map.contains(leftDiff)) {
            return intArrayOf(leftPart, map[leftDiff]!!)
        } else {
            map[nums[leftPart]] = leftPart
            leftPart++
        }

        val rightDiff = target - nums[rightPart]
        if (map.contains(rightDiff)) {
            return intArrayOf(rightPart, map[rightDiff]!!)
        } else {
            map[nums[rightPart]] = rightPart
            rightPart--
        }
    }

    return intArrayOf()
}

fun main() {
//    twoSum(intArrayOf(3,2,4), 6).forEach {
//        println(it)
//    }

    twoSum(intArrayOf(3,3), 6).forEach {
        println(it)
    }
}