package leet.common

fun buildSumSuffix(list: List<Int>): List<Int> {
    var suffix = 0
    return list.reversed().map {
        suffix += it
        suffix
    }
}

/**
 * SuffixArray[i] stores product of all elements after i-th index in the array
 * ex:
 *  0, 1, 2, 3, 4
 *  1, 2, 3, 4, 5
 *
 *  SuffixArray[0] = SA[1] x SA[2] X SA[3] x SA[4] = (2 x 3 x 4 x 5) = 120
 *  SuffixArray[1] =         SA[2] X SA[3] x SA[4] = (    3 x 4 x 5) =  60
 *  SuffixArray[2] =                 SA[3] x SA[4] = (        4 x 5) =  20
 *  SuffixArray[3] =                         SA[4] = (            5) =   5
 *  SuffixArray[4] =                               = (             ) =   1
 */
fun buildProductSuffix(list: List<Int>): List<Int> {
    var suffix = 1
    val reversedList = list.reversed()
    return reversedList.mapIndexed { index, _ ->
        // For the First/Last(Originally) element it should be '1'
        if (index == 0) {
            suffix
        } else {
            suffix *= reversedList[index - 1]
            suffix
        }
    }.reversed()
}

fun main() {
    mutableListOf(1, 2, 3, 4).apply {
        println(buildSumSuffix(this))
        println(buildProductSuffix(this))
    }
    mutableListOf(1, 2, 3, 4, 5).apply {
        println(buildProductSuffix(this))
    }
}

