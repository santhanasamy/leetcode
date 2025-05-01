package leet

/**
 * Triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 */
class ThreeSum {
    fun threeSum(input: IntArray): List<List<Int>> {
        input.sort()

        if (input.size < 3) {
            return emptyList()
        }

        if (input.firstOrNull { it != 0 } == null) {
            return listOf(listOf(0, 0, 0))
        }
        if (input[0] >= 0) {
            return emptyList()
        }
        val resultSet = mutableSetOf<String>()
        var fixed = 0
        var left = fixed + 1
        var right = input.size - 1
        var sum = 0

        for (j in 1 until input.size) {
            if (input[fixed] > 0) {
                break
            }
            while (left < right) {
                sum = input[fixed] + input[left] + input[right]
                if (sum > 0) {
                    right--
                } else if (sum < 0) {
                    left++
                } else {
                    intArrayOf(input[fixed], input[left], input[right])
                        .sorted()
                        .map { "$it" }
                        .reduce { acc, i ->
                            "$acc|$i"
                        }.apply {
                            resultSet.add(this)
                        }
                    left++
                    right--
                }
            }

            fixed = j
            left = fixed + 1
            right = input.size - 1
        }

        return resultSet.map {
            it.split("|").map { it.toInt() }
        }
    }
}

fun main() {
    ThreeSum().apply {
//        println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
//        println(threeSum(intArrayOf(-0, 1, 1)))
//        println(threeSum(intArrayOf(0, 0, 0)))
//        println(threeSum(intArrayOf(-2,0,1,1,2)))
        println(threeSum(intArrayOf(-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0)))
    }
}