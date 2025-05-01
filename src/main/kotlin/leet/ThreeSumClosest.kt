package leet

import kotlin.math.abs

class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var minDistance = Int.MAX_VALUE
        var left = 0
        var right = 0
        var result = 0
        nums.forEachIndexed { index, i ->

            left = index + 1
            right = nums.lastIndex

            while (left < right) {
                val sum = nums[left] + nums[right] + i
                if (sum > target) {
                    right--
                } else {
                    left++
                }
                val currentDistance = abs(sum - target)
                if (currentDistance <= minDistance) {
                    minDistance = currentDistance
                    result = sum
                }
            }
        }

        return result
    }
}

fun main() {
    ThreeSumClosest().apply {
        println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1)) // -4, -1, 1, 2 => 2
        println(threeSumClosest(intArrayOf(0, 0, 0), 0)) // => 0
        println(threeSumClosest(intArrayOf(0, 0, 0), 1))  // => 0
        println(threeSumClosest(intArrayOf(1, 1, 1, 1), 0))  // => 3
        println(threeSumClosest(intArrayOf(4, 0, 5, -5, 3, 3, 0, -4, -5), -2))  // => -2
    }
}