package leet.prefix

import leet.common.build2DArray

class NumMatrix(matrix: Array<IntArray>) {
    val prefixMatrix: List<List<Int>> = buildPrefixArray(matrix)
    private fun buildPrefixArray(matrix: Array<IntArray>): MutableList<MutableList<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        matrix.forEach {
            var temp = 0
            val tempList = mutableListOf<Int>()
            it.forEachIndexed { index, item ->
                if (index == 0) {
                    temp = item
                    tempList.add(temp)
                } else {
                    temp += item
                    tempList.add(temp)
                }
            }
            res.add(tempList)
        }
        return res
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var sum = 0
        for (r in row1..row2) {
            // s[i : j] = s[j] - s[i-1]
            sum += prefixMatrix[r][col2] - prefixMatrix[r].getOrElse(col1 - 1) { 0 }
        }
        return sum
    }

}

fun main() {
    var matrix = build2DArray("[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]")
    var obj = NumMatrix(matrix)
    println(obj.sumRegion(2, 1, 4, 3))
    println(obj.sumRegion(1, 1, 2, 2))
    println(obj.sumRegion(1, 2, 2, 4))
}
