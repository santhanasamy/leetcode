package leet

import java.util.ArrayDeque

class RegularExpressionMatching {
    fun isMatch(s: String, p: String): Boolean {
        if (p == ".*") {
            return true
        }
        val input = s.toCharArray()
        val symbol = p.toCharArray()

        val inputStack = ArrayDeque<Char>()
        val symbolStack = ArrayDeque<Char>()
        var i = 0
        var cSymbol: Char

        run break1@{
            input.forEachIndexed { index, c ->
                cSymbol = symbol.getOrNull(i) ?: return@break1

                inputStack.push(c)
                symbolStack.push(cSymbol)

                if (cSymbol == '*') {
                    val pZeroOrManyChar = symbol[i - 1]

                    var tempC: Char
                    var tempS: Char?
                    while (inputStack.isNotEmpty()) {
                        tempC = inputStack.pop()
                        tempS = if (symbolStack.isNotEmpty()) symbolStack.pop() else null
                        if (!(tempC == pZeroOrManyChar || tempC == tempS)) {
                            return false
                        }
                    }
                } else if (cSymbol == '.') {
                    var tempC: Char
                    var tempS: Char
                    while (inputStack.isNotEmpty()) {
                        tempC = inputStack.pop()
                        tempS = symbolStack.pop()
                        if (!(tempC == tempS || tempC == '.')) {
                            return false
                        }
                    }
                }

                i++
            }
        }

        return inputStack.isEmpty()
    }
}

fun main() {
    // '.' Matches any single character.
    // '*' Matches zero or more of the preceding element.
    // .*" means "zero or more (*) of any character (.)
    RegularExpressionMatching().apply {
//        require(!isMatch("aa", "a")) { "aa => a No Match" }
//        require(isMatch("aa", "a*")) { "aa => a* Match" }
//        require(isMatch("ab", ".*")) { "aa => a* Match" }
        require(!isMatch("aab", "c*a*b")) { "aab => c*a*b No Match" }
        require(!isMatch("mississippi", "mis*is*p*.")) { "mississippi => mis*is*p*. No Match" }
    }
}