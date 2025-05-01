package leet

class ZigzagConversion {
    fun convert(s: String, numRows: Int): String {

        if (numRows == 1) {
            return s
        }
        val l = s.length
        val midColumn = numRows - 2

        var numColumns = 0
        var noOfChars = 0

        while (noOfChars < l) {
            noOfChars += numRows
            numColumns += 1

            if (midColumn > 0) {
                noOfChars += Math.min(midColumn, l - noOfChars)
                if (noOfChars <= l) {
                    numColumns += midColumn
                }
            }
        }

        val inputArray = s.toCharArray()

        val res = Array(numRows) { Array(numColumns) { "" } }
        var idx = 0

        for (column in 0 until numColumns step midColumn + 1) {
            for (row in 0 until numRows) {
                res[row][column] = inputArray.getOrNull(idx++)?.toString() ?: ""
            }
            var tRow = numRows - 1 - 1
            var tColumn = column + 1
            for (m in 0 until midColumn) {
                if (tRow < numRows && tColumn < numColumns) {
                    res[tRow--][tColumn++] = inputArray.getOrNull(idx++)?.toString() ?: ""
                }
            }
        }
        // println("[$numRows, $numColumns]")

        var resultStr = ""
        res.forEach {
            it.forEach { v ->
                resultStr += v
            }
        }
        return resultStr
    }
}

fun main() {

    ZigzagConversion().apply {
        // println(convert("PAYPALISHIRING", 2))
        //println(convert("PAYPALISHIRING", 3))
        //println(convert("PAYPALISHIRING", 4))
//        println(convert("A", 1))

        println(convert("ABCD", 3)) // ABDC
        println(convert("ABCDE", 4)) // ABCED
    }
}


