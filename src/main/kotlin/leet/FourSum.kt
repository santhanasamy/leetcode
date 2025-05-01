package leet

object FourSum {
    fun fourSum(input: IntArray, target: Int): List<List<Int>> {
        input.sort()

        val resultList = mutableListOf<List<Int>>()
        input.forEachIndexed { index, i ->
            fourSumInternal(input, target, resultList, index, 0, mutableListOf())
        }
        return resultList
    }

    private fun fourSumInternal(
        input: IntArray,
        target: Int,
        resultList: MutableList<List<Int>>,
        idx: Int,
        resultSum: Int,
        tResult: MutableList<Int>
    ) {

        if (resultSum == target && tResult.isNotEmpty()) {
            resultList.add(tResult)
            return
        }
        if (tResult.size == 4) {
            return
        }
        tResult.add(input[idx])
        fourSumInternal(
            input,
            target,
            resultList,
            idx + 1,
            resultSum + input[idx],
            tResult
        )
    }
}

fun main() {
    println(FourSum.fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
    println(FourSum.fourSum(intArrayOf(2, 2, 2, 2, 2), 8))
}