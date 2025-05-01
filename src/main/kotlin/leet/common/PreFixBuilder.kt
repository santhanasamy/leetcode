package leet.common


fun buildSumPreFix(list: List<Int>): List<Int> {
    var preFix = 0
    return list.map {
        preFix += it
        preFix
    }
}

/**
 * PrefixArray[i] stores product of all elements before i-th index in the array.
 * ex:
 *  0, 1, 2, 3, 4
 *  1, 2, 3, 4, 5
 *
 *  PrefixArray[0] =                               = (             ) =   1
 *  PrefixArray[1] =                         PA[0] = (            1) =   1
 *  PrefixArray[2] =                 PA[0] x PA[1] = (        1 x 2) =   2
 *  PrefixArray[3] =         PA[0] X PA[1] x PA[2] = (    1 x 2 x 3) =   6
 *  PrefixArray[4] = PA[0] x PA[1] X PA[2] x PA[3] = (1 x 2 x 3 x 4) =  24
 */
fun buildProductPreFix(list: List<Int>): List<Int> {
    var preFix = 1
    return list.mapIndexed { index, _ ->
        // For the first element it should be '1'
        if (index == 0) {
            preFix
        }
        // For all other element it should be [PreFix of previous x Previous Item]
        else {
            preFix *= list[index - 1]
            preFix
        }
    }
}

fun main() {
    mutableListOf(1, 2, 3, 4).apply {
        println(buildSumPreFix(this))
        println(buildProductPreFix(this))
    }
    mutableListOf(1, 2, 3, 4, 5).apply {
        println(buildSumPreFix(this))
        println(buildProductPreFix(this))
    }

}