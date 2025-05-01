package leet.prefix

class NumArray(nums: IntArray) {
    var pre = 0
    private val preFixSum = nums.mapIndexed { index, item ->
        val sum = item + pre
        pre = sum
        sum
    }

    fun sumRange(left: Int, right: Int): Int {
        // s[i:j] = s[j] - s[i-1]
        return preFixSum[right] - preFixSum.getOrElse(left - 1) { 0 }
    }
}

fun main() {            //-2,-2, 1
    val nums = intArrayOf(-2, 0, 3, -5, 2, -1)
    val obj = NumArray(nums)

    var pair = Pair(0, 2)
    println("[$pair] => " + obj.sumRange(pair.first, pair.second))

    pair = Pair(2, 5)
    println("[$pair] => " + obj.sumRange(pair.first, pair.second))

    pair = Pair(0, 5)
    println("[$pair] => " + obj.sumRange(pair.first, pair.second))
}