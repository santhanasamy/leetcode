package leet

import leet.common.build2DArray
import kotlin.math.max

/**
 * Given an m x n matrix and an integer k, return the
 * Max sum of a rectangle in the matrix such that its sum is no larger than k.
 *
 * It is guaranteed that there will be a rectangle with a sum no larger than k.
 */
class MaxSumOfRectangleNoLargerThanK {

    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        val prefixArray = mutableListOf<IntArray>()
        var prefix = 0
        matrix.forEach {
            it.mapIndexed { index, item ->
                if (index == 0) {
                    prefix = item
                } else {
                    prefix += item
                }
                prefix
            }.apply {
                prefixArray.add(this.toIntArray())
            }
        }

        val rowSize = matrix.size
        val colSize = matrix[0].size
        var max = 0
        var tempSum = 0
        for (offset in 0 until colSize) {
            for (col in offset until colSize) {
                tempSum = 0
                for (row in 0 until rowSize) {
                    val t = prefixArray[row][col] - prefixArray[row].getOrElse(offset - 1) { 0 }
                    if (tempSum + t <= k) {
                        tempSum += t
                    } else {
                        break
                    }
                    max = max(max, tempSum)
                }
                if (max == k) {
                    break
                }
            }
        }
        return max
    }

    //    matrix.forEachIndexed { row, array ->
//        array.forEachIndexed { col, item ->
//            findSum(prefixArray, k, row, col)
//        }
//    }
    private fun findSum(prefixMat: MutableList<IntArray>, target: Int, row: Int, col: Int): Int {

        val rowSize = prefixMat.size
        val colSize = prefixMat[0].size
        var max = 0
        var tempSum = 0
        // Row Iterate
        for (i in col..colSize) {
            if (tempSum + prefixMat[row][i] <= target) {
                tempSum += prefixMat[row][i]
            } else { // Crossed Target
                break
            }
        }
        max = max(max, tempSum)
        tempSum = 0
        // Column Iterate
        for (j in row..rowSize) {
            if (tempSum + prefixMat[j][col] <= target) {
                tempSum += prefixMat[j][col]
            } else { // Crossed Target
                break
            }
        }
        max = max(max, tempSum)
        return max
    }
}

fun main() {
    MaxSumOfRectangleNoLargerThanK().apply {
//        println(maxSumSubmatrix(build2DArray("[[2,2,-1]]"), 3))
//        println(maxSumSubmatrix(build2DArray("[[2,2,-1]]"), -1))
//        println(maxSumSubmatrix(build2DArray("[[1,0,1],[0,-2,3]]"), 2))
//        println(maxSumSubmatrix(build2DArray("[[1,2,3],[4,5,6],[7,8,9]]"), 3))
        println(maxSumSubmatrix(build2DArray("[[5,-4,-3,4],[-3,-4,4,5],[5,1,5,-4]]"), 8))
    }
}