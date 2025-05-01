package leet

import leet.common.p

class FourSumAllCombination {
    fun fourSumAllCombination(nums: IntArray, target: Int) {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    for (l in k + 1 until nums.size) {
                        print("[$i, $j, $k, $l] ")
                        println("[${nums[i].p()},${nums[j].p()},${nums[k].p()},${nums[l].p()}]")
                    }
                }
            }
        }
    }
}

fun main() {
    FourSumAllCombination().apply {
        println(fourSumAllCombination(intArrayOf(1, 0, -1, 0, -2, 2).apply { sort() }, 0))
    }
}
