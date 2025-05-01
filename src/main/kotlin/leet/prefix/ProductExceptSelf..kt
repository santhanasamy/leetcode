package leet.prefix

class ProductExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        val prefix = IntArray(nums.size) { 1 }
        val suffix = IntArray(nums.size) { 1 }

        nums.forEachIndexed { index, _ ->
            if (index == 0) {
                prefix[index] = 1
            } else {
                prefix[index] = prefix[index - 1] * nums[index - 1]
            }
        }

        for (i in suffix.lastIndex downTo 0) {
            if (i == suffix.lastIndex) {
                suffix[i] = 1
            } else {
                suffix[i] = suffix[i + 1] * nums[i + 1]
            }
        }

        result.forEachIndexed { index, _ ->
            result[index] = prefix[index] * suffix[index]
        }
        return result
    }
}

fun main() {
    ProductExceptSelf().apply {
        println(productExceptSelf(intArrayOf(1, 2, 3, 4)).contentToString())
    }
}
