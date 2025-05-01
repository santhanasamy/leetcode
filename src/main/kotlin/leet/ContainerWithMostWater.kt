package leet

import kotlin.math.max
import kotlin.math.min

class ContainerWithMostWater {

    fun maxArea(inputArray: IntArray): Int {

        var max = 0
        var left = 0
        var right = inputArray.size - 1

        while (left < right) {
            max = max(max, min(inputArray[left], inputArray[right]) * (right - left))

            if (inputArray[left] < inputArray[right]) {
                left++
            } else {
                right--
            }
        }
        return max
    }
}

fun main() {
    ContainerWithMostWater().apply {
        println("${maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))}")
    }
}