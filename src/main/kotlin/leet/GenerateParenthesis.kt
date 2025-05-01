package leet

class GenerateParenthesis {
    fun generateParenthesis(n: Int): List<String> {
        val resultList = mutableListOf<String>()
        generatePair(resultList, "(", n - 1, n)
        return resultList
    }

    private fun generatePair(resultList: MutableList<String>, tempRes: String, open: Int, close: Int) {
        if (close < open) {
            return
        }

        if (open == 0 && close == 0) {
            resultList.add(tempRes)
            return
        }
        if (open > 0) {
            generatePair(resultList, "$tempRes(", open - 1, close)
        }
        if (close > 0) {
            generatePair(resultList, "$tempRes)", open, close - 1)
        }
    }
}

fun main() {
    GenerateParenthesis().apply {
        println(generateParenthesis(1)) // ()
        println(generateParenthesis(2)) // (()), ()()
        println(generateParenthesis(3)) // (()()), ()()(), (())(), ()(()), ((()))
        // aababb, ababab, aabbab, abaabb, aaabbb
    }
}