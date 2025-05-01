package leet.prefix

import kotlin.math.min

class MinSizeSubArraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var res = Int.MAX_VALUE
        var c = 0
        var j = 0
        for (i in nums.indices) {
            j = i + 1
            c = nums[i]
            if (c >= target) {
                res = 1
                continue
            }
            var t = 1
            while (j < nums.size) {
                c += nums[j]
                if (c < target) {
                    j++
                    t++
                } else {
                    t++
                    res = min(res, t)
                    break
                }
            }
        }
        return if (Int.MAX_VALUE != res) res else 0
    }
}

fun main() {
    //println(MinSizeSubArraySum().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))) // 2
    //println(MinSizeSubArraySum().minSubArrayLen(4, intArrayOf(1, 4, 4))) // 1
    //println(MinSizeSubArraySum().minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1))) // 0
    println(MinSizeSubArraySum().minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5))) // 3
    // 1,3,6,10,15
}

