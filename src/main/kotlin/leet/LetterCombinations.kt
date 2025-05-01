package leet

class LetterCombinations {
    fun letterCombinations(inputDigits: String): List<String> {
        val digitStrMap: Map<Char, List<Char>> = mapOf(
            '2' to "abc".toList(),
            '3' to "def".toList(),
            '4' to "ghi".toList(),
            '5' to "jkl".toList(),
            '6' to "mno".toList(),
            '7' to "pqrs".toList(),
            '8' to "tuv".toList(),
            '9' to "wxyz".toList()
        )
        if (inputDigits.isEmpty()) {
            return emptyList()
        }
        if (inputDigits.length == 1) {
            return digitStrMap[inputDigits[0]]?.map { "$it" } ?: emptyList()
        }

        val answer = mutableListOf<String>()
        findCombination(inputDigits, digitStrMap, answer, "",0)
        return answer
    }

    private fun findCombination(
        inputDigits: String,
        digitStrMap: Map<Char, List<Char>>,
        answer: MutableList<String>,
        result: String,
        d: Int
    ) {

        if (result.length == inputDigits.length || d >= inputDigits.length) {
            answer.add(result)
            return
        }
        digitStrMap[inputDigits[d]]!!.forEach { c ->
            findCombination(inputDigits, digitStrMap, answer, "$result$c", d + 1)
        }

    }
}

fun main() {
    LetterCombinations().apply {
        val input = listOf("23", "2", "", "5678")
        // 23- ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        // 2 - ["a","b","c"]
        //   - []
        input.forEach {
            println("[$it]  => ${letterCombinations(it)}")
        }
    }
}