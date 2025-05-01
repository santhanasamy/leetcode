package leet

class TwoSum {
    fun twoSum1(nums: IntArray, target: Int): IntArray {

        val numMap = mutableMapOf<Int, Int>()
        var idx = 0
        nums.associateTo(numMap) {
            it to idx++
        }
        print(numMap.toString())

        nums.forEachIndexed { index, value ->
            val targetIdx = numMap.getOrDefault(target - value, -1)
            if (targetIdx != -1 && targetIdx != index) {
                return intArrayOf(index, targetIdx)
            }
        }

        return intArrayOf(2)
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {

        val numMap = mutableMapOf<Int, Int>()
        var idx = 0
        nums.associateTo(numMap) {
            it to idx++
        }
        print(numMap.toString())

        nums.forEachIndexed { index, value ->
            val targetIdx = numMap.getOrDefault(target - value, -1)
            if (targetIdx != -1 && targetIdx != index) {
                return intArrayOf(index, targetIdx)
            }
        }

        return intArrayOf(2)
    }
}

fun main() {

    TwoSum().apply {
        // println("Result:  ${twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString()}")
        println("Result:  ${twoSum(intArrayOf(3, 2, 4), 6).contentToString()}")
        // println("Result:  ${twoSum(intArrayOf(3, 3), 6).contentToString()}")
    }
}