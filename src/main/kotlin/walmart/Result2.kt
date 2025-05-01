package walmart

class Result2 {
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