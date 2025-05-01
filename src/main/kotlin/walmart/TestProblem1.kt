package walmart

/**
 * Remove minimum elements from array such that no three consecutive element
 * are either increasing or decreasing
 *
 */
class Result {

    /*
     * implement method/function with name 'solve' below.
     *
     * The function accepts following parameters
     *1. ar is of type INTEGER ARRAY.
     * The function is expected to return a value of type Int.
     */
    companion object {
        fun solve(input: ArrayList<Int>): Int {

            val size = input.size
            var result = 0
            var i = 0
            var j = 0
            var tResult = 0
            input.forEachIndexed { index, current ->
                // Increasing
                i = index
                j = index + 1
                var k = 1
                while (j < size) {
                    if (input[j] > input[i]) {
                        k++
                    } else {
                        break
                    }
                    if (k >= 3) {
                        tResult += 1
                    }
                    j++
                    i++
                }
                result = Math.max(result, tResult)

                // Decreasing
                i = index
                j = index + 1
                k = 1
                while (j < size) {
                    if (input[j] < input[i]) {
                        k++
                    } else {
                        break
                    }
                    if (k >= 3) {
                        tResult += 1
                    }
                    j++
                    i++
                }
                result = Math.max(result, tResult)
                tResult = 0
            }
            return result
        }
    }
}

fun main(args: Array<String>) {
    //println(Result.solve(arrayListOf(1, 2, 4, 1, 2)))
//    println(Result.solve(arrayListOf(1, 2, 3, 5)))
//    println(Result.solve(arrayListOf(1, 2, 3, 5, 4, 1, 2, 3, 5)))
    println(Result.solve(arrayListOf(1, 2, 3, 6, 5, 4, 8)))
}
