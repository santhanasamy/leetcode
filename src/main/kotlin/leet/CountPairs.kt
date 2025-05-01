package leet

class CountPairs {
    fun countPairs(nums: IntArray, k: Int): Int {
        var res = 0
        for (i in 0 until nums.size - 1) {
            res += countPair(nums, k, 0, i, i + 1)
        }
        return res
    }

    private fun countPair(nums: IntArray, k: Int, result: Int, i: Int, j: Int): Int {
        if (j == nums.size) {
            return result
        }
        val res = if (nums[i] == nums[j] && (i * j) % k == 0) {
            result + 1
        } else {
            result
        }
        return countPair(nums, k, res, i, j + 1)
    }
}

fun main() {
    CountPairs().apply {
        println(countPairs(intArrayOf(3, 1, 2, 2, 2, 1, 3), 2))
    }
}
