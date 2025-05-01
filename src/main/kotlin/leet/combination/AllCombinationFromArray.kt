package leet.combination

import java.util.*

/**
 * nCr = n!/ r! * (n-r)!
 * Time complexity = O(2^n)
 */
class AllCombinationFromArray {
    fun findCombination(input: IntArray, k: Int): Any {

        val output = mutableListOf<List<Int>>()
        val temp = ArrayDeque<Int>()
        findCombinationInternal(input, output, temp, k, 0)
        return output
    }

    private fun findCombinationInternal(
        input: IntArray,
        output: MutableList<List<Int>>,
        temp: ArrayDeque<Int>,
        target: Int,
        idx: Int
    ) {
        if (temp.size == target) {
            output.add(temp.toList().reversed())
            return
        }
        if (idx >= input.size) {
            return
        }
        // Include
        temp.push(input[idx])
        findCombinationInternal(input, output, temp, target, idx + 1)

        //Exclude
        temp.removeFirst()
        findCombinationInternal(input, output, temp, target, idx + 1)
    }
}

fun main() {
    AllCombinationFromArray().apply {

        // = 5!/ 2! * (5-2)!
        // = 5!/ (2! * 3!) = (1*2*3*4*5)/ (1*2 * 1*2*3) = 120 / 12 = 10
        // Total Combination = 10
//        println(findCombination(intArrayOf(1, 2, 3, 4), 2))
        println(findCombination(intArrayOf(1, 2, 3, 4, 5), 3))


    }
}