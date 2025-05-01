package leet

class CountHiddenSequence {
    fun countHiddenSequence(input: IntArray, lower: Int, upper: Int): Int {


        val j = 0
        for (i in lower..upper) {
            findSequence(input, input[j], i)
        }

        return 0
    }

    private fun findSequence(input: IntArray, target: Int, r: Int) {



    }
}

fun main() {
    CountHiddenSequence().apply {
        println(countHiddenSequence(intArrayOf(1, -3, 4), 1, 6))  // 2
        println(countHiddenSequence(intArrayOf(3, -4, 5, 1, -2), -4, 5)) // 4
        println(countHiddenSequence(intArrayOf(4, -7, 2), 3, 6)) // 0
    }
}


//differences = [1,-3,4], lower = 1, upper = 6

//- [3, 4, 1, 5]
//- [4, 5, 2, 6]
//Thus, we return 2.
//
//1, 2, 3, 4, 5, 6
//1, -3, 4
//
// 1  -> 2,1 3,2 4,3 5,4 6,5
//-3 -> (2 + x = -3) =>  (2,5) (1,4)
// 4 -> (2 - x = 4) => (2,6) (1,-5)

