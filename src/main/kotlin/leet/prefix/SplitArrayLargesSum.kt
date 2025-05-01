package leet.prefix

import kotlin.math.max

/**
 * Given an integer array nums and an integer k,
 * split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
 *
 * Return the minimized largest sum of the split.
 */
class SplitArrayLargesSum {
    fun splitArray(nums: IntArray, k: Int): Int {

        val prefixList = mutableListOf<Int>()
        var t = 0
        nums.forEachIndexed { index, item ->
            if (index == 0) {
                prefixList.add(item)
            } else {
                prefixList.add(t + item)
            }
            t += item
        }
        var start = -1
        var p1 = 0
        var p2 = p1 + 1
        var end = nums.size - 1
        var result = Int.MIN_VALUE

//        s  p1 p2          e
//        0  1  2   3   4   5
//        6  5  4   3   2   1

        nums.forEachIndexed { _, _ ->
            print("[%7d | %7d | %7d | %7d]".format(start, p1, p2, end))
            val r1 = subArray(prefixList, p1, start, k)
            val r2 = subArray(prefixList, p2, p1, k - 1)
            val r3 = subArray(prefixList, end, p2, k - 1)
            result = max(max(r1, r2), r3)
            println("=> [%7d | %7d | %7d]".format(r1, r2, r3))

        }
        return result
    }

    //fun findSubArray(start: Int, end: Int, k: Int)
    fun subArray(prefixList: List<Int>, start: Int, end: Int, k: Int): Int {
        return prefixList.getOrElse(end) { 0 } - prefixList.getOrElse(start) { 0 }
    }
}


fun main() {
    val input = listOf(
//        Triple(intArrayOf(7, 2, 5, 10, 8), 2, 18),                // [7,2,5] [10,18]
//        Triple(intArrayOf(1, 2, 3, 4), 3, 4),                     // [1,2] [3] [4]
//        Triple(intArrayOf(1, 2, 3, 4, 5), 2, 9),                  // [1,2,3] [4,5]
        Triple(intArrayOf(1, 2, 3, 4, 5, 6), 3, 9)                // [1.2.3] [4.5] [6]
    )
    SplitArrayLargesSum().apply {
        input.forEach {
            println(splitArray(it.first, it.second))
        }
    }
}


